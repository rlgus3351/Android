package com.example.dbtest0707;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    //------------------------------------- DATABASE SETTING -------------------------------------//
    private static final String DATABASE_NAME = "bgr.db";
    private static final int DATABASE_VERSION = 2;
    //------------------------------------- TABLE SETTING ----------------------------------------//
    public static final String TABLE_NAME = "userInfo";
    public static final String COLUMN_IDX = "idX";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PW = "pw";
    public static final String COLUMN_NAME = "name";

    public static final String COLUMN_DATE = "date";
    private static String DB_PATH = "";
    // TODO : assets 폴더에 있는 DB명 또는 별도의 데이터베이스 파일이름
    private Context mContext;
    private static SQLiteDatabase mDataBase;
    private static final String DATABASE_CREATE_TABLE = "create table "
            + TABLE_NAME + "(" + COLUMN_IDX + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ID + " TEXT, "
            + COLUMN_PW + " TEXT, "
            + COLUMN_NAME + " TEXT,"
            + COLUMN_DATE + " TIMESTAMP DEFAULT (datetime('now','+9 hours')));";

    //------------------------------------- SQLite Helper ----------------------------------------//

    public SQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.mContext = context;
        dataBaseCheck();
    }

    private void dataBaseCheck(){
        File dbFile = new File(DB_PATH + DATABASE_NAME);
        if(!dbFile.exists()){
            dpCopy();
            Log.v("DataBaseHelper","DataBase is Copied");
        }
    }
    private void dpCopy(){
        try{
            File folder = new File(DB_PATH);
            if(!folder.exists()){
                folder.mkdir();
            }

            InputStream inputStream = mContext.getAssets().open(DATABASE_NAME);
            String out_filename = DB_PATH + DATABASE_NAME;
            OutputStream outputStream = new FileOutputStream(out_filename);
            byte[] mBuffer = new byte[1024];
            int mLength;
            while((mLength = inputStream.read(mBuffer)) > 0){
                outputStream.write(mBuffer,0,mLength);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    //------------------------------------- CREATE TABLE -----------------------------------------//

    // 앱을 삭제 후 앱을 재 설치하면 기존 DB파일은 앱 삭제시 지워지지 않기 때문에 이미 생성되었다고 에러난다.
    // 앱을 재설치시 데이터 베이스를 삭제해줘야 한다.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(DATABASE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //------------------------------------- INSERT DATA -----------------------------------------//
    public boolean insertData(String id, String name, String pw){
        long result = -1;
        Log.v("id" ,"value : " + id);
        Log.v("pw" ,"value : " + pw);
        Log.v("name" ,"value : " + name);

        if((id != null) & (name != null) & (pw != null)){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_ID,id);
            contentValues.put(COLUMN_NAME,name);
            contentValues.put(COLUMN_PW,pw);
            result = db.insert("userInfo", null, contentValues);
        }
        if (result == -1){
            Log.v("userInfo insert : " ,":" + result);
            Log.v("userInfo insert : " ,"fail");
            return false;
        }else{
            Log.v("userInfo insert : " ,"true");
            return true;
        }
    }
    //------------------------------------- LOGIN CHECK DATA -------------------------------------//
    public boolean selectData(String id, String pw){
        Cursor cursor = null;
        int row = 0;
        if ((id != null) & (pw != null)){
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "select * from "
                    + "userInfo" +
                    " where "+ "id" + " = '" + id + "' and " + "pw" + " = '" + pw +"'";
            Log.v("SQL check","SQL : " + sql);
            cursor = db.rawQuery(sql,null);
            Log.v("Count check","COUNT : " + cursor.getCount());
            row = cursor.getCount();
        }
        if (row >0){
            return true;
        }else{
            return false;
        }

    }
    //------------------------------------- CLOSE DATABASE ---------------------------------------//
    public void closeDB(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.close();
    }

    public SQLiteDatabase openDB(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db;
    }
    //------------------------------------- MUSIC INFORMATION QUERY ------------------------------//
    public ArrayList<MusicDTO> musicInfo(){

        String sql = "select * from mp_info";
        ArrayList<MusicDTO> allMusic = new ArrayList<MusicDTO>();
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql,null);
            if(cursor.getCount()>0){
                for(int i=0; i<cursor.getCount(); i++){
                    int musicIdx = cursor.getInt(0);
                    String musicName = cursor.getString(1);
                    String musicAnswer = cursor.getString(2);
                    MusicDTO music = new MusicDTO(musicIdx,musicName,musicAnswer);
                    allMusic.add(music);

                }
            }
        }catch (Exception e){
            Log.v("SQLiteHelper", "Musicinfo Error");
            return null;
        }

    return allMusic;
    }

}



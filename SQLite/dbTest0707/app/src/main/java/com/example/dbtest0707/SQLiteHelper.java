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
    //------------------------------------ DATABASES FOLDERS FILE CHECK -------------------------//
    private void dataBaseCheck(){
        // 해당 폴더(경로 : DATABASES 폴더 하위에 DATABASE_NAME과 같은 데이터베이스가 있는지 체크
        File dbFile = new File(DB_PATH + DATABASE_NAME);
        if(!dbFile.exists()){
            // 파일이 존재 하지 않을 때 dbCopy 메소드를 실행
            dpCopy();
            // 복사 완료후 Log로 확인
            Log.v("DataBaseHelper","DataBase is Copied");
        }
    }
    //------------------------------------ DATABASES COPY METHOD ---------------------------------//
    private void dpCopy(){
        // 예외 처리로 파일을 복사하자 파일 관련해서 소스 코드 처리할 땐 예외 처리 구문을 활용
        try{
            // 어플, 기기 폴더 (Device File Explorer) 아래 data/data/databases 폴더에 접근
            File folder = new File(DB_PATH);
            // 해당 경로에 폴더가 없으면 폴더 생성
            if(!folder.exists()){
                // 폴더 만들기 메소드
                folder.mkdir();
            }

            // InputStream -> 바이트의 입력 스트림을 나타내는 최상위 클래스
            InputStream inputStream = mContext.getAssets().open(DATABASE_NAME);
            // databases위치 -> /data/data/com.example.project명/databases/데이터베이스이름으로 저장하기 위해서 변수 설정
            String out_filename = DB_PATH + DATABASE_NAME;
            // OutputStream -> 바이트의 출력 스트림을 나타내는 최상위 클래스
            OutputStream outputStream = new FileOutputStream(out_filename);
            // file을 읽고 출력하는데 1024byte로 읽어서 1Kb씩 저장하도록 만들며
            byte[] mBuffer = new byte[1024];
            int mLength;
            // 입력 스트림의 읽은 byte의 값이 0 작으면 : 파일 복사 완료 -> 조건문
            while((mLength = inputStream.read(mBuffer)) > 0){
                // outputStream.write 기능으로 읽어온 byte를 써준다.
                outputStream.write(mBuffer,0,mLength);
            }
            // 스트림 버퍼에 있는 데이터 강제적으로 출력
            outputStream.flush();
            // 사용한 입,출력 스트림 닫아주기
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
//    public ArrayList<MusicDTO> musicInfo(){
//
//        String sql = "select * from mp_info";
//        ArrayList<MusicDTO> allMusic = new ArrayList<MusicDTO>();
//        try{
//            SQLiteDatabase db = this.getWritableDatabase();
//            Cursor cursor = db.rawQuery(sql,null);
//            if(cursor.getCount()>0){
//                for(int i=0; i<cursor.getCount(); i++){
//                    int musicIdx = cursor.getInt(0);
//                    String musicName = cursor.getString(1);
//                    String musicAnswer = cursor.getString(2);
//                    MusicDTO music = new MusicDTO(musicName,musicAnswer);
//                    allMusic.add(music);
//
//                }
//            }
//        }catch (Exception e){
//            Log.v("SQLiteHelper", "Musicinfo Error");
//            return null;
//        }
//
//    return allMusic;
    }

}



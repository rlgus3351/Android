package com.example.dbtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {

    //------------------------------------- DATABASE SETTING -------------------------------------//
    private static final String DATABASE_NAME = "bgr.db";
    private static final int DATABASE_VERSION = 1;
    //------------------------------------- TABLE SETTING ----------------------------------------//
    public static final String TABLE_NAME = "userInfo";
    public static final String COLUMN_IDX = "idX";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PW = "pw";
    public static final String COLUMN_NAME = "name";
    private static String DB_PATH = "";
    // TODO : assets 폴더에 있는 DB명 또는 별도의 데이터베이스 파일이름

    private static SQLiteDatabase mDataBase;
    private static final String DATABASE_CREATE_TABLE = "create table "
            + TABLE_NAME + "(" + COLUMN_IDX + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ID + " TEXT, "
            + COLUMN_PW + " TEXT, "
            + COLUMN_NAME + " TEXT);";

    //------------------------------------- SQLite Helper ----------------------------------------//

    public SQLiteHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
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
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,id);
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_PW,pw);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }
    //------------------------------------- LOGIN CHECK DATA -------------------------------------//
    public boolean selectData(String id, String pw){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from " + TABLE_NAME + " where "+ COLUMN_ID + " = '" + id + "' and " + COLUMN_PW + " = '" + pw +"'";
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor != null){
            return true;
        }else{
            return false;
        }

    }




}


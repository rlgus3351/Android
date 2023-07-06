package com.example.dbchart.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {

    //------------------------------------- DATABASE SETTING -------------------------------------//
    private static final String DATABASE_NAME = "bgr.db";
    private static final int DATABASE_VERSION = 1;
    private static String DB_PATH = "";

    private static SQLiteDatabase mDataBase;
    //-------------------------------------USER TABLE SETTING ------------------------------------//
    private static final String DATABASE_CREATE_USER_TABLE = "create table userInfo " +
            "(idx integer primary key autoincrement,"
            + "id text,"
            + "pw text,"
            + "name text,"
            + "date timestamp default (datetime('now','+9 hours')))";
    //-------------------------------------RESULT TABLE SETTING ------------------------------------//
    private static final String DATABASE_CREATE_RESULT_TABLE = "create table resultInfo "+
            "(idx integer primary key autoincrement,"
            + "id text, "
            + "test text, "
            + "content text, "
            + "date timestamp default (datetime('now' , '+9 hours')))";
    //-------------------------------------RESULT TABLE INSERT ------------------------------------//
    private static final String DATABASE_INSERT1_RESULT_TABLE = "insert into resultInfo(id,test,content)" +
            " values('test','변별훈련1','x')";
    private static final String DATABASE_INSERT2_RESULT_TABLE = "insert into resultInfo(id,test,content)" +
            " values('test','변별훈련2','x')";
    private static final String DATABASE_INSERT3_RESULT_TABLE = "insert into resultInfo(id,test,content)" +
            " values('test','변별훈련3','x')";
    //------------------------------------- SQLite Helper ----------------------------------------//

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
    }

    //------------------------------------- CREATE TABLE -----------------------------------------//

    // 앱을 삭제 후 앱을 재 설치하면 기존 DB파일은 앱 삭제시 지워지지 않기 때문에 이미 생성되었다고 에러난다.
    // 앱을 재설치시 데이터 베이스를 삭제해줘야 한다.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS userInfo");
        db.execSQL(DATABASE_CREATE_USER_TABLE);
        db.execSQL(DATABASE_CREATE_RESULT_TABLE);
        db.execSQL(DATABASE_INSERT1_RESULT_TABLE);
        db.execSQL(DATABASE_INSERT2_RESULT_TABLE);
        db.execSQL(DATABASE_INSERT3_RESULT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS userInfo");
        onCreate(db);
    }

    //------------------------------------- INSERT DATA -----------------------------------------//
    public boolean insertData(String id, String name, String pw) {
        long result = -1;
        Log.v("id", "value : " + id);
        Log.v("pw", "value : " + pw);
        Log.v("name", "value : " + name);

        if ((id != null) & (name != null) & (pw != null)) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", id);
            contentValues.put("pw", name);
            contentValues.put("name", pw);
            result = db.insert("userInfo", null, contentValues);
        }
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //------------------------------------- LOGIN CHECK DATA -------------------------------------//
    public boolean selectData(String id, String pw) {
        Cursor cursor = null;
        int row = 0;
        if ((id != null) & (pw != null)) {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "select * from userInfo " +
                    "where id = " +"'"+ id +"'"+ " and pw = " + "'"+ pw+"'";
            Log.v("SQL check", "SQL : " + sql);
            cursor = db.rawQuery(sql, null);
            Log.v("Count check", "COUNT : " + cursor.getCount());
            row = cursor.getCount();
        }
        if (row > 0) {
            return true;
        } else {
            return false;
        }

    }

    //------------------------------------- CLOSE DATABASE ---------------------------------------//
    public void closeDB() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.close();
    }

    public SQLiteDatabase openDB() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db;
    }

}

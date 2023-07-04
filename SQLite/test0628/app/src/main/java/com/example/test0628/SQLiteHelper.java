package com.example.test0628;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper{

    // DATABASE_NAME
    private static final String DATABASE_NAME = "mytest.db";

    // DATABASE_VERSION
    private static final int DATABASE_VERSION = 1;

    public SQLiteHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    // ------------------------------------USER JOIN SQL------------------------------------------//
    public void user_join(SQLiteDatabase db, String id, String pw,String name){

        db.execSQL(
                "insert into user_info(user_id, user_pw, user_name) values("+id+","+pw+","+"name"+");"
        );
    }

    // ------------------------------------USER LOGIN SQL------------------------------------------//
    public void user_login(SQLiteDatabase db, String id, String pw,String name){

    }

}

package com.example.test0628;

import android.provider.BaseColumns;

public final class User {
    // 기본 생성자
    private User(){

    }

    // table 구성

    public static class User implements BaseColumns{
        public static final String TABLE_NAME = "user";
        public static final String user_id = "user_id";
        public static final String user_pw = "user_pw";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS"+ TABLE_NAME + "("+
                        _ID + "INTEGER PRIMARY KEY," +
                        user_id +" TEXT,"+
                        user_pw +" TEXT)";
        public static final String SQL_DELETE_TABLE=
                "DROP TABLE IF EXISTS"+TABLE_NAME;
    }

}

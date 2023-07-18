package com.example.dbtest0707;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SQLiteControl {

    SQLiteHelper helper;
    SQLiteDatabase sqlite;
    public SQLiteControl(SQLiteHelper helper){
        this.helper = helper;
    }
    public ArrayList<MusicDTO> musicList(){
        ArrayList<MusicDTO> mList = new ArrayList<MusicDTO>();
        try{
            sqlite = helper.getReadableDatabase();
            String strSQL = "select mp_name, mp_answer from mp_info";
            Cursor cursor = sqlite.rawQuery(strSQL,null);
            Log.v("SQLiteControl" ,"arrayList size = " + cursor.getCount() );
            while(cursor.moveToNext()){
                String name = cursor.getString(0);
                String answer = cursor.getString(1);
                MusicDTO music = new MusicDTO(name,answer);
                mList.add(music);
            }
            Log.v("SQLiteControl" ,"arrayList size = " + mList.size() );
        }catch (Exception e){
            Log.v("SQLiteControl" ,"Music Select SQL Error");
            return null;
        }
        return mList;
    }
}

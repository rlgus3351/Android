package com.example.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLInput;

public class RegisterActivity extends AppCompatActivity {

    SQLiteHelper mSQLiteHelper;
    Button btn_register;
    SQLiteDatabase mdb;

    EditText et_id, et_pass, et_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Register", "btn_register.On.Click");
//                ContentValues contentValues = new ContentValues();
//                contentValues.put("id", et_id.getText().toString());
//                contentValues.put("pw", et_pass.getText().toString());
//                contentValues.put("name", et_name.getText().toString());
//                long isInserted = mdb.insert("userInfo", null, contentValues);

            }
        });
    }
}

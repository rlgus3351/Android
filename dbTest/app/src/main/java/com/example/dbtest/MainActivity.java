package com.example.dbtest;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_id,et_pass;
    Button btn_login;
    Button btn_register;
    SQLiteHelper mSQLiteHelper;


    public static final String TABLE_NAME = "userInfo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        //---------------------------------------DATABASE-----------------------------------------//
        mSQLiteHelper = new SQLiteHelper(this);

        //---------------------------------------LOGIN CLICK--------------------------------------//
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = mSQLiteHelper.insertData(et_id.getText().toString(), "test", et_pass.getText().toString());
//                boolean isInserted = mSQLiteHelper.selectData(et_id.getText().toString(), et_pass.getText().toString());
                if(isInserted){
                    Toast.makeText(MainActivity.this, "Data Inserted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });



        //---------------------------------------REGISTER CLICK------------------------------------//
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("RegisterActivity", "btn_register.On.Click");
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
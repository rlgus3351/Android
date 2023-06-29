package com.example.test0628;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnJoin;
    Button btnLogIn;
    TextView titleView;
    SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteHelper = new SQLiteHelper(this);
//        ArrayList<String> nameList = sqLiteHelper.getMemberNames();
        //-----------------------------------------------------------------DATABASE------------------------------------------------------------------//
        titleView = findViewById(R.id.textView);
//        titleView.setText(nameList.toString());

        //-----------------------------------------------------------------JOIN------------------------------------------------------------------//
        // 회원 가입 버튼
        btnJoin = (Button) findViewById(R.id.btnJoin);

        // 회원 가입 페이지 이동
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("LoginActivity","btnJoin.On.Click()");
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------------------------------------LOGIN------------------------------------------------------------------//
        // 로그인 버튼
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        


    }
}
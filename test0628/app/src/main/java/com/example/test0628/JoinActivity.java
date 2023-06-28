package com.example.test0628;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JoinActivity extends AppCompatActivity {

    EditText editName;//name

    EditText editEmail;//Email
    EditText editPw;//password

    Button submitBtn;

    SQLiteDatabase db;
    static final String DB_NAME ="database";
    static final String TABLE_NAME = "user";

    protected void createDatabase(){
        db = openOrCreateDatabase(
                DB_NAME, // 데이터 베이스의 이름
                MODE_PRIVATE, // 다른 앱에서의 접근 가능 범위
                null //
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        submitBtn = (Button) findViewById(R.id.submitJoin);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName = (EditText) findViewById(R.id.editName);
                editEmail = (EditText) findViewById(R.id.editEmail);
                editPw = (EditText) findViewById(R.id.editPassword);
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String pw = editPw.getText().toString();
                
                // 값을 DB에 저장 -> 회원가입 구문 필요
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("pw",pw);
                startActivity(intent);
            }
        });
        // 값 가져오기

    }
}
package com.example.test0627;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JoinActivity extends AppCompatActivity {

    EditText editName;//name

    EditText editEmail;//Email
    EditText editPw;//password

    Button submitBtn;
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
                Intent intent = new Intent(getApplicationContext(), testActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("pw",pw);
                startActivity(intent);
            }
        });
        // 값 가져오기

    }
}
package com.example.dbtest0703;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends MainActivity {
    // ----------------------------------------REGISTER ACTIVITY----------------------------------//
    SQLiteHelper mSQLiteHelper;
    Button btn_register;
    SQLiteDatabase mdb;

    EditText et_id, et_pass, et_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        btn_register = (Button) findViewById(R.id.btn_register);

        mSQLiteHelper = new SQLiteHelper(this);

        // --------------------------REGISTER BUTTON CLICK EVENT START----------------------------//
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Register", "btn_register.On.Click");

                // -------------------------SELECT SELECTOR---------------------------------------//
                et_id = findViewById(R.id.et_id);
                et_pass = findViewById(R.id.et_pass);
                et_name = findViewById(R.id.et_name);

                // -------------------------LOG VALUE CHECK---------------------------------------//
                Log.v("id value check", ":" + et_id.getText().toString());
                Log.v("pass value check", ":" + et_pass.getText().toString());
                Log.v("name value check", ":" + et_name.getText().toString());

                // -------------------------TOAST VALUE CHECK-------------------------------------//
                if(et_id.getText().toString().length() ==0){
                    Toast.makeText(RegisterActivity.this, "id를 입력해주세요.",
                            Toast.LENGTH_LONG).show();
                }
                if(et_pass.getText().toString().length() ==0){
                    Toast.makeText(RegisterActivity.this, "pw를 입력해주세요.",
                            Toast.LENGTH_LONG).show();
                }
                if(et_name.getText().toString().length() ==0){
                    Toast.makeText(RegisterActivity.this, "name를 입력해주세요.",
                            Toast.LENGTH_LONG).show();
                }

                // -------------------------EDITTEXT INSERT DB------------------------------------//
                int id_check = et_id.getText().toString().length();
                int pw_check = et_pass.getText().toString().length();
                int name_check = et_name.getText().toString().length();

                if((id_check>0) & (pw_check>0) & (name_check>0)){
                    boolean isInserted = mSQLiteHelper.insertData(
                            et_id.getText().toString(), // 아이디 입력값
                            et_pass.getText().toString(), // 비밀번호 입력값
                            et_name.getText().toString()); // 이름 입력값
                    if(isInserted){
                        // ---------------------DATABASE INSERT SUCCESS---------------------------//
                        Log.v("Join Success", "Success");
                        Toast.makeText(RegisterActivity.this,
                                "Join Success",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        // ---------------------DATABASE INSERT FAIL------------------------------//
                        Log.v("Join Fail", "Fail");
                        Toast.makeText(RegisterActivity.this,
                                "Join Fail",Toast.LENGTH_LONG).show();
                    }
                }



            }
        });
        // --------------------------REGISTER BUTTON CLICK EVENT END------------------------------//
    }
}

package com.example.dbtest0707;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("packageName","value : " + getPackageName());

        //--------------------------------------- DATABASE ---------------------------------------//
        mSQLiteHelper = new SQLiteHelper(this);

        //--------------------------------------- SELECTTOR --------------------------------------//
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        btn_login = (Button) findViewById(R.id.btn_login);

        //---------------------------------------LOGIN CLICK START--------------------------------//
        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean isInserted = false;
                // -----------------------------------DATA CHECK----------------------------------//
                if(et_pass.getText().toString() == null){
                    Toast.makeText(MainActivity.this,
                            "비밀 번호를 입력해주세요",Toast.LENGTH_LONG).show();
                }else{
                    isInserted = mSQLiteHelper.selectData(
                            et_id.getText().toString(),
                            et_pass.getText().toString());
                }
                // -----------------------------------DATA INSERT---------------------------------//

                if(isInserted){
                    // -------------------------------DATA INSERT SUCCESS-------------------------//
                    Toast.makeText(MainActivity.this,
                            "Login Success",Toast.LENGTH_LONG).show();
                    Log.v("Login Success","Success");
                    mSQLiteHelper.closeDB();
                    Intent intent = new Intent(getApplicationContext(), PageActivity.class);
                    startActivity(intent);
                }else{
                    // -------------------------------DATA INSERT FAIL-------------------------//
                    Toast.makeText(MainActivity.this,
                            "Login Fail",Toast.LENGTH_LONG).show();
                    Log.v("Login Fail","Fail");
                }
            }
        });
        //---------------------------------------LOGIN CLICK END----------------------------------//


        //---------------------------------------REGISTER CLICK------------------------------------//
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("RegisterActivity", "btn_register_On_Click");
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
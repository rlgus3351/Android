package com.example.test0627;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class testActivity extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent secondIntent = getIntent();
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        pw = (TextView) findViewById(R.id.pw);
        name.setText(secondIntent.getStringExtra("name"));
        email.setText(secondIntent.getStringExtra("email"));
        pw.setText(secondIntent.getStringExtra("pw"));

    }
}
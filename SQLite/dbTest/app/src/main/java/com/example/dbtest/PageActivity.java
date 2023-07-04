package com.example.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PageActivity extends AppCompatActivity {
    ImageButton homeBtn;
    Button distrain1;
    Button distrain2;
    Button checktrain1;
    Button checktrain2;
    //--------------------------------- HOME BUTTON CLICK EVENT ----------------------------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);


        //--------------------------------- HOME BUTTON CLICK EVENT ------------------------------//
        homeBtn =(ImageButton) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("HOMEBUTTON","HOMEBUTTON CLICK");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //------------------------------- DISTRAIN1 BUTTON CLICK EVENT ---------------------------//
        distrain1 =(Button) findViewById(R.id.Distrain1);
        distrain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("HOMEBUTTON","HOMEBUTTON CLICK");
                Intent intent = new Intent(getApplicationContext(), Distrain1Activity.class);
                startActivity(intent);
            }
        });
        //------------------------------- DISTRAIN2 BUTTON CLICK EVENT ---------------------------//
        distrain2 =(Button) findViewById(R.id.Distrain2);
        distrain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Distrain2Activity.class);
                startActivity(intent);
            }
        });
        //---------------------------- CHECKTRAIN 1 BUTTON CLICK EVENT ---------------------------//
        checktrain1 =(Button) findViewById(R.id.checktrain1);
        checktrain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        //---------------------------- CHECKTRAIN 2 BUTTON CLICK EVENT ---------------------------//
        checktrain2 =(Button) findViewById(R.id.checktrain2);
        checktrain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
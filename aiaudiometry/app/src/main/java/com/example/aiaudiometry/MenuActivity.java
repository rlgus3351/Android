package com.example.aiaudiometry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {
    ImageButton imgBtnSpeech;

    ImageButton stResultListBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        imgBtnSpeech = (ImageButton) findViewById(R.id.imgBtnSpeech);
        imgBtnSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), speechTestMenu.class);
                startActivity(intent);
            }
        });

        stResultListBtn = (ImageButton) findViewById(R.id.stResultListBtn);
        stResultListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StResultList.class);
                startActivity(intent);
            }
        });

    }
}
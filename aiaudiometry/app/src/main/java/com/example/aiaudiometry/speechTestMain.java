package com.example.aiaudiometry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class speechTestMain extends AppCompatActivity {

    TextView speechMaintypeTitle;

    ImageButton speechTestMainPlayPause;

    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_test_main);
        Intent testMenu = getIntent();
        String type = testMenu.getStringExtra("type");
        speechMaintypeTitle = (TextView) findViewById(R.id.speechMaintypeTitle);
        speechMaintypeTitle.setText(type);
        //--------------------------------PLAY AND STOP BUTTON EVENT------------------------------//
        speechTestMainPlayPause = (ImageButton) findViewById(R.id.speechTestMainPlayPause);
        speechTestMainPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(speechTestMainPlayPause.isSelected()){
                    //음원 일시 중지
                    speechTestMainPlayPause.setSelected(false);
                    Log.v("check" ,"value : play");
                }else{
                    //음원 재생 중
                    speechTestMainPlayPause.setSelected(true);
                    Log.v("check" ,"value : pause");
                }
            }
        });

        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StResult.class);
                startActivity(intent);
            }
        });
    }
}
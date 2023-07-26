package com.example.aiaudiometry;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class speechTest extends AppCompatActivity {
    ImageButton speechTestPlayPause;
    Button speechTestBtn;
    TextView typeTitle;
    ImageButton speechTestMainPlayPause;
    // TODO: 2023-07-25 Intent에 담긴 테스트 방법으로 제목 설정하기
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_test);
        Intent testMenu = getIntent();
        String type = testMenu.getStringExtra("type");
        Log.v("type test" ,"value : " + type);
        //--------------------------------TEST START BUTTON EVENT---------------------------------//
        speechTestBtn = (Button) findViewById(R.id.speechTestBtn);
        speechTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), speechTestMain.class);
                intent.putExtra("type", type);
                Log.v("intent test " ,"value : " + intent.getStringExtra("type"));
                startActivity(intent);
            }
        });
        typeTitle = (TextView) findViewById(R.id.typeTitle);
        typeTitle.setText(type);
        // TODO: 2023-07-25 play 버튼 toggle 활성화
        //--------------------------------PLAY AND STOP BUTTON EVENT------------------------------//
        speechTestPlayPause = (ImageButton) findViewById(R.id.speechTestPlayPause);
        speechTestPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(speechTestPlayPause.isSelected()){
                    //음원 일시 중지
                    speechTestPlayPause.setSelected(false);
                    Log.v("check" ,"value : play");
                }else{
                    //음원 재생 중
                    speechTestPlayPause.setSelected(true);
                    Log.v("check" ,"value : pause");
                }
            }
        });
    }
}
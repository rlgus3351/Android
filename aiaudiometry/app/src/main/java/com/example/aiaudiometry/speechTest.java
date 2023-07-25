package com.example.aiaudiometry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class speechTest extends AppCompatActivity {
    ImageButton speechTestPlayPause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_test);
        speechTestPlayPause = (ImageButton) findViewById(R.id.speechTestPlayPause);
        speechTestPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("button test","test : "+speechTestPlayPause.getBackground().getCurrent().getAlpha());
                Log.v("button test",getResources().getResourceName(R.drawable.play));
                if(getResources().getResourceName(R.drawable.play).equals(speechTestPlayPause.getBackground().getClass().getName())){
                    Log.v("condition test" ,"true");

                    // TODO: 2023-07-25 play 버튼 toggle 활성화 
                }
            }
        });
    }
}
package com.example.mp3test;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_play;
    Button btn_check;
    Button btn_none;

    // mediaPlayer
    MediaPlayer mediaPlayer;

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_play = findViewById(R.id.btn_play);
        btn_check = findViewById(R.id.btn_check);
        btn_none = findViewById(R.id.btn_none);

        // 재생 버튼 눌렀을 때
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.music);
                mediaPlayer.start();

            }

        });

        // O 버튼 눌렀을 때
        btn_check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.reset();

                }
            }
        });
       // X 버튼을 눌렀을 때
        btn_none.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            }
        });
    }
}
package com.example.dbtest0707;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Distrain1Activity extends AppCompatActivity {
    // ----------------------------------------DISTRAIN_1 ACTIVITY--------------------------------//

    ProgressBar progressbar;
    Button d1x;
    Button d1o;
    Button d1PlayStop;
    Button dis1submit;
    TextView answerView;
    String[] file_temp = new String[]{"t_01","t_02","t_03","t_04","t_05","t_06","t_07","t_08","t_09","t_10","t_11","t_12"};
    ArrayList<String> answer = new ArrayList<>();
    int count = 1;
    MediaPlayer mediaPlayer;

    SQLiteHelper mSQLiteHelper;

    int i = 0;
    boolean visiblePb = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distrain1);
        //-------------------------------- Music Info Settings ---------------------------------//
        mSQLiteHelper = new SQLiteHelper(this);


        //-------------------------------- Media Player Settings ---------------------------------//

        int tmpId =idParser("t_01");
        Log.v("raw file ID" ,"value : " + tmpId);


        //-------------------------------- Progress Bar Settings ---------------------------------//
        ProgressBar progressbar = findViewById(R.id.progressBar);
        progressbar.setIndeterminate(false);
        progressbar.setProgress(0);
        progressbar.setVisibility(View.GONE); // Progressbar 시각기능 x
        Button d1PlayStop = findViewById(R.id.d1PlayStop);
        Button d1o = findViewById(R.id.d1o);
        Button d1x = findViewById(R.id.d1x);
        Button dis1submit = findViewById(R.id.dis1submit);
        //-------------------------------- Play and Stop button event ----------------------------//
        d1PlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressbar.setVisibility(View.VISIBLE); // Progressbar 시각기능 o
                visiblePb = true;
                mediaPlayer = MediaPlayer.create(Distrain1Activity.this, tmpId);
                mediaPlayer.start();
            }
        });
        //-------------------------------- Distrain Button O click event -------------------------//

        d1o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(visiblePb){
                    if(i<100){
                        i+=10;
                        count++;
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        int id = idParser(file_temp[count]);
                        Log.v("next Music" ,"value : " + id);
                        Log.v("Click Value" ," : O ");
                        mediaPlayer =MediaPlayer.create(Distrain1Activity.this, id);
                        mediaPlayer.start();
                        answer.add("O");
                    }
                    if (progressbar.getProgress()>=100){
                        Log.v("Progressbar done ", ":");
                        d1x.setVisibility(View.GONE);
                        d1o.setVisibility(View.GONE);
                        progressbar.setVisibility(View.GONE);
                        dis1submit.setVisibility(View.VISIBLE);
                    }
                    progressbar.setProgress(i);
                    Log.v("Progressbar value ", ":" + progressbar.getProgress());
                }

            }
        });
        //-------------------------------- Distrain Button X click event -------------------------//

        d1x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(visiblePb){
                    if(i<100){
                        i+=10;
                        count++;
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        int id = idParser(file_temp[count]);
                        Log.v("next Music" ,"value : " + id);
                        Log.v("Click Value" ," : X ");
                        mediaPlayer =MediaPlayer.create(Distrain1Activity.this, id);
                        mediaPlayer.start();
                        answer.add("X");
                    }
                    if (progressbar.getProgress()==100){
                        Log.v("Progressbar done ", ":");
                        d1x.setVisibility(View.GONE);
                        d1o.setVisibility(View.GONE);
                        progressbar.setVisibility(View.GONE);
                        dis1submit.setVisibility(View.VISIBLE);
                    }
                    progressbar.setProgress(i);
                    Log.v("Progressbar value ", ":" + progressbar.getProgress());

                }

            }
        });

        dis1submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PageActivity.class);
                startActivity(intent);
            }
        });
    }
    //-------------------------------- Music File id Parser Method -------------------------------//
    private int idParser(String name){
        String packagename = this.getPackageName();
        int temp =getApplication().getResources().getIdentifier(
                name,"raw",packagename);
        return temp;
    }
}
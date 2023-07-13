package com.example.dbtest0707;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Distrain1Activity extends AppCompatActivity {
    // ----------------------------------------DISTRAIN_1 ACTIVITY--------------------------------//

    ProgressBar progressbar;
    Button d1x;
    Button d1o;
    Button d1PlayStop;
    Button dis1submit;
    int i = 0;
    boolean visiblePb = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distrain1);
        ProgressBar progressbar = findViewById(R.id.progressBar);
        progressbar.setIndeterminate(false);
        progressbar.setProgress(0);
        progressbar.setVisibility(View.GONE); // Progressbar 시각기능 x
        Button d1PlayStop = findViewById(R.id.d1PlayStop);
        Button d1o = findViewById(R.id.d1o);
        Button d1x = findViewById(R.id.d1x);
        Button dis1submit = findViewById(R.id.dis1submit);
        //---------------------------------Play and Stop button event-----------------------------//
        d1PlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressbar.setVisibility(View.VISIBLE); // Progressbar 시각기능 o
                visiblePb = true;
            }
        });
        //---------------------------------Distrain Button O click event--------------------------//

        d1o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(visiblePb){
                    if(i<100){
                        i+=10;
                    }
                    progressbar.setProgress(i);
                    Log.v("Progressbar value ", ":" + progressbar.getProgress());
                    if (progressbar.getProgress()==100){
                        Log.v("Progressbar done ", ":");
                        d1x.setVisibility(View.GONE);
                        d1o.setVisibility(View.GONE);
                        progressbar.setVisibility(View.GONE);
                        dis1submit.setVisibility(View.VISIBLE);
                    }
                }

            }
        });
        //---------------------------------Distrain Button X click event--------------------------//

        d1x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(visiblePb){
                    if(i<100){
                        i-=10;
                    }
                    progressbar.setProgress(i);
                    Log.v("Progressbar value ", ":" + progressbar.getProgress());
                    if (progressbar.getProgress()==100){
                        Log.v("Progressbar done ", ":");
                        d1x.setVisibility(View.GONE);
                        d1o.setVisibility(View.GONE);
                        progressbar.setVisibility(View.GONE);
                        dis1submit.setVisibility(View.VISIBLE);
                    }
                }

            }
        });






    }
}
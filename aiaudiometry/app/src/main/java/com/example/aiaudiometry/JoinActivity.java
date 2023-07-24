package com.example.aiaudiometry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class JoinActivity extends AppCompatActivity {
    Spinner spn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        spn = (Spinner) findViewById(R.id.genderSpn);
        String[] models = getResources().getStringArray(R.array.gender);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, models);
        adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        spn.setAdapter(adapter);
    }
}
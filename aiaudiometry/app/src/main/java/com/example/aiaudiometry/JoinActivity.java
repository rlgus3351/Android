package com.example.aiaudiometry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class JoinActivity extends AppCompatActivity {

    private String log = "JOIN ACTIVITY";
    Spinner spn;

    Button joinBtn; //Join Button
    EditText joinEditId; //Edit id
    EditText joinEditPw; //Edit PW
    EditText joinEditBirth; //Edit BirthDay
    String genderSpnVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        Log.v(log,"Start");
        //--------------------------------GENDER SPINNER SETTING----------------------------------//
        spn = (Spinner) findViewById(R.id.genderSpn);

        // array.xml -> spinner value store
        String[] models = getResources().getStringArray(R.array.gender);

        // mapping -> spinner_item.xml 형식에 맞쳐 array value 값으로 매핑
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),R.layout.spinner_item, models);
        adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        //--------------------------------GENDER SPINNER GET VALUES-------------------------------//
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // 선택한 번호에 대한 값 -> gender 배열의 인덱스 값과 같다.
                genderSpnVal = models[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //--------------------------------JOIN BUTTON ONCLICK EVENT-------------------------------//
        joinBtn = (Button) findViewById(R.id.joinBtn);
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(log, "JOIN BUTTON CLICK");
                joinEditId = (EditText) findViewById(R.id.joinEditId);
                joinEditPw = (EditText) findViewById(R.id.joinEditPw);
                joinEditBirth = (EditText) findViewById(R.id.joinEditBirth);
                String id = joinEditId.getText().toString();
                String pw = joinEditPw.getText().toString();
                String date = joinEditBirth.getText().toString();
                Log.v(log,"EditId : " + id);
                Log.v(log,"EditPw : " + pw);
                Log.v(log,"gender : " + genderSpnVal);
                Log.v(log,"EditDate : " + date);
            }
        });
    }
}
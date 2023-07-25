package com.example.aiaudiometry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class speechTestMenu extends AppCompatActivity {
    String log = "speechTestMenu";
    Spinner spn;
    TextView testContentBox;
    Button speechTestBtn;
    String typeSpnVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_test_menu);
        //--------------------------------GENDER SPINNER SETTING----------------------------------//
        spn = (Spinner) findViewById(R.id.typeSpn);

        // array.xml -> spinner value store
        String[] models = getResources().getStringArray(R.array.type);

        // mapping -> spinner_item.xml 형식에 맞쳐 array value 값으로 매핑
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),R.layout.spinner_item, models);
        adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        //--------------------------------GENDER SPINNER GET VALUES-------------------------------//
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // 선택한 번호에 대한 값 -> gender 배열의 인덱스 값과 같다.
                typeSpnVal = models[i];
                testContentBox = findViewById(R.id.testContentBox);
                if(i==0){
                    testContentBox.setText("");
                    testContentBox.setText("어음 청취 역치 테스트란 이음절 단어를 들여주고 얼마나 작은 소리까지 들을 수 있는지 평가하는 테스트입니다.");
                }else if(i==1){
                    testContentBox.setText("");
                    testContentBox.setText("단어 인지도 테스트란 한글자 단어(단음절어)를 듣고 얼마나 정확하게 인지하는지 정확도를 평가하는 테스트입니다.");
                }else{
                    testContentBox.setText("");
                    testContentBox.setText("문장 인지도 테스트란 문장을 듣고 얼마나 정확하게 인지하는지 정확도를 평가하는 테스트입니다.");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                testContentBox = findViewById(R.id.testContentBox);
                testContentBox.setText("");
            }
        });
        //--------------------------------SPEECH TEST BUTTON EVENT--------------------------------//
        speechTestBtn = (Button) findViewById(R.id.speechTestBtn);
        speechTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), speechTest.class);
                intent.putExtra("type", typeSpnVal);
                startActivity(intent);
            }
        });



    }
}
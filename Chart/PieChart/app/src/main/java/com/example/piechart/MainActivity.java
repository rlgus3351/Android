package com.example.piechart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart pieChart;

    int[] colorClassArray = new int[]{
            Color.LTGRAY,Color.BLUE,Color.CYAN,
            Color.DKGRAY,Color.GREEN,
            Color.MAGENTA,Color.RED
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChart = (PieChart) findViewById(R.id.pieChart);
        PieDataSet pieDataSet = new PieDataSet(dataValues1(),"");
        pieDataSet.setColors(colorClassArray);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);

        // pie data 라벨 값 표시 유무
        pieChart.setDrawEntryLabels(true);

        // pie data value 대신 Percent 비율로 사용
        pieChart.setUsePercentValues(false);

        // pie Center Title
        pieChart.setCenterText("Week Data");

        // pie Center Title size
        pieChart.setCenterTextSize(20);

        // pie chart Center 반지름 크기
        pieChart.setCenterTextRadiusPercent(50);

        // pie chart 내부 원 반지름 크기
        pieChart.setHoleRadius(30);

        // pie chart 외부 반지름 크기
        pieChart.setTransparentCircleRadius(40);

        // pie chart 색상 변화
        pieChart.setTransparentCircleColor(Color.RED);

        // pie chart 색상 강도 변화 비율
        pieChart.setTransparentCircleAlpha(100);
        // pie chart 각도 최대값

        pieChart.setMaxAngle(180);



    }

    //------------------------------------- DATA INSERT ------------------------------------------//
    private ArrayList<PieEntry> dataValues1(){
        ArrayList<PieEntry> dataVals = new ArrayList<PieEntry>();
        dataVals.add(new PieEntry(15,"Sun"));
        dataVals.add(new PieEntry(34,"Mon"));
        dataVals.add(new PieEntry(23,"The"));
        dataVals.add(new PieEntry(86,"Wed"));
        dataVals.add(new PieEntry(26,"Thu"));
        dataVals.add(new PieEntry(17,"Fri"));
        dataVals.add(new PieEntry(63,"Sat"));
        return dataVals;
    }
}

package com.example.dbtest0707;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        barChart = (BarChart) findViewById(R.id.Barchart);

        // ---------------------------------- DATASET INSERT -------------------------------------//

        BarDataSet barDataSet1 = new BarDataSet(barEntries1(),"DataSet 1");
        barDataSet1.setColor(Color.MAGENTA);

        BarDataSet barDataSet2 = new BarDataSet(barEntries2(),"DataSet 2");
        barDataSet2.setColor(Color.GREEN);

        BarDataSet barDataSet3 = new BarDataSet(barEntries3(),"DataSet 3");
        barDataSet3.setColor(Color.BLUE);

        BarDataSet barDataSet4 = new BarDataSet(barEntries4(),"DataSet 4");
        barDataSet4.setColor(Color.RED);
        BarData barData = new BarData(barDataSet1,barDataSet2,barDataSet3,barDataSet4);

        // ---------------------------------- DATASET SETTING ------------------------------------//
        barChart.setData(barData);
        barChart.invalidate();
        barChart.setDragEnabled(true);
        // 시각화 최대 범위 지정
        barChart.setVisibleXRangeMaximum(3);

        // barSpace : 그룹 내의 그래프의 간격 지정
        float barSpace = 0.05f;
        // groupSpace : 그룹 간의 간격을 지정
        float groupSpace = 0.16f;

        barData.setBarWidth(0.16f);

        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace,barSpace)*7);
        barChart.getAxisLeft().setAxisMinimum(0);
        // fromX : xAxis의 그룹이 시작할 위치를 지정.
        barChart.groupBars(0, groupSpace,barSpace);
        barChart.invalidate();
    }
    // 격자 셋팅



    // --------------------------------------- DATA INSERT ---------------------------------------//
    private ArrayList<BarEntry> barEntries1(){
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1,2000));
        barEntries.add(new BarEntry(2,791));
        barEntries.add(new BarEntry(3,630));
        barEntries.add(new BarEntry(4,782));
        barEntries.add(new BarEntry(5,2724));
        barEntries.add(new BarEntry(6,500));
        barEntries.add(new BarEntry(7,2173));
        return barEntries;
    }

    private ArrayList<BarEntry> barEntries2(){
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1,900));
        barEntries.add(new BarEntry(2,631));
        barEntries.add(new BarEntry(3,1040));
        barEntries.add(new BarEntry(4,382));
        barEntries.add(new BarEntry(5,2614));
        barEntries.add(new BarEntry(6,5000));
        barEntries.add(new BarEntry(7,1173));
        return barEntries;
    }

    private ArrayList<BarEntry> barEntries3(){
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1,400));
        barEntries.add(new BarEntry(2,231));
        barEntries.add(new BarEntry(3,100));
        barEntries.add(new BarEntry(4,768));
        barEntries.add(new BarEntry(5,1514));
        barEntries.add(new BarEntry(6,9874));
        barEntries.add(new BarEntry(7,1273));
        return barEntries;
    }

    private ArrayList<BarEntry> barEntries4(){
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1,100));
        barEntries.add(new BarEntry(2,291));
        barEntries.add(new BarEntry(3,1230));
        barEntries.add(new BarEntry(4,1168));
        barEntries.add(new BarEntry(5,114));
        barEntries.add(new BarEntry(6,950));
        barEntries.add(new BarEntry(7,173));
        return barEntries;
    }
}
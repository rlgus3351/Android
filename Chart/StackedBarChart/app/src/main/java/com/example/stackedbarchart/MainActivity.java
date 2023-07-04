package com.example.stackedbarchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart stackedChart;

    int[] colorClassArray = new int[]{Color.BLUE, Color.CYAN, Color.GREEN};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stackedChart = (BarChart) findViewById(R.id.mp_Stacked_BarChart);
        BarDataSet barDataSet = new BarDataSet(dataValues1(),"Bar Set");
        barDataSet.setColors(colorClassArray);

        BarData barData = new BarData(barDataSet);
        stackedChart.setData(barData);
        stackedChart.invalidate();
    }
    // ---------------------------DATA SET--------------------------------------------------------//
    private ArrayList<BarEntry> dataValues1(){
        ArrayList<BarEntry> dataVals = new ArrayList<BarEntry>();
        dataVals.add(new BarEntry(0, new float[]{2,5.5f,4}));
        dataVals.add(new BarEntry(1, new float[]{2,8f,5.3f}));
        dataVals.add(new BarEntry(3, new float[]{2,3,8}));
        return dataVals;
    }
}
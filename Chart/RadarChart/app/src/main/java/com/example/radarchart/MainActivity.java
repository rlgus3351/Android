package com.example.radarchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadarChart radarChart;
    String[] labels = {"BMW","Volkswagen","Volvo","Audi","LAMborghini"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // -------------------------------------- RADAR CHART ------------------------------------//
        radarChart = (RadarChart) findViewById(R.id.radar_Chart);


        RadarDataSet dataSet1 = new RadarDataSet(dataValues1(),"Showroom 1");
        RadarDataSet dataSet2 = new RadarDataSet(dataValues2(),"Showroom 2");

         dataSet1.setColor(Color.RED);
        dataSet2.setColor(Color.GREEN);

        RadarData radarData = new RadarData();
        radarData.addDataSet(dataSet1);
        radarData.addDataSet(dataSet2);


        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        radarChart.setData(radarData);
        radarChart.invalidate();
    }
    // -------------------------------------- DATA INSERT ----------------------------------------//
    private ArrayList<RadarEntry> dataValues1(){
        ArrayList<RadarEntry> dataVals = new ArrayList<RadarEntry>();
        dataVals.add(new RadarEntry(4));
        dataVals.add(new RadarEntry(7));
        dataVals.add(new RadarEntry(2));
        dataVals.add(new RadarEntry(5));
        dataVals.add(new RadarEntry(9));
        return dataVals;
    }

    private ArrayList<RadarEntry> dataValues2(){
        ArrayList<RadarEntry> dataVals = new ArrayList<RadarEntry>();
        dataVals.add(new RadarEntry(7));
        dataVals.add(new RadarEntry(4));
        dataVals.add(new RadarEntry(8));
        dataVals.add(new RadarEntry(2));
        dataVals.add(new RadarEntry(6));
        return dataVals;
    }
}
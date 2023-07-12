package com.example.audiogram;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart = (LineChart) findViewById(R.id.LineChart);

        LineDataSet lineDataSet1 = new LineDataSet(leftValues(),"leftValue");
        LineDataSet lineDataSet2 = new LineDataSet(rightValues(),"rightValue");

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);

        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate();

        Description description = new Description();
        description.setText("Audiogram");
        lineChart.setDescription(description);
        // ------------------------------------ CHART DISPLAY OPTION ---------------------------- //
        lineChart.setDrawGridBackground(false); // 배경 격자 설정
        lineChart.setDrawBorders(true); // 테두리 설정
        lineChart.setBorderWidth(2); // 테두리 두께
        lineChart.setBorderColor(Color.BLACK); // 테두리 색상

        // ------------------------------------ CUSTOMIZING DATASET1 ---------------------------- //
        lineDataSet1.setLineWidth(2); // 선 두께
        lineDataSet1.setColor(Color.rgb(6,143,255)); // 선 색상
        lineDataSet1.setCircleColor(Color.rgb(6,143,255));
        lineDataSet1.setCircleColorHole(Color.rgb(6,143,255));
        lineDataSet1.setCircleRadius(4);

        // ------------------------------------ CUSTOMIZING DATASET2 ---------------------------- //
        lineDataSet2.setLineWidth(2); // 선 두께
        lineDataSet2.setColor(Color.rgb(242,76,61)); // 선 색상
        lineDataSet2.setCircleColor(Color.rgb(242,76,61));
        lineDataSet2.setCircleColorHole(Color.rgb(242,76,61));
        lineDataSet2.setCircleRadius(4);

        // ------------------------------------ X AXIS DISABLED --------------------------------- //
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setAxisMaximum(0.01f);
        xAxis.setAxisMaximum(9000);
        xAxis.setSpaceMax(0.1f);
        xAxis.setSpaceMin(0.1f);
        xAxis.setValueFormatter((new MyXaxisValueFormatter()));

        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setMinWidth(20);
        yAxis.setValueFormatter((new MyYaxisValueFormatter()));

        // ------------------------------------ RIGHT AXIS DISABLED ----------------------------- //
        lineChart.getAxisRight().setEnabled(false);
    }

    private ArrayList<Entry> leftValues(){
        ArrayList<Entry> leftData = new ArrayList<Entry>();
        leftData.add(new Entry(125,-20));
        leftData.add(new Entry(250,-20));
        leftData.add(new Entry(500,-30));
        leftData.add(new Entry(1000,-40));
        leftData.add(new Entry(2000,-50));
        leftData.add(new Entry(4000,-60));
        leftData.add(new Entry(8000,-70));
        return leftData;
    }

    private ArrayList<Entry> rightValues(){
        ArrayList<Entry> rightData = new ArrayList<Entry>();
        rightData.add(new Entry(125,-30));
        rightData.add(new Entry(250,-40));
        rightData.add(new Entry(500,-50));
        rightData.add(new Entry(1000,-60));
        rightData.add(new Entry(2000,-70));
        rightData.add(new Entry(4000,-80));
        rightData.add(new Entry(8000,-90));
        return rightData;
    }
    //------------------------------------ AUDIOGRAM Y LEFT AXIS ---------------------------------//
    private class MyYaxisValueFormatter implements IAxisValueFormatter{

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            value *= -1;
            return value +"Db";
        }
    }

    private class MyXaxisValueFormatter implements IAxisValueFormatter{

        String[] axisValue = {"125","250","500","1000","2000","4000","8000"};
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            String temp = Integer.toString((int) value);

            return temp;
        }
    }


}
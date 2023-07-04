package com.example.charttest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LineChart mpLineChart;
    int colorArray[] = {R.color.color1,R.color.color2,R.color.color3,R.color.color4, R.color.color5};
    //int[] colorClassArray = new int[]{Color.BLUE,Color.CYAN, Color.GREEN,Color.MAGENTA};
    String[] legendName = {"Cow","Dog","Cat","Rat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //----------------------------------- CHART AREA -----------------------------------------//
        mpLineChart = (LineChart) findViewById(R.id.line_chart);

        //----------------------------------- CHART DATA SETS  -----------------------------------//
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "Data Set 1");
        LineDataSet lineDataSet2 = new LineDataSet(dataValues2(), "Data Set 2");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);

        LineData data = new LineData(dataSets);

        //----------------------------------- ALL DATA FORMATTING --------------------------------//
        data.setValueFormatter(new MyValueFormatter());

        mpLineChart.setData(data);
        mpLineChart.invalidate();

        //------------------------------- AXIS DATA FORMATTING -----------------------------------//

        XAxis xAxis = mpLineChart.getXAxis();
        YAxis yAxisLeft = mpLineChart.getAxisLeft();
        YAxis yAxisRight = mpLineChart.getAxisRight();

        xAxis.setValueFormatter(new MyAxisValueFormatter());
        yAxisLeft.setValueFormatter((new MyAxisValueFormatter()));
        //----------------------------------- DISPLAY SETTINGS  ----------------------------------//
//        mpLineChart.setNoDataText("No Data");
//        mpLineChart.setNoDataTextColor(Color.RED);

        mpLineChart.setDrawGridBackground(true);
        mpLineChart.setDrawBorders(true);
        mpLineChart.setBorderColor(Color.RED);
        mpLineChart.setBorderWidth(5);





        //------------------------------- DESCRIPTION SETTINGS  ----------------------------------//
        Description description = new Description();
        description.setText("test1");
        description.setTextColor(Color.BLUE);
        description.setTextSize(15);
        mpLineChart.setDescription(description);
        //----------------------------------- CUSTOMIZE LINE CHART -------------------------------//
        // 선 두께
        lineDataSet1.setLineWidth(4);
        // 선 색상 선택
        lineDataSet1.setColor(Color.RED);
        // 데이터 원 활성화 / 비 활성화
        lineDataSet1.setDrawCircles(true);
        // 데이터 안에 공간 활성화
        lineDataSet1.setDrawCircleHole(true);
        // 데이터 항목(원) 색상 변경
        lineDataSet1.setCircleColor(Color.GRAY);
        // 데이터 항목(원) 안에 색상 변경
        lineDataSet1.setCircleColorHole(Color.GRAY);
        // 데이터 항목 크기 설정(원)
        lineDataSet1.setCircleRadius(10);
        // 데이터 항목 크기 설정(안에 원)
        lineDataSet1.setCircleHoleRadius(9);



        //----------------------------------- LEGEND SETTINGS  -----------------------------------//
        Legend legend = mpLineChart.getLegend();
        legend.setEnabled(true);
        legend.setTextColor(Color.BLACK);
        // legend 글자 사이즈
        legend.setTextSize(15);
        // legend 폼 형태
        legend.setForm(Legend.LegendForm.LINE);
        // legend 폼 사이즈
        legend.setFormSize(20);
        // legend 폼 간격
        legend.setXEntrySpace(50);
        // legend 폼과 텍스트 간격
        legend.setFormToTextSpace(10);
        //
        LegendEntry[] legendEntries = new LegendEntry[4];

        for (int i=0; i<legendEntries.length; i++){
            LegendEntry entry = new LegendEntry();
            entry.formColor = colorArray[i];
            entry.label = String.valueOf(legendName[i]);
            legendEntries[i] = entry;
        }
        legend.setCustom(legendEntries);

    }
    //---------------------------------MAKE CHART DATA SETS  -------------------------------------//
    private ArrayList<Entry> dataValues1(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 20));
        dataVals.add(new Entry(1, 24));
        dataVals.add(new Entry(2, 2));
        dataVals.add(new Entry(3, 10));
        dataVals.add(new Entry(4, 28));

        return dataVals;
    }

    private ArrayList<Entry> dataValues2(){
        ArrayList<Entry> dataVals = new ArrayList<>();
        dataVals.add(new Entry(0,12));
        dataVals.add(new Entry(2,16));
        dataVals.add(new Entry(3,23));
        dataVals.add(new Entry(5,1));
        dataVals.add(new Entry(7,18));
        return dataVals;
    }
    //--------------------------------- FORMATTING DATA VALUES -----------------------------------//
    private class MyValueFormatter implements IValueFormatter{

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return value + " $";
        }
    }
    //--------------------------------- FORMATTING AXIS VALUES -----------------------------------//
    private class MyAxisValueFormatter implements IAxisValueFormatter{

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            axis.setLabelCount(3,true);
            return value + " $";
        }
    }

}
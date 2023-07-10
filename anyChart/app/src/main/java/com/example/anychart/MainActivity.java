package com.example.anychart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.MarkerType;
import com.anychart.graphics.vector.Stroke;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AnyChartView chartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chartView = (AnyChartView) findViewById(R.id.chart_view);
        Cartesian cartesian= AnyChart.line();

        cartesian.animation(true);
        cartesian.padding(10d,20d,5d,20d);


        List<DataEntry> seriesData1 = new ArrayList<>();
        seriesData1.add(new ValueDataEntry("500",-20));
        seriesData1.add(new ValueDataEntry("1000",-30));
        seriesData1.add(new ValueDataEntry("2000",-40));
        seriesData1.add(new ValueDataEntry("3000",-50));
        seriesData1.add(new ValueDataEntry("4000",-60));
        seriesData1.add(new ValueDataEntry("8000",-70));
        Set set = Set.instantiate();
        set.data(seriesData1);
        Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value*2' }");
        Line series1 = cartesian.line(series1Mapping);
        series1.name("Brandy");
        series1.markers().enabled(true);
        series1.markers()
                .type(MarkerType.CROSS)
                .size(5d);
        series1.color();
        // ----------------------------------------yAxis Formatting ------------------------------//
        cartesian.yAxis(0).labels().format(
                "function() {"+
                    "return (this.value * -1)"+
            " }");
        chartView.setChart(cartesian);



    }
}
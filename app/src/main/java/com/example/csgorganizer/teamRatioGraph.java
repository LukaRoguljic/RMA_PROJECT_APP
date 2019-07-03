package com.example.csgorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class teamRatioGraph extends AppCompatActivity {

    BarChart barChart;
    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_ratio_graph);

        barChart    = (BarChart)findViewById(R.id.barGraph);
        lineChart   = (LineChart)findViewById(R.id.mapPercentage);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1.04f,0));
        barEntries.add(new BarEntry(1.04f,1));
        barEntries.add(new BarEntry(1.19f,2));
        barEntries.add(new BarEntry(0.88f,3));
        barEntries.add(new BarEntry(0.99f,4));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Values");

        ArrayList<String> theNames = new ArrayList<>();
        theNames.add("Guard");
        theNames.add("Rain");
        theNames.add("NiKo");
        theNames.add("NEO");
        theNames.add("olof");

        BarData theData = new BarData(theNames, barDataSet);
        barChart.setData(theData);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);

        ArrayList<Entry> lineEntries = new ArrayList<>();

        lineEntries.add(new Entry(60.5f, 0));
        lineEntries.add(new Entry(60.4f, 1));
        lineEntries.add(new Entry(59.6f, 2));
        lineEntries.add(new Entry(59.5f, 3));
        lineEntries.add(new Entry(59.4f, 4));
        lineEntries.add(new Entry(54.8f, 5));
        lineEntries.add(new Entry(53.9f, 6));

        LineDataSet lineDataSet = new LineDataSet(lineEntries, "Values");
        ArrayList<String> mapNames = new ArrayList<>();
        mapNames.add("Overpass");
        mapNames.add("Mirage");
        mapNames.add("Nuke");
        mapNames.add("Inferno");
        mapNames.add("Dust2");
        mapNames.add("Cache");
        mapNames.add("Train");


        LineData theData2 = new LineData(mapNames, lineDataSet);
        lineChart.setData(theData2);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);




    }



}

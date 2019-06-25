package com.example.csgorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class teamRatioGraph extends AppCompatActivity {

    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_ratio_graph);

        barChart    = (BarChart)findViewById(R.id.barGraph);

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
    }



}

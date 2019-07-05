package com.example.csgorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class teamRatioGraph extends AppCompatActivity {

    BarChart barChart;
    LineChart lineChart;
    PieChart weaponChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_ratio_graph);

        barChart    = (BarChart)findViewById(R.id.barGraph);
        lineChart   = (LineChart)findViewById(R.id.mapPercentage);
        weaponChart = (PieChart)findViewById(R.id.pieChartWeapon);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1.04f,0));
        barEntries.add(new BarEntry(1.04f,1));
        barEntries.add(new BarEntry(1.19f,2));
        barEntries.add(new BarEntry(0.88f,3));
        barEntries.add(new BarEntry(0.99f,4));

        BarDataSet barDataSet = new BarDataSet(barEntries, "");

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
        barChart.setDescription("KDA RATIO");


        ArrayList<Entry> lineEntries = new ArrayList<>();

        lineEntries.add(new Entry(60.5f, 0));
        lineEntries.add(new Entry(60.4f, 1));
        lineEntries.add(new Entry(59.6f, 2));
        lineEntries.add(new Entry(59.5f, 3));
        lineEntries.add(new Entry(59.4f, 4));
        lineEntries.add(new Entry(54.8f, 5));
        lineEntries.add(new Entry(53.9f, 6));

        LineDataSet lineDataSet = new LineDataSet(lineEntries, "");
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
        lineChart.setDescription("");


        ArrayList<Entry> pieEntries = new ArrayList<>();


        pieEntries.add(new Entry(40.5f, 0));
        pieEntries.add(new Entry(16.15f, 1));
        pieEntries.add(new Entry(15.91f, 2));
        pieEntries.add(new Entry(10.69f, 3));
        pieEntries.add(new Entry(16.75f, 4));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");

        ArrayList<String> weaponNames = new ArrayList<>();
        weaponNames.add("AK-47");
        weaponNames.add("AWP");
        weaponNames.add("M4A1");
        weaponNames.add("AUG");
        weaponNames.add("Rest");

        PieData theData3 = new PieData(weaponNames, pieDataSet);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        weaponChart.setData(theData3);
        weaponChart.setTouchEnabled(true);
        weaponChart.setDescription("");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);


    }



}

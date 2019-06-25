package com.example.csgorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowPractices extends AppCompatActivity {

    ListView listView;
    DatabaseHelper myDB;
    ArrayList<ListItem> arrayList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_practices);

        listView = (ListView)findViewById(R.id.listView);
        myDB = new DatabaseHelper(this);
        arrayList = new ArrayList<>();
        loadDataInListView();
    }

    private void loadDataInListView() {
        arrayList = myDB.getAllData();
        myAdapter = new MyAdapter(this, arrayList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

    }
}

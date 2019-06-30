package com.example.csgorganizer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    DatabaseHelper myDB;
    EditText etAddCity;
    Button btnAddCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        myDB = new DatabaseHelper(this);
        etAddCity = (EditText)findViewById(R.id.newLocName);
        btnAddCity = (Button)findViewById(R.id.btnAddLocation);

        AddCityName();
    }

    public void  AddCityName(){
        btnAddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted =  myDB.insertCityNames(etAddCity.getText().toString());

                if(isInserted){
                    Toast.makeText(MapActivity.this,"Location added", Toast.LENGTH_LONG).show();
                }
                if(!isInserted){
                    Toast.makeText(MapActivity.this,"FAILED", Toast.LENGTH_LONG).show();
                }

                Intent addCityIntent = new Intent(MapActivity.this, MapActivity.class);
                startActivity(addCityIntent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        String[] nameArray = myDB.getLocationNames();
        Geocoder obje = new Geocoder(this);
        double latitude = 0,longtitude = 0;
        int i = 0;

        for (i = 0; i < 10; i++){
            if(nameArray[i] == null){}
            else{
                try{
                    List<Address> coordinates = obje.getFromLocationName(nameArray[i], 1);
                    if (coordinates.size() >  0) {
                        latitude = coordinates.get(0).getLatitude();
                        longtitude = coordinates.get(0).getLongitude();
                        LatLng newLocation = new LatLng(latitude, longtitude);
                        map.addMarker(new MarkerOptions().position(newLocation).title("CSGO"));
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

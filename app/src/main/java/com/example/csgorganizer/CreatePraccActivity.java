package com.example.csgorganizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePraccActivity extends AppCompatActivity {


    DatabaseHelper myDB;

    EditText etOpponent, etDate, etComment, etMaps;
    Button btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pracc);

        myDB = new DatabaseHelper(this);
        etOpponent  =(EditText)findViewById(R.id.etOpponentName);
        etDate      =(EditText)findViewById(R.id.etDate);
        etComment   =(EditText)findViewById(R.id.etComment);
        etMaps      =(EditText)findViewById(R.id.etMap);
        btnAddData  =(Button)findViewById(R.id.btnAddData);

        AddData();
    }

    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted =  myDB.insertData(etMaps.getText().toString(),
                                                     etDate.getText().toString(),
                                                     etComment.getText().toString(),
                                                     etOpponent.getText().toString());
               if(isInserted){
                   Toast.makeText(CreatePraccActivity.this,"Practice Created", Toast.LENGTH_LONG).show();
               }
               if(!isInserted){
                   Toast.makeText(CreatePraccActivity.this,"Practice Creation Failed", Toast.LENGTH_LONG).show();
               }
                Intent secondActivityIntent = new Intent(CreatePraccActivity.this, SecondActivity.class);
                startActivity(secondActivityIntent);
            }
        });

    }

}

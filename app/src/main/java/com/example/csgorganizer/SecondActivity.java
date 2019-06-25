package com.example.csgorganizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button createPractice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        createPractice      = (Button)findViewById(R.id.createTrainingBtn);

        createPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createPractice = new Intent(SecondActivity.this, CreatePraccActivity.class);
                startActivity(createPractice);
            }
        });
    }
}

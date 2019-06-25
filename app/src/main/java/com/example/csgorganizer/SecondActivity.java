package com.example.csgorganizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private Button createPractice;
    private Button practiceButton;
    private Button teamStatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        createPractice      = (Button)findViewById(R.id.createTrainingBtn);
        practiceButton      = (Button)findViewById(R.id.practiceBtn);
        teamStatButton      = (Button)findViewById(R.id.teamStatBtn);

        createPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createPractice = new Intent(SecondActivity.this, CreatePraccActivity.class);
                startActivity(createPractice);
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent practiceButton =  new Intent(SecondActivity.this, ShowPractices.class);
                startActivity(practiceButton);
            }
        });

        teamStatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teamStartButton = new Intent(SecondActivity.this, teamRatioGraph.class);
                startActivity(teamStartButton);
            }
        });
    }

}

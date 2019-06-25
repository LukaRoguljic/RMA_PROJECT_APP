package com.example.csgorganizer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText TeamName;
    private EditText TeamPassword;
    private Button   Login;
    //TEST GIT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TeamName        = (EditText)findViewById(R.id.etTeamName);
        TeamPassword    = (EditText)findViewById(R.id.etTeamPassword);
        Login           = (Button)findViewById(R.id.btnLogin);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateLoginInput(TeamName.getText().toString(), TeamPassword.getText().toString());
            }
        });

    }

    private void ValidateLoginInput(String teamName, String teamPassword){
        if( teamName.equals("FazeCSGO") && teamPassword.equals("fazeup1234") ){
            Intent loginIntent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(loginIntent);
        }
        else{
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(getApplicationContext(), "Wrong TEAM NAME or TEAM PASSWORD!", duration);
            toast.show();
        }
    }

}

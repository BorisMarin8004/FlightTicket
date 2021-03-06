package com.example.flightticket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flightticket.utils.FactoryIntent;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences userPref;
    SharedPreferences.Editor userPrefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView welcomeText = findViewById(R.id.userWelcome);
        Button searchFlightsButton = (Button) findViewById(R.id.searchFlightsButton);
        Button savedFlightsButton = (Button) findViewById(R.id.savedFlightsButton);
        Button logoutButton = findViewById(R.id.logoutButton);

        searchFlightsButton.setOnClickListener(this);
        savedFlightsButton.setOnClickListener(this);

        userPref = getSharedPreferences("userPreferences", MODE_PRIVATE);
        String welcome = "Welcome, "  + userPref.getString("username", "");
        welcomeText.setText(welcome);



        // android is throwing warnings about the switch case format so I'm just gonna use this
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPrefEditor = userPref.edit();
                userPrefEditor.clear();
                userPrefEditor.commit();
                startActivity(FactoryIntent.getIntent(LandingActivity.class,getApplicationContext()));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.searchFlightsButton:
                startActivity(FactoryIntent.getIntent(SearchFlights.class,getApplicationContext()));
                break;
            case R.id.savedFlightsButton:
                startActivity(FactoryIntent.getIntent(SavedFlights.class,getApplicationContext()));
                break;
        }
    }

}
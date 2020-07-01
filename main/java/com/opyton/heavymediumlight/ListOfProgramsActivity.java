package com.opyton.heavymediumlight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListOfProgramsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_programs);

        Button day1Btn = (Button)findViewById(R.id.Day1);
        Button day2Btn = (Button)findViewById(R.id.Day2);
        Button day3Btn = (Button)findViewById(R.id.Day3);
        Button day4Btn = (Button)findViewById(R.id.Day4);
        Button day5Btn = (Button)findViewById(R.id.Day5);
        Button day6Btn = (Button)findViewById(R.id.Day6);

        final String squat = getIntent().getStringExtra("squatNum");
        final String bench = getIntent().getStringExtra("benchNum");
        final String deadlift = getIntent().getStringExtra("deadliftNum");

        day1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Day1Desc.class);
                startIntent.putExtra("deadliftNum", deadlift);
                startActivity(startIntent);
            }
        });

        day2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Day2Desc.class);
                startIntent.putExtra("benchNum", bench);
                startActivity(startIntent);
            }
        });

        day3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Day3Desc.class);
                startIntent.putExtra("squatNum", squat);
                startActivity(startIntent);
            }
        });

        day4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Day4Desc.class);
                startIntent.putExtra("benchNum", bench);
                startActivity(startIntent);
            }
        });

        day5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Day5Desc.class);
                startIntent.putExtra("squatNum", squat);
                startActivity(startIntent);
            }
        });

        day6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Day6Desc.class);
                startIntent.putExtra("benchNum", bench);
                startActivity(startIntent);
            }
        });
    }


}
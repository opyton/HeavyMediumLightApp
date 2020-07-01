package com.opyton.heavymediumlight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Day3Desc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_desc);

        Button nextBtn = (Button)findViewById(R.id.Day3DescNext);

        final String squat = getIntent().getStringExtra("squatNum");

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Day3Compounds.class);
                startIntent.putExtra("squatNum", squat);
                startActivity(startIntent);
            }
        });
    }
}
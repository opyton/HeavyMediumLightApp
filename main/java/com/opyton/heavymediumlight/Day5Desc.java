package com.opyton.heavymediumlight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Day5Desc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5_desc);

        Button nextBtn = (Button)findViewById(R.id.Day5DescNext);

        final String squat = getIntent().getStringExtra("squatNum");

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Day5Compounds.class);
                startIntent.putExtra("squatNum", squat);
                startActivity(startIntent);
            }
        });
    }
}
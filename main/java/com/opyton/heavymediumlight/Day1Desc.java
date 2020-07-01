package com.opyton.heavymediumlight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Day1Desc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1_desc);

        Button nextBtn = (Button)findViewById(R.id.Day1DescNext);

        final String deadlift = getIntent().getStringExtra("deadliftNum");

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Day1Top.class);
                startIntent.putExtra("deadliftNum", deadlift);
                startActivity(startIntent);
            }
        });
    }
}
package com.opyton.heavymediumlight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Day2Desc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2_desc);

        Button nextBtn = (Button)findViewById(R.id.Day2DescNext);

        final String bench = getIntent().getStringExtra("benchNum");

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Day2Compounds.class);
                startIntent.putExtra("benchNum", bench);
                startActivity(startIntent);
            }
        });
    }
}
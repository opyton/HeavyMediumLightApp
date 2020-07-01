package com.opyton.heavymediumlight;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutBtn = (Button)findViewById(R.id.aboutBtn);
        Button rpeBtn = (Button)findViewById(R.id.rpeBtn);
        Button nextBtn = (Button)findViewById(R.id.nextBtn);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();

        TextView squats = (TextView)findViewById(R.id.squatVal);
        TextView benches = (TextView)findViewById(R.id.benchVal);
        TextView deadlifts = (TextView)findViewById(R.id.deadliftVal);

        String tempVal = preferences.getString("squatNum","");
        if(tempVal != null){squats.setText(tempVal);}

        tempVal = preferences.getString("benchNum","");
        if(tempVal != null){benches.setText(tempVal);}

        tempVal = preferences.getString("deadliftNum","");
        if(tempVal != null){deadlifts.setText(tempVal);}



        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(startIntent);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText squatVal = (EditText)findViewById(R.id.squatVal);
                EditText benchVal = (EditText)findViewById(R.id.benchVal);
                EditText deadliftVal = (EditText)findViewById(R.id.deadliftVal);

                String squat =squatVal.getText().toString();
                String bench = benchVal.getText().toString();
                String deadlift = deadliftVal.getText().toString();

                editor.putString("squatNum",squat);
                editor.apply();

                editor.putString("benchNum",bench);
                editor.apply();

                editor.putString("deadliftNum",deadlift);
                editor.apply();

                Intent startIntent = new Intent(getApplicationContext(), ListOfProgramsActivity.class);
                startIntent.putExtra("squatNum", squat);
                startIntent.putExtra("benchNum", bench);
                startIntent.putExtra("deadliftNum", deadlift);
                startActivity(startIntent);
            }
        });

        rpeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), MaxEstimatorActivity.class);
                startActivity(startIntent);
            }
        });
    }
}
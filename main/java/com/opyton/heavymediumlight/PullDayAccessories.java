package com.opyton.heavymediumlight;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PullDayAccessories extends AppCompatActivity {

    TextView countDownText;
    Button countDownButton;
    CountDownTimer countDownTimer;
    long timeLeftInMilliseconds = 60000;
    boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_day_accesories);

        final TextView decrement = (TextView)findViewById(R.id.latpullcounter);
        final TextView decrement2 = (TextView)findViewById(R.id.curlcounter);
        final TextView decrement3 = (TextView)findViewById(R.id.rowcounter);
        final TextView decrement4 = (TextView)findViewById(R.id.dumbellcounter);
        final TextView decrement5 = (TextView)findViewById(R.id.hypertext);

        Button decrementButton = (Button)findViewById(R.id.latpulldec);
        Button decrementButton2 = (Button)findViewById(R.id.curldec);
        Button decrementButton3 = (Button)findViewById(R.id.rowdec);
        Button decrementButton4 = (Button)findViewById(R.id.dumbelldec);
        Button decrementButton5 = (Button)findViewById(R.id.hyperdec);

        countDownText = (TextView) findViewById(R.id.day1CountDownTxt);
        countDownButton = (Button) findViewById(R.id.day1CountDownBtn);

        updateTimer();

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(decrement.getText().toString());
                if (num1>0) num1--;
                decrement.setText(num1 + "");
            }
        });

        decrementButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(decrement2.getText().toString());
                if (num1>0) num1--;
                decrement2.setText(num1 + "");
            }
        });

        decrementButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(decrement3.getText().toString());
                if (num1>0) num1--;
                decrement3.setText(num1 + "");
            }
        });

        decrementButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(decrement4.getText().toString());
                if (num1>0) num1--;
                decrement4.setText(num1 + "");
            }
        });

        decrementButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(decrement5.getText().toString());
                if (num1>0) num1--;
                decrement5.setText(num1 + "");
            }
        });

        Button nextBtn = (Button)findViewById(R.id.MainMenuBtn);

        Button resetBtn = (Button)findViewById(R.id.Day1topreset);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
                timeLeftInMilliseconds = 60000;
                countDownText.setText("1:00");
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });

        countDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });

    }

    public void startStop(){
        if (timerRunning){
            stopTimer();
        }else{startTimer();
        }
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {}
        }.start();
        countDownButton.setText("Pause");
        timerRunning = true;
    }

    public void stopTimer(){
        countDownTimer.cancel();
        countDownButton.setText("Start");
        timerRunning=false;
    }

    public void updateTimer(){
        int minutes = (int)timeLeftInMilliseconds / 60000;
        int seconds = (int)timeLeftInMilliseconds % 60000/ 1000;

        String timeLeftTxt = "" + minutes + ":";
        if (seconds<10) timeLeftTxt+="0";
        timeLeftTxt+=seconds;
        countDownText.setText(timeLeftTxt);
    }
}
package com.opyton.heavymediumlight;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Day1Top extends AppCompatActivity {

    TextView countDownText;
    Button countDownButton;
    CountDownTimer countDownTimer;
    long timeLeftInMilliseconds = 120000;
    boolean timerRunning;

    String deadlift;
    int backoffDeadlift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1_top);

        deadlift = getIntent().getStringExtra("deadliftNum");
        if(deadlift!=null)
            backoffDeadlift=Integer.parseInt(deadlift);
        double change = backoffDeadlift * 0.9;
        backoffDeadlift= (int) (5*(Math.floor(Math.abs(change/5))));

        TextView topDeadlift = (TextView)findViewById(R.id.topSetDay1);
        TextView backoffDeadliftView = (TextView)findViewById(R.id.backoffSetDay);
        final TextView decrement = (TextView)findViewById(R.id.Day1TopCounter);
        final TextView decrement2 = (TextView)findViewById(R.id.day1BackoffCounter);
        Button decrementButton = (Button)findViewById(R.id.Day1TopDecrement);
        Button decrementButton2 = (Button)findViewById(R.id.day1BackoffDecrement);

        countDownText = (TextView) findViewById(R.id.day1CountDownTxt);
        countDownButton = (Button) findViewById(R.id.day1CountDownBtn);

        if(deadlift != null){
            topDeadlift.setText(deadlift);
            backoffDeadliftView.setText(backoffDeadlift + "");
        }
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

        Button nextBtn = (Button)findViewById(R.id.Day1Next);

        Button resetBtn = (Button)findViewById(R.id.Day1topreset);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
                timeLeftInMilliseconds = 120000;
                countDownText.setText("2:00");
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), PullDayAccessories.class);
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
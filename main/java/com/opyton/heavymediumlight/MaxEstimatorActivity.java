package com.opyton.heavymediumlight;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MaxEstimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpe_estimator);

        Spinner spinner = (Spinner)findViewById(R.id.rpe_spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MaxEstimatorActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.rpe_nums));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);

        Button rpeCalcBtn = (Button)findViewById(R.id.rpe_Calc_Btn);
        rpeCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNum = (EditText)findViewById(R.id.rpeWeight);
                TextView result = (TextView)findViewById(R.id.threeRpeTxt);
                Spinner spinner = (Spinner)findViewById(R.id.rpe_spinner);

                int num1 = Integer.parseInt(firstNum.getText().toString());
                int repNum = Integer.parseInt(spinner.getSelectedItem().toString());
                double rpeEstimate = 1.0;

                switch(repNum){
                    case 1: rpeEstimate = num1*0.94; break;
                    case 2: rpeEstimate = num1/.97*0.94; break;
                    case 3: rpeEstimate = num1; break;
                    case 4: rpeEstimate = num1/.92*0.94; break;
                    case 5: rpeEstimate = num1/.89*0.94; break;
                    case 6: rpeEstimate = num1/.86*0.94; break;
                    case 7: rpeEstimate = num1/.83*0.94; break;
                    case 8: rpeEstimate = num1/.81*0.94; break;
                }
                int sum = (int) (5*(Math.floor(Math.abs(rpeEstimate/5))));
                result.setText(sum + "");
            }
        });


    }
}
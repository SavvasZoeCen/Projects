package com.example.pickyourcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WeightActivity extends AppCompatActivity {

    private Button btnCancelWeight;
    private Button btnSaveWeight;

    private EditText txtRankWeight;
    private EditText txtLivingCostWeight;
    private EditText txtTuitionWeight;
    private EditText txtScholarshipWeight;
    private EditText txtDistanceWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        // bind views
        btnCancelWeight      = (Button) findViewById(R.id.btnCancelWeight);
        btnSaveWeight        = (Button) findViewById(R.id.btnSaveWeight);

        txtRankWeight        = (EditText) findViewById(R.id.txtRankWeight);
        txtLivingCostWeight  = (EditText) findViewById(R.id.txtLivingCostWeight);
        txtTuitionWeight     = (EditText) findViewById(R.id.txtTuitionWeight);
        txtScholarshipWeight = (EditText) findViewById(R.id.txtScholarshipWeight);
        txtDistanceWeight    = (EditText) findViewById(R.id.txtDistanceWeight);

        // set up buttons
        btnCancelWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WeightActivity.this, MainActivity.class));
            }
        });

        btnSaveWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.weights[0] = Integer.parseInt(txtRankWeight.getText().toString());
                MainActivity.weights[1] = Integer.parseInt(txtLivingCostWeight.getText().toString());
                MainActivity.weights[2] = Integer.parseInt(txtTuitionWeight.getText().toString());
                MainActivity.weights[3] = Integer.parseInt(txtScholarshipWeight.getText().toString());
                MainActivity.weights[4] = Integer.parseInt(txtDistanceWeight.getText().toString());

                for (College college : MainActivity.colleges) {
                    college.computeScore(MainActivity.weights); // update the score of all collges
                }

                startActivity(new Intent(WeightActivity.this, MainActivity.class));
            }
        });

        txtRankWeight.setText(String.valueOf(MainActivity.weights[0]));
        txtLivingCostWeight.setText(String.valueOf(MainActivity.weights[1]));
        txtTuitionWeight.setText(String.valueOf(MainActivity.weights[2]));
        txtScholarshipWeight.setText(String.valueOf(MainActivity.weights[3]));
        txtDistanceWeight.setText(String.valueOf(MainActivity.weights[4]));

    }
}
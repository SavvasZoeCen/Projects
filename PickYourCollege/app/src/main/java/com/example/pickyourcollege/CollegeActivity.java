package com.example.pickyourcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CollegeActivity extends AppCompatActivity {

    private Button btnCancel;
    private Button btnSave;

    private EditText txtName;
    private EditText txtMajor;
    private EditText txtLocation;
    private EditText txtRank;
    private EditText txtLivingCost;
    private EditText txtTuition;
    private EditText txtScholarship;
    private EditText txtDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);

        Intent intent = getIntent();
        int intCollegeIdx = intent.getIntExtra("intCollegeIdx", 0);

        // bind views
        btnCancel       = (Button) findViewById(R.id.btnCancel);
        btnSave         = (Button) findViewById(R.id.btnSave);

        txtName         = (EditText) findViewById(R.id.txtName);
        txtMajor        = (EditText) findViewById(R.id.txtMajor);
        txtLocation     = (EditText) findViewById(R.id.txtLocation);
        txtRank         = (EditText) findViewById(R.id.txtRank);
        txtLivingCost   = (EditText) findViewById(R.id.txtLivingCost);
        txtTuition      = (EditText) findViewById(R.id.txtTuition);
        txtScholarship  = (EditText) findViewById(R.id.txtScholarship);
        txtDistance     = (EditText) findViewById(R.id.txtDistance);

        // set up buttons
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollegeActivity.this, MainActivity.class));
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intCollegeIdx >= 0 && intCollegeIdx < MainActivity.intMaxNumOfOffers) {  // 0~ for offers, save info
                    MainActivity.colleges[intCollegeIdx].name = txtName.getText().toString();
                    MainActivity.colleges[intCollegeIdx].major = txtMajor.getText().toString();
                    MainActivity.colleges[intCollegeIdx].location = txtLocation.getText().toString();
                    MainActivity.colleges[intCollegeIdx].rank = Integer.parseInt(txtRank.getText().toString());
                    MainActivity.colleges[intCollegeIdx].livingCost = Integer.parseInt(txtLivingCost.getText().toString());
                    MainActivity.colleges[intCollegeIdx].tuition = Integer.parseInt(txtTuition.getText().toString());
                    MainActivity.colleges[intCollegeIdx].scholarship = Integer.parseInt(txtScholarship.getText().toString());
                    MainActivity.colleges[intCollegeIdx].distance = Integer.parseInt(txtDistance.getText().toString());

                    MainActivity.colleges[intCollegeIdx].computeScore(MainActivity.weights); // update the score of this college
                }

                startActivity(new Intent(CollegeActivity.this, MainActivity.class));
            }
        });

        // display current info of this college
        if (intCollegeIdx >= 0 && intCollegeIdx < MainActivity.intMaxNumOfOffers) {  // 0~ for offers
            txtName.setText(MainActivity.colleges[intCollegeIdx].name);
            txtMajor.setText(MainActivity.colleges[intCollegeIdx].major);
            txtLocation.setText(MainActivity.colleges[intCollegeIdx].location);
            txtRank.setText(String.valueOf(MainActivity.colleges[intCollegeIdx].rank));
            txtLivingCost.setText(String.valueOf(MainActivity.colleges[intCollegeIdx].livingCost));
            txtTuition.setText(String.valueOf(MainActivity.colleges[intCollegeIdx].tuition));
            txtScholarship.setText(String.valueOf(MainActivity.colleges[intCollegeIdx].scholarship));
            txtDistance.setText(String.valueOf(MainActivity.colleges[intCollegeIdx].distance));
        }

    }
}
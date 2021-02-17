package com.example.pickyourcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final int intMaxCompareNum = 2;

    public static final int intMaxNumOfOffers = 10;
    public static College[] colleges = new College[intMaxNumOfOffers]; // save the offers in an Array
    public static int[] weights = {1, 1, 1, 1, 1};

    private Button btnWeights;
    private Button btnCompare;

    private EditText txtCurrent;
    private EditText [] txtOffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < intMaxNumOfOffers; i++) {
            colleges[i] = new College();   // works?
        }

        btnWeights  = (Button) findViewById(R.id.btnWeights);
        btnCompare  = (Button) findViewById(R.id.btnCompare);

        btnWeights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WeightActivity.class));
            }
        });

        btnCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CompareActivity.class);
                intent.putExtra("intCollegeIdxA", 0);    // 0~9 for offers, to be from checkboxes
                intent.putExtra("intCollegeIdxB", 1);    // 0~9 for offers, to be from checkboxes
                startActivity(intent);
            }
        });

        txtOffer = new EditText [] {
                (EditText) findViewById(R.id.txtOffer1),
                (EditText) findViewById(R.id.txtOffer2),
                (EditText) findViewById(R.id.txtOffer3),
                (EditText) findViewById(R.id.txtOffer4),
                (EditText) findViewById(R.id.txtOffer5),
                (EditText) findViewById(R.id.txtOffer6),
                (EditText) findViewById(R.id.txtOffer7),
                (EditText) findViewById(R.id.txtOffer8),
                (EditText) findViewById(R.id.txtOffer9),
                (EditText) findViewById(R.id.txtOffer10)
        };

    }
}
package com.example.backupbudgit;

import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.*;
import java.io.*;

public class BudgitInfoActivity extends AppCompatActivity {
    private Button profileHomeButton, visualizeButton, calculatorButton;
    public void onCreate(Bundle savedInsanceState){
        super.onCreate(savedInsanceState);
        setContentView((R.layout.data_entry));

        setupProfileHome();
        setupVisualize();
        setupCalc();
    }

    private void setupProfileHome(){

        profileHomeButton = findViewById(R.id.back_to_profile);
        profileHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BudgitInfoActivity.this, ProfileLanding.class);
                startActivity(intent);
            }
        });
    }

    private void setupVisualize(){
        visualizeButton = findViewById(R.id.to_chart_page);
        visualizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BudgitInfoActivity.this, ChartView.class);
                startActivity(intent);
            }
        });
    }

    private void setupCalc(){
        calculatorButton = findViewById(R.id.to_calculator);
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BudgitInfoActivity.this, MonthlyPaymentCalculator.class);
                startActivity(intent);
            }
        });

    }
}

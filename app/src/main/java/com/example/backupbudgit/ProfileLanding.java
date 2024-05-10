package com.example.backupbudgit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;

public class ProfileLanding extends ComponentActivity {
    private Button dataButton, visualizeButton, calculatorButton, logoutButton;
    private Button monthlyPaymentButton; //McLaughlin Button
    private Button budgetInfoButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main);
        //setupDataButton();
        setupVisualizeButton();
        //setupCalculatorButton();
        setupLogoutButton();

        //McLaughlin Monthly Payment Button Setup START
        setupMonthCalcButton();
        //END Mc

        setupBudgetInfoButton();
    }

/*    private void setupDataButton(){
        dataButton = findViewById(R.id.data_button);
        dataButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //whatever the data entry class is called needs to be identified here
                Intent intent = new Intent(ProfileLanding.this, dataEntry.class);
                startActivity(intent);
            }
        });
    }
*/
    private void setupVisualizeButton() {
        visualizeButton = findViewById(R.id.chart_view_button);
        visualizeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ProfileLanding.this, ChartView.class);
                startActivity(intent);
            }
        });
    }

    /*
    private void setupCalculatorButton(){
        calculatorButton = findViewById(R.id.calc_view_button);
        calculatorButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //whatever the calculator class will be called needs to be identified here
                Intent intent = new Intent(ProfileLanding.this, calculator.class);
                startActivity(intent);
            }
        });
    }
*/
    private void setupLogoutButton(){
        logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) { finish(); }

        });
    }

    private void setupBudgetInfoButton(){

        budgetInfoButton = findViewById(R.id.data_button);
        budgetInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileLanding.this, BudgitInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    //McLaughlin Monthly Payment Button Setup START
    private void setupMonthCalcButton(){
        monthlyPaymentButton = findViewById(R.id.paymentCalc_viewButton);
        monthlyPaymentButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) { openMothlyPaymentCalc(); }
        });
    }
    //END Mc

    //McLaughlin Monthly payment calculator open page START
    private void openMothlyPaymentCalc(){
        Intent intent = new Intent(ProfileLanding.this, MonthlyPaymentCalculator.class); // Replace ProfileActivity with your actual activity
        startActivity(intent);
    }
    //END Mc
}

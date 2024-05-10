package com.example.backupbudgit;

import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;
import java.io.*;

public class MonthlyPaymentCalculator extends AppCompatActivity {

    private Button calcMonths, calcPayments;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView((R.layout.payment_calculator));

        setupCalcMonths();
        setupCalcPayments();
    }

    //McLaughlin Monthly Payment Button Setup START
    private void setupCalcMonths(){
        calcMonths = findViewById(R.id.payCalc_button_calcMonths);
        calcMonths.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                calculateMonths();
            }
        });
    }
    //END Mc

    //McLaughlin Monthly Payment Button Setup START
    private void setupCalcPayments(){
        calcPayments = findViewById(R.id.payCalc_button_calcPayment);
        calcPayments.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                calculateMonthlyPayments();
            }
        });
    }
    //END Mc

    public void itWorked(){
        Toast.makeText(MonthlyPaymentCalculator.this, "Button Works!", Toast.LENGTH_LONG).show();
    }

    public void calculateMonths(){
        //itWorked();
        EditText totalBalanceInput = findViewById(R.id.payCalc_input_debtSize);
        EditText resultInput = findViewById(R.id.payCalc_input_results);
        EditText monthlyPaymentInput = findViewById(R.id.payCalc_input_monthlyPayments);

        String textFrom_debtSize = totalBalanceInput.getText().toString();
        double balance_f = Double.parseDouble(textFrom_debtSize);

        String textFrom_monthlyPayment = monthlyPaymentInput.getText().toString();
        double paymentSize_f = Double.parseDouble(textFrom_monthlyPayment);

        int monthsToCompletion = (int)Math.ceil((balance_f / paymentSize_f));

        resultInput.setText("Months to Payoff: " + monthsToCompletion);
    }

    public void calculateMonthlyPayments(){
        //itWorked();
        EditText totalBalanceInput = findViewById(R.id.payCalc_input_debtSize);
        EditText resultInput = findViewById(R.id.payCalc_input_results);
        EditText numMonthsInput = findViewById(R.id.payCalc_input_numMonths);

        String textFrom_debtSize = totalBalanceInput.getText().toString();
        double balance_f = Double.parseDouble(textFrom_debtSize);

        String textFrom_numMonths = numMonthsInput.getText().toString();
        int numMonths = Integer.parseInt(textFrom_numMonths);

        double monthlyPayment = balance_f / numMonths;
        String formattedValue = String.format("%.2f", monthlyPayment);
        resultInput.setText("Monthly Amnt: $" + formattedValue);
    }
}



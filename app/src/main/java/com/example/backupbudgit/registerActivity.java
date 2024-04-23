package com.example.backupbudgit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registerActivity extends AppCompatActivity {
    private EditText nameEditText, emailEditText, passwordEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createprofile);

//        nameEditText = findViewById(R.id.editTextName);
//        emailEditText = findViewById(R.id.editTextEmail);
//        passwordEditText = findViewById(R.id.editTextPassword);
//        submitButton = findViewById(R.id.buttonSubmit);
//
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                registerUser();
//            }
//        });
//    }
//
//    private void registerUser() {
//        String name = nameEditText.getText().toString();
//        String email = emailEditText.getText().toString();
//        String password = passwordEditText.getText().toString();
//
//        // Here you would add your logic to validate and store the user information
//        if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
//            Toast.makeText(registerActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
//            // Optionally redirect to another activity on successful registration
//        } else {
//            Toast.makeText(registerActivity.this, "Please fill all fields", Toast.LENGTH_LONG).show();
//        }
    }
}
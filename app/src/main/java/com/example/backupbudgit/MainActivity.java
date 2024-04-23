package com.example.backupbudgit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.loginpageUsername);
        passwordEditText = findViewById(R.id.loginpagePassword);

        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterLayout();
            }
        });
    }

    private void loginUser() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Here you can add your logic for validating login credentials
        if(username.equals("admin") && password.equals("admin123")) {
            // Login success
            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
            // Intent to navigate to another activity
        } else {
            // Login failed
            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }

    private void openRegisterLayout() {

        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
    }

}
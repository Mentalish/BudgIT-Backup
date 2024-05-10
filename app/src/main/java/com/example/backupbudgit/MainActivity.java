package com.example.backupbudgit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.*;
import java.io.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.backupbudgit.datamanagement.ReadCache;
import com.example.backupbudgit.datamanagement.WriteCache;


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

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
        }

        ReadCache readCache = new ReadCache( MainActivity.this);
        int userId = authenticate(username, password, readCache);

        if(userId != -1){
            // Login success
            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
            Intent login = new Intent(MainActivity.this, ProfileLanding.class); // Replace ProfileActivity with your actual activity
            startActivity(login);
        } else {
            // Login failed
            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }

    private void openRegisterLayout() {
        Intent register = new Intent(this, registerActivity.class);
        startActivity(register);
    }

    // Authentication Method, no syntatic errors
    private int authenticate(String username, String password, ReadCache readCache){
        Scanner scan;
        String str="";
        String[] userLoginInfo =  null;
        ArrayList<String> users;
        int id = -1;

        try{
            users = readCache.readAllFromCache(0, "LOGIN");

            for(int i = 0; i < users.size(); i++){
                userLoginInfo = users.get(i).split(",");

                if(Objects.equals(userLoginInfo[2], username) && Objects.equals(userLoginInfo[3], password)){
                    id = Integer.parseInt(userLoginInfo[0]);
                    break;
                }
            }

        }catch(IOException e){
            return -1;
        }

        return id;
    }

}



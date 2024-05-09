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

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);



//        String username = usernameEditText.getText().toString();
//        String password = passwordEditText.getText().toString();
//
//        // Here you can add your logic for validating login credentials
//        if(username.equals("admin") && password.equals("admin123")) {
//            // Login success
//            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
//            // Intent to navigate to another activity
//        } else {
//            // Login failed
//            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
//        }
    }

    private void openRegisterLayout() {

        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
    }

    // Authentication Method, no syntatic errors
    private int authenticate(String username, String password){
        Scanner scan;
        String str="";
        String[] userLoginInfo =  null;
        boolean authenticated = false;
        int id = -1;
        File f = new File(getFilesDir().getAbsolutePath()+"/login.txt");

        try{
            if(f.exists()) {

                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    userLoginInfo = str.split(",");
                    if (username.equalsIgnoreCase(userLoginInfo[1]) && password.equalsIgnoreCase(userLoginInfo[2])) {
                        authenticated = true;
                        id = Integer.parseInt(userLoginInfo[0]);
                        break;
                    }
                }
                scan.close();
            }
        } catch(IOException e){
            //TODO append to a .log file
            //TODO DELETE system.out.line below
            System.out.println("Error: " + e.getMessage());
        }
        return id;
    }

}



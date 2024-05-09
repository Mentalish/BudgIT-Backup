package com.example.backupbudgit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupLoginButtons();
        Toast.makeText(this, "Welcome to BudgIT!", Toast.LENGTH_SHORT).show();
    }

    private void setupLoginButtons(){
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText uText = findViewById(R.id.loginpageUsername);
                EditText pText = findViewById(R.id.loginpagePassword);
                int id = authenticate(uText.getText().toString(), pText.getText().toString());
                if(id > 0){
                    Intent intent = new Intent(MainActivity.this, ProfileLanding.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                } else {
                    uText.setText("");pText.setText("");
                    uText.setError("Incorrect username and password combination.");
                    pText.setError("Incorrect username and password combination.");
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, registerActivity.class);
                startActivity(intent);
            }
        });
    }

    private int authenticate(String username, String password) {
        Scanner scan;
        String str;
        String[] loginInfo;
        int id = -1;
        File f = new File(getFilesDir().getAbsolutePath() + "/login.txt");
        try {
            if(f.exists()) {
                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    loginInfo = str.split(",");
                    if (username.equalsIgnoreCase(loginInfo[1]) && password.equalsIgnoreCase(loginInfo[2])) {
                        id = Integer.parseInt(loginInfo[0]);
                        break;
                    }
                }
                scan.close();
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return id;
    }

}
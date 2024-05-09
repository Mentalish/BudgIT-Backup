package com.example.backupbudgit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class registerActivity extends AppCompatActivity {
    //   private EditText nameEditText, emailEditText, passwordEditText;
    //   private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createprofile);
        setupSubmitButton();
    }

    private void setupSubmitButton() {
        Button submitButton = (Button) findViewById(R.id.submit_registration);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int id = -1;
                EditText nameInput = (EditText) findViewById(R.id.register_nameInput);
                EditText uNameInput = (EditText) findViewById(R.id.register_userName);
                EditText passInput = (EditText) findViewById(R.id.register_password);
                EditText emailInput = (EditText) findViewById(R.id.register_emailInput);
                if (validateAccountInfo()) {
                    id = createLogin();
                    if (id > 0) {
                        createAccount(id);
                    }
                    finish();
                }  else {
                    nameInput.setText("");
                    uNameInput.setText("");
                    passInput.setText("");
                    emailInput.setText("");

                    nameInput.setError("All fields must be filled.");
                    uNameInput.setError("All fields must be filled.");
                    passInput.setError("All fields must be filled.");
                    emailInput.setError("All fields must be filled.");
                }
            }
        });
    }

    private boolean validateAccountInfo() {
        EditText nameInput = (EditText) findViewById(R.id.register_nameInput);
        EditText uNameInput = (EditText) findViewById(R.id.register_userName);
        EditText passInput = (EditText) findViewById(R.id.register_password);
        EditText emailInput = (EditText) findViewById(R.id.register_emailInput);

        return !nameInput.getText().toString().isEmpty() && !uNameInput.getText().toString().isEmpty() &&
                !passInput.getText().toString().isEmpty() && !emailInput.getText().toString().isEmpty();
    }

    private int createLogin() {
        EditText unameInput = (EditText) findViewById(R.id.register_userName);
        EditText passInput = (EditText) findViewById(R.id.register_password);
        String username = unameInput.getText().toString();
        String password = passInput.getText().toString();

        File list = new File(getFilesDir().getAbsolutePath() + "/login.txt");
        OutputStreamWriter writer;
        Scanner scan;
        int id = -1;
        String str = null;
        String[] userInfo;
        if (!list.exists()) {
            id = 1;
            try {
                writer = new OutputStreamWriter(openFileOutput("login.txt", MODE_PRIVATE));
                writer.write(id + "," + username + "," + password);
                writer.close();
            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            try {
                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNextLine()) {
                    str = scan.nextLine();
                }
                if (str != null) {
                    userInfo = str.split(",");
                    if (userInfo.length == 3) {
                        id = Integer.parseInt(userInfo[0]) + 1;
                    }
                }
                scan.close();
                writer = new OutputStreamWriter(openFileOutput("login.txt", MODE_APPEND));
                writer.append("\n" + id + "," + username + "," + password);
                writer.close();
            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return id;
    }


    private void createAccount(int id) {
        EditText nameInput = (EditText) findViewById(R.id.register_nameInput);
        EditText emailInput = (EditText) findViewById(R.id.register_emailInput);
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();

        File list = new File(getFilesDir().getAbsolutePath() + "/accounts.txt");
        OutputStreamWriter writer = null;

        if (!list.exists()) {
            id = 1;
            try {
                writer = new OutputStreamWriter(openFileOutput("accounts.txt", MODE_PRIVATE));
                writer.write(id + "," + name + "," + email);
                writer.close();
            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            try {
                writer = new OutputStreamWriter(openFileOutput("accounts.txt", MODE_APPEND));
                writer.append("\n" + id + "," + name + "," + email);
                writer.close();
            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
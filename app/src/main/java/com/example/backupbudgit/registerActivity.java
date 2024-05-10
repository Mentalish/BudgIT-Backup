package com.example.backupbudgit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;

import com.example.backupbudgit.datamanagement.IDManagement;
import com.example.backupbudgit.datamanagement.WriteCache;

public class registerActivity extends ComponentActivity {
    private EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText, nameEditLastName, usernameEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WriteCache writeCache = new WriteCache( registerActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createprofile);
        setButtons(writeCache);


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

    public void setButtons(WriteCache writeCache){
        nameEditText = (EditText) findViewById(R.id.editFirstName);
        nameEditLastName = (EditText) findViewById(R.id.editLastName);
        passwordEditText = (EditText) findViewById(R.id.editTextPassword);
        usernameEditText = (EditText) findViewById(R.id.editUsername);
        confirmPasswordEditText = (EditText) findViewById(R.id.editTextPassword2);
        submitButton = (Button) findViewById(R.id.buttonSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nameEditText.getText().toString().isEmpty() || !nameEditLastName.getText().toString().isEmpty() || !passwordEditText.getText().toString().isEmpty() || !confirmPasswordEditText.getText().toString().isEmpty() || !usernameEditText.getText().toString().isEmpty()){
                    if(passwordEditText.getText().toString().equals(confirmPasswordEditText.getText().toString())){
                        writeCache.writeToCache(0, (IDManagement.generateID() + "," + nameEditText.getText().toString() + ","  + nameEditLastName.getText().toString() + "," + usernameEditText.getText().toString()+ "," + passwordEditText.getText().toString()), "LOGIN");

                        Intent backToMain = new Intent(registerActivity.this, MainActivity.class);
                        startActivity(backToMain);
                    }else{
                        Toast.makeText(registerActivity.this, "Missing Information", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(registerActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
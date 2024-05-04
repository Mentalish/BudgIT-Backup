package com.example.backupbudgit.datamanagement;

import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class WriteCache extends ComponentActivity{
    public WriteCache(){}

    public void writeToCache(int userID, String line, String type){
        File userFile = new File(getFilesDir().getAbsolutePath(), "/" + Integer.toString(userID) + type+ ".txt");

        if(userFile.exists()){
            try {
                FileWriter writer = new FileWriter(userFile, true);
                writer.write("\n" + line);
                writer.close();
            }
            catch (IOException e){
                Toast.makeText(this, "ERROR storing data", Toast.LENGTH_SHORT).show();
            }
        }else{
            try {
                OutputStreamWriter writer = new OutputStreamWriter(openFileOutput(Integer.toString(userID) + type+ ".txt", MODE_PRIVATE));
                writer.write(line);
            }
            catch(IOException e){
                Toast.makeText(this, "ERROR storing data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void deleteFromCache(int userID, int itemID, String type){
        File userFile = new File(getFilesDir().getAbsolutePath(), "/" + Integer.toString(userID) + type+ ".txt");
        String[] tokens;
        String currLine;
        if(userFile.exists()){
            try{
                Scanner scan = new Scanner(userFile);
                FileWriter writer = new FileWriter(userFile);
                while(scan.hasNext()){
                    currLine = scan.nextLine();
                    tokens = currLine.split(",");

                    if(itemID == Integer.parseInt(tokens[1])){
                        writer.write("");
                    }
                }

                writer.close();
            }
            catch(IOException e){
                Toast.makeText(this, "ERROR deleting data", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

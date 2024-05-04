package com.example.backupbudgit.datamanagement;

import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ReadCache extends ComponentActivity {

    public ReadCache(){}
    public String readFromCache(int userID, int itemID, String type){
        String entry;
        String[] lineEntries;
        File userFile = new File(getFilesDir().getAbsolutePath(), "/" + Integer.toString(userID) + type + ".txt");

        if(userFile.exists()){
            try{
                Scanner scan = new Scanner(userFile);

                while(scan.hasNext()){
                    entry = scan.nextLine();
                    lineEntries = entry.split(",");

                    if(Integer.parseInt(lineEntries[1]) == userID){
                        return entry;
                    }
                }
            }
            catch(IOException e){
                Toast.makeText(this, "ERROR deleting data", Toast.LENGTH_SHORT).show();
                return null;
            }
        }

        return null;
    }

    public ArrayList<String> readAllFromCache(int userID, String type){
        ArrayList<String> allEntries = new ArrayList<>();
        String entry;
        String[] entryArr;
        File userFile = new File(getFilesDir().getAbsolutePath(), "/" + Integer.toString(userID) + type + ".txt");

        if(userFile.exists()){
            try{
                Scanner scan = new Scanner(userFile);

                while(scan.hasNext()){
                    entry = scan.nextLine();
                    entryArr = entry.split(",");

                    if(!Objects.equals(entry, "")){
                        allEntries.add(Integer.parseInt(entryArr[1]), entry);
                    }
                }
            }
            catch(IOException e){
                Toast.makeText(this, "ERROR deleting data", Toast.LENGTH_SHORT).show();
                return null;
            }
        }

        return allEntries;
    }
}

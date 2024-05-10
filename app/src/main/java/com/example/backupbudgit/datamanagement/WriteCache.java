package com.example.backupbudgit.datamanagement;

import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class WriteCache extends ComponentActivity{
    public WriteCache(){}

    public void writeToCache(int userID, String line, String type){
        File userFile = new File(getFilesDir().getAbsolutePath(),  Integer.toString(userID) + type + ".txt");
        String currLine;
        String[] currLineTok;
        Random random = new Random();

        if(userFile.exists()){
            try {
                //TODO: ID verification
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
                writer.close();
            }
            catch(IOException e){
                Toast.makeText(this, "ERROR storing data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void deleteFromCache(int userID, int itemID, String type){
        File userFile = new File(getFilesDir().getAbsolutePath(), Integer.toString(userID) + type + ".txt");
        String fileContents = "";
        String[] entries;
        String[] currLineTok;
        String currLine;
        if(userFile.exists()){
            try{
                Scanner scan = new Scanner(userFile);
                while(scan.hasNext()){
                    currLine = scan.nextLine();
                    currLineTok = currLine.split(",");

                    if(!Objects.equals(Integer.parseInt(currLineTok[1]), itemID)){
                        fileContents = fileContents.concat(currLine + "\n");
                    }
                }

                entries = fileContents.split("\n");

                //make file empty
                PrintWriter printWriter = new PrintWriter(userFile);
                printWriter.write("");
                printWriter.close();

                //create writer to re-write to file
                FileWriter userFileWriter = new FileWriter(userFile, true);

                //append file with new string
                for(int i = 0; i < entries.length; i++){
                    if(!Objects.equals(entries[i], "")){
                        userFileWriter.write(entries[i] + "\n");
                    }
                }

                userFileWriter.close();
            }
            catch(IOException e){
                Toast.makeText(this, "ERROR deleting data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void updateFromCache(int userID, int itemID, String type, String newline){
        File userFile = new File(getFilesDir().getAbsolutePath(), Integer.toString(userID) + type + ".txt");
        String fileContents = "";
        String[] entries;
        String[] currLineTok;
        String currLine;
        if(userFile.exists()){
            try{
                Scanner scan = new Scanner(userFile);
                while(scan.hasNext()){
                    currLine = scan.nextLine();
                    currLineTok = currLine.split(",");

                    if(!Objects.equals(Integer.parseInt(currLineTok[1]), itemID)){
                        fileContents = fileContents.concat(currLine + "\n");
                        continue;
                    }
                    fileContents = fileContents.concat(newline + "\n");
                }

                entries = fileContents.split("\n");

                //make file empty
                PrintWriter printWriter = new PrintWriter(userFile);
                printWriter.write("");
                printWriter.close();

                //create writer to re-write to file
                FileWriter userFileWriter = new FileWriter(userFile, true);

                //append file with new string
                for(int i = 0; i < entries.length; i++){
                    if(!Objects.equals(entries[i], "")){
                        userFileWriter.write(entries[i] + "\n");
                    }
                }

                userFileWriter.close();
            }
            catch(IOException e){
                Toast.makeText(this, "ERROR deleting data", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
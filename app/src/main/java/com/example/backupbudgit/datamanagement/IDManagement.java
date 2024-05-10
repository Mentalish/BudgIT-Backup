package com.example.backupbudgit.datamanagement;

import java.util.Random;

public class IDManagement {
    private IDManagement(){}

    public static int generateID(){
        Random rand = new Random(System.currentTimeMillis());
        return rand.nextInt(1000) * rand.nextInt(10) % 10;
    }
}

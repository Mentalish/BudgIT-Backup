package com.example.backupbudgit.datamanagement;

import com.example.backupbudgit.assets.*;
public class AssetManagement{
    private AssetManagement(){}

    public static Asset createAsset(WriteCache writeCache, int userID, int id, double value, double interest, String name){
        String line = "DEFAULT," + Integer.toString(userID) + "," + Double.toString(interest) + "," + name;
        writeCache.writeToCache(userID, line, "ASSETS");
        return new Asset(id, value, interest, name);
    }

    public static Car CreateCar(WriteCache writeCache, int userID, int id, double value, double interest, String name, int age, String model, String make, double mpg, Condition condition){
        String line = "CAR," + Integer.toString(userID) + "," + Double.toString(interest) + "," + name + Integer.toString(age) + "," + model + "," + make + "," + Double.toString(mpg) + "," + condition.name();
        writeCache.writeToCache(userID, line, "ASSETS");
        return new Car(id, value, interest, name, age, model, make, mpg, condition);
    }

    public static InvestmentAccount createInvestmentAccount(WriteCache writeCache, int userID, int id, double value, double interest, String name, String brokerage){
        String line = "DEFAULT," + Integer.toString(userID) + "," + Double.toString(interest) + "," + name + "," + brokerage;
        writeCache.writeToCache(userID, line, "ASSETS");
        return new InvestmentAccount(id, value, interest, name, brokerage);
    }

    public static Property createProperty(WriteCache writeCache, int userID, int id, double value, double interest, String name, int age, String address){
        String line = "DEFAULT," + Integer.toString(userID) + "," + Double.toString(interest) + "," + name + Integer.toString(age) + "," + address;
        writeCache.writeToCache(userID, line, "ASSETS");
        return new Property(id, value, interest, name, age, address);
    }

    public static SavingsAccount createSavingsAccount(WriteCache writeCache, int userID, int id, double value, double interest, String name, String bank){
        String line = "DEFAULT," + Integer.toString(userID) + "," + Double.toString(interest) + "," + name + "," + bank;
        writeCache.writeToCache(userID, line, "ASSETS");
        return new SavingsAccount(id, value, interest, name, bank);
    }
}
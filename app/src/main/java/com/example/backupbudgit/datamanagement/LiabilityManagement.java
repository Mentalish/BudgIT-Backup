package com.example.backupbudgit.datamanagement;

import com.example.backupbudgit.liabilities.*;
public class LiabilityManagement {
    private LiabilityManagement(){}

    public static Liability createLiability(WriteCache writeCache, int userID, int id, double balance, double interestRate, String name){
        String line = "DEFAULT," + Integer.toString(userID) + "," + Double.toString(balance) + "," + Double.toString(interestRate) + "," + name;
        writeCache.writeToCache(userID, line, "LIABILITY");
        return new Liability(id, balance, interestRate, name);
    }

    public static Mortgage createMortgage(WriteCache writeCache, int userID, int id, double balance, double interestRate, String name, int term){
        String line = "DEFAULT," + Integer.toString(userID) + "," + Double.toString(balance) + "," + Double.toString(interestRate) + "," + name + "," + Integer.toString(term);
        writeCache.writeToCache(userID, line, "LIABILITY");
        return new Mortgage(id, balance, interestRate, name, term);
    }

    public static CarNote createCarNote(WriteCache writeCache, int userID, int id, double balance, double interestRate, String name, int term){
        String line = "DEFAULT," + Integer.toString(userID) + "," + Double.toString(balance) + "," + Double.toString(interestRate) + "," + name + "," + Integer.toString(term);
        writeCache.writeToCache(userID, line, "LIABILITY");
        return new CarNote(id, balance, interestRate, name, term);
    }

    public static PersonalLoan createPersonalLoan(WriteCache writeCache, int userID, int id, double balance, double interestRate, String name, int age, String reason){
        String line = "DEFAULT," + Integer.toString(userID) + "," + Double.toString(balance) + "," + Double.toString(interestRate) + "," + name + "," + Integer.toString(age) + "," + reason;
        writeCache.writeToCache(userID, line, "LIABILITY");
        return new PersonalLoan(id, balance, interestRate, name, age, reason);
    }

    public static CreditCard createCreditCard(WriteCache writeCache, int userID, int id, double balance, double interestRate, String name, int age){
        String line = "DEFAULT," + Integer.toString(userID) + "," + Double.toString(balance) + "," + Double.toString(interestRate) + "," + name + "," + Integer.toString(age);
        writeCache.writeToCache(userID, line, "LIABILITY");
        return new CreditCard(id, balance, interestRate, name, age);
    }

    public static StudentLoan createStudentLoan(WriteCache writeCache, int userID, int id, double balance, double interestRate, String name, String degree, int age, boolean federal, boolean subsidized){
        String line = "DEFAULT," + Integer.toString(userID) + "," + Double.toString(balance) + "," + Double.toString(interestRate) + "," + name + "," + Integer.toString(age) + "," + Boolean.toString(federal) + "," +Boolean.toString(subsidized);
        writeCache.writeToCache(userID, line, "LIABILITY");
        return new StudentLoan(id, balance, interestRate, name, degree, age, federal, subsidized);
    }
}

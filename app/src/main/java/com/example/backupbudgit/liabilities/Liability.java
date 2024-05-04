package com.example.backupbudgit.liabilities;

public class Liability {
    private int id;
    private double balance;
    private double interestRate;
    private String name;

    public Liability(int id, double balance, double interestRate, String name) {
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
        this.name = name;
    }

    public Liability(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
package com.example.backupbudgit.assets;

public class Asset {
    private int id;
    private double value;
    private double interest;
    private String name;

    public Asset(int id, double value, double interest, String name) {
        this.id = id;
        this.value = value;
        this.interest = interest;
        this.name = name;
    }
    public Asset(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
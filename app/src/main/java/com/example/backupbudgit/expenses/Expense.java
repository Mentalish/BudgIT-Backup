package com.example.backupbudgit.expenses;

public class Expense {
    private int id;
    private double cost;
    private int day;
    private int month;
    private String name;

    public Expense(int id, double cost, int day, int month, String name) {
        this.id = id;
        this.cost = cost;
        this.day = day;
        this.month = month;
        this.name = name;
    }

    public Expense(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

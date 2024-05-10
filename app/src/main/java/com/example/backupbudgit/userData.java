package com.example.backupbudgit;

import com.example.backupbudgit.assets.*;
import com.example.backupbudgit.expenses.Expense;
import com.example.backupbudgit.liabilities.*;
import com.example.backupbudgit.transactions.*;

import java.io.Serializable;
import java.util.ArrayList;

public class userData implements Serializable{
    enum day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    enum payPeriod {
        DAILY,
        WEEKLY,
        BIWEEKLY,
        MONTHLY,
        YEARLY
    }

    private String firstName;
    private String lastName;
    private double income;
    private double payPerPeriod;
    private ArrayList<Asset> assets;
    private ArrayList<Liability> liabilities;
    private ArrayList<Transaction> transactions;
    private ArrayList<Expense> expenses;
    private double netWorth;
    private day payDay;
    private payPeriod payPeriod;

    public userData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.assets = new ArrayList<Asset>();
        this.liabilities = new ArrayList<Liability>();
        this.transactions = new ArrayList<Transaction>();
        this.expenses = new ArrayList<Expense>();
    }

    public userData(){
        this.assets = new ArrayList<Asset>();
        this.liabilities = new ArrayList<Liability>();
        this.transactions = new ArrayList<Transaction>();
        this.expenses = new ArrayList<Expense>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getPayPerPeriod() {
        return payPerPeriod;
    }

    public void setPayPerPeriod(double payPerPeriod) {
        this.payPerPeriod = payPerPeriod;
    }

    public Asset getAsset(int index) {
        return this.assets.get(index);
    }

    public void setAsset(Asset asset) {
        this.assets.add(asset);
    }

    public Liability getLiabilities(int index) {
        return liabilities.get(index);
    }

    public void setLiabilities(Liability liability) {
        this.liabilities.add(liability);
    }

    public Transaction getTransactions(int index) {
        return transactions.get(index);
    }

    public void setTransactions(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    public day getPayDay() {
        return payDay;
    }

    public void setPayDay(day payDay) {
        this.payDay = payDay;
    }

    public payPeriod getPayPeriod(){
        return payPeriod;
    }

    public void setPayPeriod(payPeriod payPeriod){
        this.payPeriod = payPeriod;
    }

    public Expense getExpenses(int index) {
        return expenses.get(index);
    }

    public void setExpense(Expense expense){
        this.expenses.add(expense);
    }
}
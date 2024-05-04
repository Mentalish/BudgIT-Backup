package com.example.backupbudgit.liabilities;

public class CreditCard extends Liability{
    private double age;

    public CreditCard(int id, double balance, double interestRate, String name, double age) {
        super(id, balance, interestRate, name);
        this.age = age;
    }

    public CreditCard(int id, double age) {
        super(id);
        this.age = age;
    }

    public CreditCard(int id){
        super(id);
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
package com.example.backupbudgit.liabilities;

public class PersonalLoan extends Liability{
    private int age;
    private String reason;

    public PersonalLoan(int id, double balance, double interestRate, String name, int age, String reason) {
        super(id, balance, interestRate, name);
        this.age = age;
        this.reason = reason;
    }

    public PersonalLoan(int id, int age, String reason) {
        super(id);
        this.age = age;
        this.reason = reason;
    }

    public PersonalLoan(int id){
        super(id);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
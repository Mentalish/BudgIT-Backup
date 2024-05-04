package com.example.backupbudgit.liabilities;

public class StudentLoan extends Liability{
    private String Degree;
    private int age;
    private boolean federal;
    private boolean subsidized;

    public StudentLoan(int id, double balance, double interestRate, String name, String degree, int age, boolean federal, boolean subsidized) {
        super(id, balance, interestRate, name);
        Degree = degree;
        this.age = age;
        this.federal = federal;
        this.subsidized = subsidized;
    }

    public StudentLoan(int id, String degree, int age, boolean federal, boolean subsidized) {
        super(id);
        Degree = degree;
        this.age = age;
        this.federal = federal;
        this.subsidized = subsidized;
    }

    public StudentLoan(int id){
        super(id);
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFederal() {
        return federal;
    }

    public void setFederal(boolean federal) {
        this.federal = federal;
    }

    public boolean isSubsidized() {
        return subsidized;
    }

    public void setSubsidized(boolean subsidized) {
        this.subsidized = subsidized;
    }
}
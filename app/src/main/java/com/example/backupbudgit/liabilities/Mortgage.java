package com.example.backupbudgit.liabilities;

public class Mortgage extends Liability{
    private int term;

    public Mortgage(int id, double balance, double interestRate, String name, int term) {
        super(id, balance, interestRate, name);
        this.term = term;
    }

    public Mortgage(int id, int term) {
        super(id);
        this.term = term;
    }

    public Mortgage(int id){
        super(id);
    }
}
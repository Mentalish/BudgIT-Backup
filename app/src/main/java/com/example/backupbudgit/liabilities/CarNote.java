package com.example.backupbudgit.liabilities;

public class CarNote extends Liability{
    private int termInMonths;

    public CarNote(int id, double balance, double interestRate, String name, int termInMonths) {
        super(id, balance, interestRate, name);
        this.termInMonths = termInMonths;
    }

    public CarNote(int id, int termInMonths) {
        super(id);
        this.termInMonths = termInMonths;
    }

    public CarNote(int id){
        super(id);
    }

    public int getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(int termInMonths) {
        this.termInMonths = termInMonths;
    }
}
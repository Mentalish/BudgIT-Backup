package com.example.backupbudgit.assets;

public class SavingsAccount extends Asset{
    private String Bank;

    public SavingsAccount(int id, double value, double interest, String name, String bank) {
        super(id, value, interest, name);
        this.Bank = bank;
    }

    public SavingsAccount(int id, double value, double interest, String name){
        super(id, value, interest, name);
    }

    public SavingsAccount(int id){
        super(id);
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }
}

package com.example.backupbudgit.assets;

import java.util.ArrayList;

public class InvestmentAccount extends Asset{
    private String brokerage;
    private ArrayList<Security> portfolio;

    public InvestmentAccount(int id, double value, double interest, String name, String brokerage) {
        super(id, value, interest, name);
        this.brokerage = brokerage;
        this.portfolio = new ArrayList<Security>();
    }

    public InvestmentAccount(int id, String brokerage, ArrayList<Security> portfolio) {
        super(id);
        this.brokerage = brokerage;
        this.portfolio = portfolio;
    }

    public String getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(String brokerage) {
        this.brokerage = brokerage;
    }

    public ArrayList<Security> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(ArrayList<Security> portfolio) {
        this.portfolio = portfolio;
    }
}
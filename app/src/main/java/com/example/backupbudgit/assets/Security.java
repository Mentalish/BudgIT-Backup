package com.example.backupbudgit.assets;

public class Security {
    private String ticker;
    private int shares;
    private double pricePerShare;

    public Security(String ticker, int shares, double pricePerShare) {
        this.ticker = ticker;
        this.shares = shares;
        this.pricePerShare = pricePerShare;
    }
}

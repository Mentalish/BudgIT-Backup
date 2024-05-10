package com.example.backupbudgit.datamanagement;

import com.example.backupbudgit.assets.Asset;
import com.example.backupbudgit.expenses.Expense;
import com.example.backupbudgit.liabilities.Liability;
import com.example.backupbudgit.transactions.Transaction;
import com.example.backupbudgit.userData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CreateFromCache {
    private CreateFromCache(){}

    public userData initFromCache(int userID) throws IOException{
        ReadCache readCache = new ReadCache();
        userData userData = new userData();
        ArrayList<String> assets;
        ArrayList<String> liabilities;
        ArrayList<String> expenses;
        ArrayList<String> transactions;
        ArrayList<String> userDataFile;

        String currString;
        String[] currStringArr;

        try{
            assets = readCache.readAllFromCache(userID, "ASSETS");
            liabilities = readCache.readAllFromCache(userID, "LIABILITY");
            expenses = readCache.readAllFromCache(userID, "EXPENSE");
            transactions = readCache.readAllFromCache(userID, "TRANSACTIONS");

            if(assets != null){
                for(int i = 0; i < assets.size(); i++){
                    currString = assets.get(i);
                    if(!Objects.equals(currString, "")){
                        currStringArr = currString.split(",");

                        if(Objects.equals(currStringArr[0], "DEFAULT")){
                            userData.setAsset(new Asset(Integer.parseInt(currStringArr[1]), Double.parseDouble(currStringArr[2]), Double.parseDouble(currStringArr[3]), currStringArr[4]));
                        }
                    }
                }
            }

            if(liabilities != null){
                for(int i = 0; i < liabilities.size(); i++){
                    currString = liabilities.get(i);
                    if(!Objects.equals(currString, "")){
                        currStringArr = currString.split(",");

                        if(Objects.equals(currStringArr[0], "DEFAULT")){
                            userData.setLiabilities(new Liability(Integer.parseInt(currStringArr[1]), Double.parseDouble(currStringArr[2]), Double.parseDouble(currStringArr[3]), currStringArr[1]));
                        }
                    }
                }
            }

            if(expenses != null){
                for(int i = 0; i < expenses.size(); i++){
                    currString = expenses.get(i);
                    if(!Objects.equals(currString, "")){
                        currStringArr = currString.split(",");

                        if(Objects.equals(currStringArr[0], "DEFAULT")){
                            userData.setExpense(new Expense(Integer.parseInt(currStringArr[1]), Double.parseDouble(currStringArr[2]), Integer.parseInt(currStringArr[3]), Integer.parseInt(currStringArr[4]), currStringArr[5]));
                        }
                    }
                }
            }

            if(transactions != null){
                for(int i = 0; i < transactions.size(); i++){
                    currString = transactions.get(i);
                    if(!Objects.equals(currString, "")){
                        currStringArr = currString.split(",");

                        if(Objects.equals(currStringArr[0], "DEFAULT")){
                            userData.setTransactions(new Transaction(Integer.parseInt(currStringArr[1]), Double.parseDouble(currStringArr[2]), currStringArr[1]));
                        }
                    }
                }
            }

            userDataFile = readCache.readAllFromCache(userID, "USERDATA");

            currString = userDataFile.get(0);

            currStringArr = currString.split(",");

            userData.setFirstName(currStringArr[0]);
            userData.setLastName(currStringArr[1]);
            userData.setIncome(Double.parseDouble(currStringArr[2]));
            userData.setPayPerPeriod(Double.parseDouble(currStringArr[3]));
            userData.setPayPerPeriod(Double.parseDouble(currStringArr[4]));
            //userData.setPayDay(currStringArr[5]);
            //userData.setPayPeriod(currStringArr[6]);
        }catch (IOException e){
            throw new IOException("demo");
        }

        return userData;
    }
}

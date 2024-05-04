package com.example.backupbudgit.datamanagement;

import com.example.backupbudgit.expenses.*;

public class ExpenseManagement {
    private ExpenseManagement(){}
    public static Expense createExpense(WriteCache writeCache, int userID, int id, double cost, int day, int month, String name){
        String line = "DEFAULT," + Integer.toString(userID) + "," + cost  + "," + Integer.toString(day) + "," + Integer.toString(month) + "," + name;
        writeCache.writeToCache(userID, line, "EXPENSE");
        return new Expense(id, cost, day, month, name);
    }
}

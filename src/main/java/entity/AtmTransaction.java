package entity;

import constant.Constant;

class AtmTransaction {
    private String accountNumber;
    private String type; // "Withdraw" or "Deposit"
    private double amount;
    private String date;

    public AtmTransaction(String accountNumber, String type, double amount, String date) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }


    public String toCsv() {
        return accountNumber + Constant.DELIMITER + type + Constant.DELIMITER + amount + Constant.DELIMITER + date;
    }

    @Override
    public String toString() {
        return type + " of Rs." + amount + " on " + date;
    }
}

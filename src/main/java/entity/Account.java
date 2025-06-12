package entity;

import constant.Constant;

public class Account {
    private int accountId;
    private String accountStatus;
    private int accountBalance;
    private String accountDescription;
    private Customer customer;
    private String openingDate;
    private String accountType;

    public Account(int accountId, String accountStatus, int accountBalance, String accountDescription, Customer customer,String openingDate, String accountType) {
        this.accountId = accountId;
        this.accountStatus = accountStatus;
        this.accountBalance = accountBalance;
        this.accountDescription = accountDescription;
        this.customer = customer;
        this.openingDate = openingDate;
        this.accountType = accountType;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public void deposit(int accountBalance){
        this.accountBalance += accountBalance;
        System.out.println(accountBalance + "Deposited");
    }

    public String toCsv() {
        return accountId + Constant.DELIMITER
                + accountStatus + Constant.DELIMITER
                + accountBalance + Constant.DELIMITER
                + accountDescription + Constant.DELIMITER
                + customer.getCustomerId() + Constant.DELIMITER
                + openingDate + Constant.DELIMITER
                + accountType;
    }



    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountStatus='" + accountStatus + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountDescription='" + accountDescription + '\'' +
                ", customer=" + customer +
                ", openingDate='" + openingDate + '\'' +
                '}';
    }
}

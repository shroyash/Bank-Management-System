package service;

import entity.Account;
import entity.CurrentAccount;
import entity.SavingAccount;
import manager.AccountManager;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    AccountManager accountManager = new AccountManager();
    SavingAccount savingAccount = new SavingAccount();
    CurrentAccount currentAccount = new CurrentAccount();
    public void addAccount(Account account){
        List<Account> accountList = accountManager.readAccountsFromFile();
        accountList.add(account);
        accountManager.writeAccountsToFile(accountList);
    }

    public boolean depositToAccount(int accountId, double amount) {
        List<Account> accountList = accountManager.readAccountsFromFile();
        boolean found = false;

        for (Account acc : accountList) {
            System.out.println(acc.getAccountId());
            System.out.println(accountId);
            if (acc.getAccountId() == accountId) {
                int currentBalance = acc.getAccountBalance();
                acc.setAccountBalance((int) (currentBalance + amount));
                found = true;
                break;
            }
        }

        if (found) {
            accountManager.writeAccountsToFile(accountList); // save updated balances
        }

        return found;
    }

    public List<Account> getAccountsByCustomerId(int customerId) {
        List<Account> allAccounts = accountManager.readAccountsFromFile();
        List<Account> customerAccounts = new ArrayList<>();

        for (Account acc : allAccounts) {
            if (acc.getCustomer() != null && acc.getCustomer().getCustomerId() == customerId) {
                customerAccounts.add(acc);
            }
        }

        return customerAccounts;
    }
    public boolean withdrawFromAccount(int accountId, double balance){
        List<Account> accountList = accountManager.readAccountsFromFile();
        for(Account account : accountList){
            if(account.getAccountId() == accountId){
                if(account.getAccountType().equals("Saving Account")){
                    savingAccount.withdraw(balance);
                    return true;
                }else {
                    currentAccount.withdraw(balance);
                    return true;
                }
            }
        }
        return false;

    }

    public void viewAccountsByCustomerId(int customerId) {
        List<Account> accountList = accountManager.readAccountsFromFile();
        boolean found = false;

        System.out.println("\n==== Account Details ====");
        for (Account acc : accountList) {
            if (acc.getCustomer() != null && acc.getCustomer().getCustomerId() == customerId) {
                System.out.println("Account ID       : " + acc.getAccountId());
                System.out.println("Account Type     : " + acc.getAccountType());
                System.out.println("Account Status   : " + acc.getAccountStatus());
                System.out.println("Account Balance  : " + acc.getAccountBalance());
                System.out.println("Account Desc     : " + acc.getAccountDescription());
                System.out.println("Opening Date     : " + acc.getOpeningDate());
                System.out.println("---------------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No accounts found for Customer ID: " + customerId);
        }
    }



}

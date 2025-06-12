package service;

import entity.Account;
import manager.AccountManager;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    AccountManager accountManager = new AccountManager();
    public void addAccount(Account account){
        List<Account> accountList = accountManager.readAccountsFromFile();
        accountList.add(account);
        accountManager.writeAccountsToFile(accountList);
    }
}

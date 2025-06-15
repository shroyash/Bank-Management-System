package service;

import entity.Bank;
import manager.BankManager;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    BankManager bankManager = new BankManager();

    public void addBank(int bankCode, String bankAddress, String bankName ){
        List<Bank> banklist = bankManager.readBankFile();
        banklist.add(new Bank(bankCode,bankAddress,bankName));
        bankManager.writeToBankFile(banklist);
        System.out.println("Sucessfully bank created");
    }
}

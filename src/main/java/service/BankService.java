package service;

import entity.Bank;
import manager.BankManager;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    List<Bank> bankList = new ArrayList<>();
    BankManager bankManager = new BankManager();

    public void addBank(int bankCode, String bankAddress, String bankName ){
        bankList.add(new Bank(bankCode,bankAddress,bankName));
        System.out.println("Sucessfully bank created");
        bankManager.writeToBankFile(bankList);
    }

}

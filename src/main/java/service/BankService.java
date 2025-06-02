package service;

import entity.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    List<Bank> bankList = new ArrayList<>();

    public void addBank(int bankCode, String bankAddress, String bankName ){
        bankList.add(new Bank(bankCode,bankAddress,bankName));
    }

}

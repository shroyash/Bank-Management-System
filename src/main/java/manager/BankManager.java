package manager;

import constant.Constant;
import entity.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankManager {
    FileManager fileManager = new FileManager();

    public void writeToBankFile(List<Bank> bankList){
        List<String> bankListPlanData = new ArrayList<>();
        for(Bank data : bankList){
            bankListPlanData.add(data.toCsv());
        }
        fileManager.writeFile(Constant.BANK_FILE,bankListPlanData);
    }

    public void getBankList(){
       List<String> bankList =  fileManager.readFile(Constant.BANK_FILE);
       for(String bank : bankList){
           System.out.println(bank);
       }
    }


}

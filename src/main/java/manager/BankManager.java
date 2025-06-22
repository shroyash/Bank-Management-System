package manager;

import constant.Constant;
import entity.Bank;
import userInterface.AdminRegistration;
import userInterface.LandingUI;
import userInterface.RegisterCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankManager {
    FileManager fileManager = new FileManager();
    RegisterCustomer registerCustomer = new RegisterCustomer();
    AdminRegistration adminRegistration = new AdminRegistration();


    public void writeToBankFile(List<Bank> bankList){
        List<String> bankListPlanData = new ArrayList<>();
        for(Bank data : bankList){
            bankListPlanData.add(data.toCsv());
        }
        fileManager.writeFile(Constant.BANK_FILE,bankListPlanData);
    }

    public List<Bank>  readBankFile() {
        List<String> bankListFile = fileManager.readFile(Constant.BANK_FILE);
        List<Bank> bankList = new ArrayList<>();

        for (String line : bankListFile) {
            String[] bankData = line.split(Constant.DELIMITER);
                int code = Integer.parseInt(bankData[0]);
                String address = bankData[1];
                String name = bankData[2];
                Bank bank = new Bank(code, address, name);
                bankList.add(bank);

        }
        return bankList;

    }


    public void getBankList() {
        List<String> bankList = fileManager.readFile(Constant.BANK_FILE);
        Scanner sc = new Scanner(System.in);

        if (bankList.isEmpty()) {
            System.out.println("No Bank Created till Now");
            System.out.println("Create Your Own Bank?");
            System.out.print("Press 1 to go option: ");
            int option = sc.nextInt();
            if (option == 1) LandingUI.start();
            return;
        }

        System.out.println("Available Banks:");
        for (int i = 0; i < bankList.size(); i++) {
            String[] parts = bankList.get(i).split(Constant.DELIMITER);
            String bankName = parts[2];
            System.out.println( (i+1) + "." + bankName);
        }
        RegisterCustomer registerCustomer = new RegisterCustomer();
        System.out.println("Chose Option of bank");
        int chooseBank = sc.nextInt();
        registerCustomer.displayLoginOption();
        int registerOption = sc.nextInt();
        switch (registerOption){
            case 1 : registerCustomer.registerNewCustomer();
            break;
            case 2 : registerCustomer.loginCustomer();
            break;
            case 3 : adminRegistration.loginAdmin();
        }

    }




}

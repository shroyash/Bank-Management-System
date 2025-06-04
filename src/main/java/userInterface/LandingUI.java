package userInterface;

import constant.Constant;
import entity.Bank;
import manager.BankManager;
import service.BankService;

import java.util.Scanner;

public class LandingUI {

    public static void start(){
        System.out.println(Constant.WELCOME_MESSAGE);
        System.out.println("1). Create a New Bank");
        System.out.println("2). Use Existing Bank");
        System.out.print("Choose Option : ");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        BankManager bankManager = new BankManager();
        switch (option){
            case 1 :
                CreateBankUI.createBank(sc);
                break;
            case 2 :
                bankManager.getBankList();
                break;

            default:
                System.out.println("Invalid input");
        }
    }
}

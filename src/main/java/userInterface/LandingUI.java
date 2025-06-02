package userInterface;

import constant.Constant;
import service.BankService;

import java.util.Scanner;

public class LandingUI {

    public void start(){
        System.out.println(Constant.WELCOME_MESSAGE);
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        BankService bankService = new BankService();
        switch (option){
            case 1 :
                System.out.println("1). Create a New Bank");
                CreateBankUI.createBank(sc);

                break;
            case 2 :
                System.out.println("2). Use Existing Bank");
                bankService.getClass();
                break;

            default:
                System.out.println("Invalid input");
        }


    }
}

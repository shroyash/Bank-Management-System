package userInterface;

import entity.Bank;
import service.BankService;

import java.util.Scanner;

public class CreateBankUI {
    public static void createBank(Scanner sc){
        System.out.print("Enter Bank Code: ");
        int bankCode = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Bank Address: ");
        String bankAddress = sc.nextLine();

        System.out.print("Enter Bank Address: ");
        String bankName = sc.nextLine();

        BankService bankService = new BankService();
        bankService.addBank(bankCode,bankAddress,bankName);
    }
}

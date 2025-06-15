package userInterface;

import entity.Account;
import service.AccountService;

import java.util.List;
import java.util.Scanner;

public class MainUI {

    public static void mainUi() {

        BankUI bankUI = new BankUI();
        AccountService accountService = new AccountService();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Welcome to the Bank ---");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> bankUI.showAccountOptions();

                case 2 -> {
                    System.out.print("Enter your Customer ID: ");
                    int customerId = scanner.nextInt();
                    accountService.viewAccountsByCustomerId(customerId);
                }

                case 3 -> {
                    System.out.print("Enter Account ID to deposit into: ");
                    int accountId = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();

                    boolean success = accountService.depositToAccount(accountId, amount);
                    if (success) {
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Account not found. Please check Account ID.");
                    }
                }

                case 4 -> {
                    System.out.print("Enter Account ID: ");
                    int accountId = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();

                    boolean success = accountService.withdrawFromAccount(accountId, amount);
                    if (success) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Withdrawal failed. Check account or balance.");
                    }
                }

                case 5 -> {
                    running = false;
                    System.out.println("Thank you for banking with us!");
                }

                default -> System.out.println("⚠Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

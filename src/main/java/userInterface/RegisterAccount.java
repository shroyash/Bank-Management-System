package userInterface;

import entity.Account;
import entity.Customer;
import service.AccountService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class RegisterAccount {

    private final Scanner scanner = new Scanner(System.in);
    LocalDateTime currentDateTime = LocalDateTime.now();
    AccountService accountService = new AccountService();



    public void register(String accountType) {
        System.out.println("=== Register New Bank Account ===");

        // Get customer info
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        Customer customer = new Customer(customerId,customerName);

        // Get account info
        System.out.print("Enter Account Status (Active/Inactive): ");
        String status = scanner.nextLine();

        System.out.print("Enter Initial Deposit Amount: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Account Description: ");
        String description = scanner.nextLine();

        // Generate random Account ID
        int accountId = new Random().nextInt(900000) + 100000;

        // Create Account object
        Account account = new Account(accountId, status, (int) balance, description, customer,currentDateTime.toString(),accountType);
        accountService.addAccount(account);
        System.out.println("\nAccount created successfully!");
        System.out.println(account);

        // Ask for account type to deposit into
        System.out.println("\nIn which account do you want to deposit?");
        System.out.println("1. Saving Account");
        System.out.println("2. Current Account");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                register("Saving Account");
                System.out.println("Register into Saving Account...");

            }
            case 2 -> {
                register("Current Account");
                System.out.println("Register into Saving Account...");
            }
            default -> System.out.println("Invalid choice. No deposit made.");
        }

        System.out.println("\nFinal Account Info:");
        System.out.println(account);
    }
}

package userInterface;

import java.util.Scanner;

public class BankUI {
    Scanner scanner = new Scanner(System.in);
    RegisterAccount registerAccount = new RegisterAccount();
    public  void showAccountOptions() {
        while (true) {
            System.out.println("\nSelect an account to create");
            System.out.println("1. Saving Account");
            System.out.println("2. Current Account");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerAccount.register("Saving Account");
                    break;
                case 2:
                    registerAccount.register("current Account");
                    break;
                case 3:
                    System.out.println("Thank you! Goodbye.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }





}

package userInterface;

import java.util.Scanner;

public class MainUI {

    public static void mainUi(){

        BankUI bankUI = new BankUI();

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
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    bankUI.showAccountOptions();
                    break;
                case 2:
                    System.out.println("Viewing account (details would go here)");
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println("Deposited: $" + depositAmount);
                    break;
                case 4:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println("Withdrew: $" + withdrawAmount);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}

package userInterface;

import service.AdminService;


import java.util.Scanner;

public class AdminPannel {

    public static void showAdminPanel() {
        Scanner scanner = new Scanner(System.in);
        AdminService adminService = new AdminService();


        boolean running = true;

        while (running) {
            System.out.println("\n=== Admin Panel ===");
            System.out.println("1. View All Customers of a Bank");
            System.out.println("2. View All Accounts of a Bank");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Bank Name: ");
                    String bankNameCustomer = scanner.nextLine();
                    adminService.viewAllCustomers(bankNameCustomer);
                    break;

                case 2:
                    System.out.print("Enter Bank Name: ");
                    String bankNameAccount = scanner.nextLine();
                    adminService.viewAllAccountsByBank(bankNameAccount);
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting Admin Panel...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

package userInterface;

import entity.Admin;
import manager.AdminManager;
import manager.BankManager;

import java.util.Scanner;

public class AdminRegistration {
    private final AdminManager adminManager = new AdminManager();
    private final Scanner scanner = new Scanner(System.in);

    public void registerAdmin() {
        System.out.println("==== Admin Registration ====");
        System.out.print("Enter Admin ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Admin BankName: ");
        String bankName = scanner.nextLine();
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        Admin admin = new Admin(bankName,id, username, password);
        adminManager.registerAdmin(admin);

        System.out.println("Admin registered successfully!");

    }

    public void loginAdmin() {
        System.out.println("==== Admin Login ====");
        System.out.print("Enter Admin BankName: ");
        String bankName = scanner.nextLine();
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        boolean isValid = adminManager.validateLogin(bankName,username,password);
        if(isValid){
            System.out.println("Login Sucessful");
        }else{
            System.out.println("Invalid user credential");
        }
    }
}


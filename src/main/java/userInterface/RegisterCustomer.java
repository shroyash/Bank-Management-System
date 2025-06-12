package userInterface;

import entity.Customer;
import org.example.Main;
import service.CustomerService;

import java.util.Scanner;

public class RegisterCustomer {

    private final CustomerService customerService = new CustomerService();

    public void displayLoginOption(){
        System.out.println("1). Register as Customer");
        System.out.println("2). Login as Customer");
        System.out.println("3). Login as Admin");
    }

    public void registerNewCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your address: ");
        String address = scanner.nextLine();

        System.out.println("Enter your phone number: ");
        String phone = scanner.nextLine();

        System.out.println("Choose a username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        int password = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter your card info: ");
        String card = scanner.nextLine();

        System.out.println("Enter your BankName: ");
        String bankName = scanner.nextLine();

        Customer customer = new Customer(id, name, phone, password, username, address, card, bankName);
        customerService.registerCustomer(customer);
        System.out.println("Customer registered successfully!");
        loginCustomer();

    }

    public void loginCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your bank name: ");
        String bankName = scanner.nextLine();

        System.out.println("Enter your username: ");
        String userName = scanner.nextLine();

        System.out.println("Enter your password: ");
        int password = Integer.parseInt(scanner.nextLine());

       boolean isValid = customerService.isValidCustomer(bankName, userName, password);
        if (isValid) {
            System.out.println("Login successful. Welcome, " + userName + "!");
            MainUI.mainUi();
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }


}

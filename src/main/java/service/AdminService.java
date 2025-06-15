package service;

import entity.Account;
import entity.Customer;
import manager.AccountManager;
import manager.CustomerManager;

import java.util.List;

public class AdminService {

    CustomerManager customerManager = new CustomerManager();
    AccountManager accountManager = new AccountManager();

    public void viewAllCustomers(String bankName) {
        List<Customer> customerList = customerManager.readCustomersFromFile();
        boolean found = false;

        System.out.println("\n=== All Customers for Bank: " + bankName + " ===");

        for (Customer data : customerList) {
            if (data.getBankName().equalsIgnoreCase(bankName)) {
                found = true;
                System.out.println("Customer ID   : " + data.getCustomerId());
                System.out.println("Name          : " + data.getCustomerName());
                System.out.println("Address          : " + data.getCustomerAddress());
                System.out.println("Phone Number      :" + data.getCustomerAddress() );
                System.out.println("----------------------------------------");
            }
        }

        if (!found) {
            System.out.println(" No customers found for this bank.");
        }
    }

    public void viewAllAccountsByBank(String bankName) {
        List<Customer> customerList = customerManager.readCustomersFromFile();
        List<Account> accountList = accountManager.readAccountsFromFile();

        System.out.println("\n=== Accounts for Customers in Bank: " + bankName + " ===");

        boolean found = false;

        for (Customer customer : customerList) {
            if (customer.getBankName().equalsIgnoreCase(bankName)) {
                for (Account account : accountList) {
                    if (account.getCustomer() != null &&
                            account.getCustomer().getCustomerId() == customer.getCustomerId()) {

                        found = true;
                        System.out.println("Customer Name : " + customer.getCustomerName());
                        System.out.println("  Account ID   : " + account.getAccountId());
                        System.out.println("  Type         : " + account.getAccountType());
                        System.out.println("  Status       : " + account.getAccountStatus());
                        System.out.println("  Balance      : " + account.getAccountBalance());
                        System.out.println("  Opened On    : " + account.getOpeningDate());
                        System.out.println("------------------------------------------");
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No accounts found for this bank.");
        }
    }
}

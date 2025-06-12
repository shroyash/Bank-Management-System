package service;

import entity.Customer;
import manager.CustomerManager;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    CustomerManager customerManager = new CustomerManager();

    public void registerCustomer(Customer customer) {
        List<Customer> customerList = customerManager.readCustomersFromFile();
        customerList.add(customer);
        customerManager.writeCustomersToFile(customerList);
    }

    public boolean isValidCustomer(String bankName, String userName, int password) {
        List<Customer> customerList = customerManager.readCustomersFromFile();

        // Log input
        System.out.println("Input Bank: " + bankName);
        System.out.println("Input User: " + userName);
        System.out.println("Input Pass: " + password);

        for (Customer data : customerList) {
            System.out.println("=== Checking Customer ===");
            System.out.println("Stored Bank: " + data.getBankName());
            System.out.println("Stored User: " + data.getCustomerUserName());
            System.out.println("Stored Pass: " + data.getCustomerPassword());

            if (
                    data.getBankName().equals(bankName) &&
                            data.getCustomerUserName().equals(userName) &&
                            data.getCustomerPassword() == password
            ) {
                return true;
            }
        }

        return false;
    }

}
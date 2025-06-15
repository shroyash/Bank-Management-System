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

        for (Customer data : customerList) {
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
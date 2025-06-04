package manager;

import constant.Constant;
import entity.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

     FileManager fileManager = new FileManager();

    public List<Customer> readCustomersFromFile() {
        List<String> lines = fileManager.readFile(Constant.CUSTOMER_FILE);
        List<Customer> customers = new ArrayList<>();
        for (String line : lines) {
            String[] dataArr = line.split(Constant.DELIMITER);
            Customer customer = new Customer(
                    Integer.parseInt(dataArr[0]),
                    dataArr[1],
                    dataArr[3],
                    Integer.parseInt(dataArr[4]),
                    dataArr[5],
                    dataArr[2],
                    dataArr[6],
                    dataArr[7]
            );
            customers.add(customer);
        }
        return customers;
    }

    public void writeCustomersToFile(List<Customer> customers) {
        List<String> toWriteData = new ArrayList<>();
        for (Customer customer : customers) {
            toWriteData.add(customer.toCsv());
        }
        fileManager.writeFile(Constant.CUSTOMER_FILE, toWriteData);
    }
}

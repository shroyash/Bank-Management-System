package manager;

import constant.Constant;
import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerManager {

     FileManager fileManager = new FileManager();

    public List<Customer> readCustomersFromFile() {
        List<String> lines = fileManager.readFile(Constant.CUSTOMER_FILE);
        List<Customer> customers = new ArrayList<>();

        for (String line : lines) {
            String[] dataArr = line.split(Pattern.quote(Constant.DELIMITER));
            try {
                Customer customer = new Customer(
                        Integer.parseInt(dataArr[0]),  // customerId
                        dataArr[1],                    // customerName
                        dataArr[2],                    // customerPhoneNumber
                        Integer.parseInt(dataArr[3]),  // customerPassword
                        dataArr[4],                    // customerUserName
                        dataArr[5],                    // customerAddress
                        dataArr[6],                    // customerCard
                        dataArr[7]                     // bankName
                );

                customers.add(customer);
            } catch (Exception e) {
                System.out.println("Error parsing line: " + line);
                e.printStackTrace();
            }
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

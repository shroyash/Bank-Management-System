
package manager;
import constant.Constant;
import entity.Account;
import entity.Customer;


import java.util.ArrayList;
import java.util.List;

public class AccountManager {

    FileManager fileManager = new FileManager();
    CustomerManager customerManager = new CustomerManager();



    public List<Account> readAccountsFromFile() {
        List<String> lines = fileManager.readFile(Constant.ACCOUNT_FILE);
        List<Account> accounts = new ArrayList<>();

        List<Customer> customers = customerManager.readCustomersFromFile();


        for (String line : lines) {
            String[] dataArr = line.split(Constant.DELIMITER);

            int accountId = Integer.parseInt(dataArr[0]);
            String status = dataArr[1];
            double balance = Double.parseDouble(dataArr[2]);
            String description = dataArr[3];
            int customerId = Integer.parseInt(dataArr[4]);
            String openingDate = dataArr[5];
            String accountType = dataArr[6];

            Customer customer = findCustomerById(customers, customerId);

            Account account = new Account(accountId, status, (int) balance, description, customer, openingDate, accountType);
            accounts.add(account);
        }

        return accounts;
    }

    public void writeAccountsToFile(List<Account> accounts) {
        List<String> toWriteData = new ArrayList<>();
        for (Account account : accounts) {
            toWriteData.add(account.toCsv());
        }
        fileManager.writeFile(Constant.ACCOUNT_FILE, toWriteData);
    }

    private Customer findCustomerById(List<Customer> customers, int customerId) {

        for (Customer c : customers) {
            System.out.println(c.getCustomerId());
            System.out.println(customerId);
            if (c.getCustomerId() == customerId) {
                return c;
            }
        }
        return null;
    }
}

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
            String[] dataArr = line.split(Constant.DELIMETER);
            int customerId = Integer.parseInt(dataArr[4]);
            Customer customer = findCustomerById(customers, customerId);

            Account account = new Account(
                    Integer.parseInt(dataArr[0]),
                    dataArr[1],
                    Integer.parseInt(dataArr[2]),
                    dataArr[3],
                    customer
            );
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
            if (c.getCustomerId() == customerId) {
                return c;
            }
        }
        return null;
    }
}

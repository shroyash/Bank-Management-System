package entity;

public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 10000.0;
    public CurrentAccount(int accountId, String accountStatus, int accountBalance, String accountDescription, Customer customer) {
        super(accountId, accountStatus, accountBalance, accountDescription, customer);
    }

    public void withdraw(double amount) {
        if (getAccountBalance() + OVERDRAFT_LIMIT < amount) {
            System.out.println("Withdrawal exceeds overdraft limit!");
        } else {
            double balance = getAccountBalance() - amount;
            setAccountBalance(balance);
            System.out.println("Withdrawn: " + amount);
        }
    } //hello

}

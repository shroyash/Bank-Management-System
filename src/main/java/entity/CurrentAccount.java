package entity;

public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 10000.0;

    public CurrentAccount(int accountId, String accountStatus, int accountBalance, String accountDescription, Customer customer, String openingDate, String accountType) {
        super(accountId, accountStatus, accountBalance, accountDescription, customer, openingDate, accountType);
    }

    public CurrentAccount(){

    }

    public void withdraw(double amount) {
        if (getAccountBalance() + OVERDRAFT_LIMIT < amount) {
            System.out.println("Withdrawal exceeds overdraft limit!");
        } else {
            int balance = (int) (getAccountBalance() - amount);
            setAccountBalance(balance);
            System.out.println("Withdrawn: " + amount);
        }
    }

}

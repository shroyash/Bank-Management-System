package entity;

public class SavingAccount extends Account{
    private static final double INTEREST_RATE = 0.04; // 4% annual
    private static final double MIN_BALANCE = 500.0;

    public SavingAccount(int accountId, String accountStatus, int accountBalance, String accountDescription, Customer customer, String openingDate, String accountType) {
        super(accountId, accountStatus, accountBalance, accountDescription, customer, openingDate, accountType);
    }
    public SavingAccount(){

    }

    public void calculateAndAddInterest() {
        double interest = getAccountBalance() * INTEREST_RATE / 12;
        setAccountBalance((int) (getAccountBalance() + interest));
        System.out.println("Interest is added: " + interest);

    }

    public void withdraw(double amount) {
        if (getAccountBalance() - amount < MIN_BALANCE) {
            System.out.println("Cannot withdraw: Minimum balance requirement.");
        } else {
            setAccountBalance((int) (getAccountBalance() - amount));
            System.out.println("Withdrawn: " + amount);
        }
    }

}

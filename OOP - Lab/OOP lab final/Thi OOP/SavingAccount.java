public class SavingAccount extends Account {
    private Double interestRate;

    public SavingAccount(String accountID, String customerID, String accountType, double initBalance,
            double interestRate, String password) {
        super(accountID, customerID, accountType, initBalance, password);
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Insufficient balance");
            return false;
        } else {
            setBalance(getBalance() - amount);
            return true;
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nInterest Rate: " + interestRate;
    }
}

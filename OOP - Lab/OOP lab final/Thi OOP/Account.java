public abstract class Account {
    protected String accountID;
    protected String customerID;
    protected String accountType;
    protected double balance;
    private String password;

    public Account(String accountID, String customerID, String accountType, double balance, String password) {
        this.accountID = accountID;
        this.customerID = customerID;
        this.accountType = accountType;
        this.balance = balance;
        this.password = password;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract boolean withdraw(double amount);

    @Override
    public String toString() {
        return "Account ID: " + accountID + "\nCustomer ID: " + customerID + "\nAccount Type: " + accountType
                + "\nBalance: " + balance;
    }
}

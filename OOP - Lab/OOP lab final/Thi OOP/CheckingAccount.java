public class CheckingAccount extends Account {
    public double balance;
    public double overdraftAmount;
    private double overdraftLimit;

    public CheckingAccount(String accountID, String customerID, String accountType, double balance,
            double overdraftLimit, String password) {
        super(accountID, customerID, accountType, balance, password);
        this.overdraftLimit = overdraftLimit;
    }

    public double overdraftAmount() {
        return overdraftLimit;
    }

    public boolean withdraw(double amount) {
        if (this.balance < amount) {
            if (amount - this.balance > overdraftAmount) {
                System.out.println("Transaction fails");
                return false;
            } else {
                overdraftAmount = overdraftAmount - (amount - this.balance);
                System.out.println("Transaction succeeds");
                this.balance = 0;
                return true;
            }

        } else {
            this.balance = this.balance - amount;
            System.out.println("Transaction succeeds");
            return true;
        }
    }

    public int compareTo(CheckingAccount obj) {
        if (this.balance > obj.balance) {
            return 1;
        } else if (this.balance < obj.balance) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return super.toString() + "\nOverdraft Amount: " + overdraftAmount;
    }
}

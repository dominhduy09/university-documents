public class Test {

    public static void main(String[] args) {
        // Create Bank
        Bank bank = new Bank("My Bank", "123 Main St");

        // Create Accounts
        Account account1 = new SavingAccount("SA001", "CUS001", "Savings", 5000.0, 2.5, "pass1");
        Account account2 = new SavingAccount("SA002", "CUS002", "Savings", 7000.0, 3.0, "pass2");
        Account account3 = new SavingAccount("SA003", "CUS003", "Savings", 3000.0, 2.0, "pass3");
        Account account4 = new CheckingAccount("CA001", "CUS001", "Checking", 2000.0, 1000.0, "pass1");
        Account account5 = new CheckingAccount("CA002", "CUS002", "Checking", 3000.0, 1500.0, "pass2");

        // Add Accounts to Bank
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);
        bank.addAccount(account5);

        // Display Account Details
        System.out.println("Account Details:");
        for (Account account : bank.getListOfAccounts()) {
            System.out.println("Account ID: " + account.getAccountID());
            System.out.println("Customer ID: " + account.getCustomerID());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Balance: " + account.getBalance());
            if (account instanceof SavingAccount) {
                SavingAccount savingAccount = (SavingAccount) account;
                System.out.println("Interest Rate: " + savingAccount.getInterestRate());
            } else if (account instanceof CheckingAccount) {
                CheckingAccount checkingAccount = (CheckingAccount) account;
                System.out.println("Overdraft Limit: " + checkingAccount.overdraftAmount());
            }
            System.out.println();
        }
    }
}

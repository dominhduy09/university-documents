import java.util.List;
import java.util.ArrayList;

class Bank {
    private String name;
    private String address;
    private List<Account> listOfAccounts;

    // Constructor
    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
        this.listOfAccounts = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Account> getListOfAccounts() {
        return listOfAccounts;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setListOfAccounts(List<Account> listOfAccounts) {
        this.listOfAccounts = listOfAccounts;
    }

    // Methods
    public void addAccount(Account account) {
        listOfAccounts.add(account); // Add to Arraylist
        System.out.println(account + " was added successfully.");
    }

    public void removeAccount(String accountID) {
        boolean removed = listOfAccounts.removeIf(account -> account.getAccountID().equals(accountID));

        if (removed) {
            System.out.println("Account with ID " + accountID + " was removed successfully.");
        } else {
            System.out.println("Couldn't remove account with ID " + accountID);
        }
    }

    // Display
    public void displayAccountByAccountID(String accountID) {
        for (Account account : listOfAccounts) {
            if (account.getAccountID().equals(accountID)) {
                System.out.println(account);
                return;
            }
        }
        System.out.println("Account with ID " + accountID + " not found.");
    }

    // Login
    public boolean login(String accountID, String password) {
        for (Account account : listOfAccounts) {
            if (account.getAccountID().equals(accountID) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bank [name=" + name + ", address=" + address + "]";
    }
}

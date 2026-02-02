package OOProject2;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolderName;

    BankAccount(String accountNumber, double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (this.balance < amount) {
            throw new Exception("The amount you are trying to withdraw is more than your current balance.");
        }
        this.balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    @Override
    public String toString() {
        return "This account is owned by " + this.accountHolderName + " with account number "
                + this.accountNumber + " and has a balance of " + this.balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 5000, "BMW");
        account.deposit(500);
        try {
            account.withdraw(6000);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(account);
    }
}

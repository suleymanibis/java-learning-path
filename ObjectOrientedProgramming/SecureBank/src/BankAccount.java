public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        if (initialBalance < 0) {
            initialBalance = 0.0;
            System.out.println("Error: The initial balance cannot be negative! The balance is 0.0!");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Info: The money is deposited successfully! New balance: " + this.balance);
        } else {
            System.out.println("Error: The amount cannot be negative!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Info: The money is withdrawn successfully! New balance: " + this.balance);
        } else {
            System.out.println("Error: The amount should be positive and equal or less than your current balance!");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void displayAccountInfo() {
        System.out.printf("""
                ==== Account Info ====
                Account number: %s
                Account owner: %s
                Current balance: %.2f
                ======================
                """,
                this.accountNumber,
                this.ownerName,
                this.balance);
    }
}

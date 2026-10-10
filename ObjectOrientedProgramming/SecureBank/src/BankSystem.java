import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {

        double initialBalance = 0;
        int choice;
        double amount;

        Scanner inp = new Scanner(System.in);
        BankAccount bankAccount;

        System.out.print("Enter the owner name of the account: ");
        String ownerName = inp.nextLine();

        System.out.print("Enter the account number of the account: ");
        String accountNumber = inp.nextLine();

        while (true) {
            System.out.print("Enter the initial balance of the account: ");
            if (inp.hasNextDouble()) {
                initialBalance = inp.nextDouble();
                break;
            } else {
                System.out.println("Error: Enter a valid balance amount!");
                inp.nextLine();
            }
        }

        bankAccount = new BankAccount(accountNumber, ownerName, initialBalance);

        mainLoop:
        while (true) {
            System.out.println("""
                    ======== MENU ========
                    1- Deposit Money
                    2- Withdraw Money
                    3- Account Info
                    0- Exit""");

            System.out.print("Your choice: ");

            try {
                choice = inp.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Enter a valid choice.");
                inp.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit money: ");

                    try {
                        amount = inp.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Enter a valid amount.");
                        inp.nextLine();
                        continue;
                    }

                    bankAccount.deposit(amount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw money: ");

                    try {
                        amount = inp.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Enter a valid amount.");
                        inp.nextLine();
                        continue;
                    }

                    bankAccount.withdraw(amount);
                    break;
                case 3:
                    System.out.println();
                    bankAccount.displayAccountInfo();
                    System.out.println();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Info: Exiting...");
                    break mainLoop;
                default:
                    System.out.println("Error: Enter a valid choice!");
            }
        }
    }
}

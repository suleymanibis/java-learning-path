import java.util.Scanner;

public class BankSimulator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double balance = 1000;
        double cash = 100;

        int currentRights = 3;
        int PIN = 5647;

        boolean validUser = false;

        System.out.println("Welcome to BBC Bank!");

        while (currentRights > 0){
            System.out.print("Enter your PIN: ");
            int pin = input.nextInt();

            if (pin == PIN){
                System.out.println("Your PIN is valid.");
                validUser = true;
                break;
            }

            currentRights--;
            System.out.println("Invalid PIN. Try again.");
        }

        if(!validUser) {
            System.out.println("You used your all rights to enter your valid PIN!");
            System.exit(0);
        }

        while (validUser){
            System.out.println("""
        
                1- Display balance
                2- Withdraw money
                3- Deposit money
                4- Exit
        
        """);
            System.out.print("Please choose a process you want to do: ");
            int choice = input.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Your current balance: " + balance + "\nYour current cash: " + cash);
                    break;
                case 2:
                    System.out.print("How much money do you want to withdraw: ");
                    double amount = input.nextDouble();

                    if (balance >= amount && amount > 0){
                        balance -= amount;
                        cash += amount;

                        System.out.println("Your new balance: " + balance + "\nYour new cash: " + cash);
                    }
                    else {
                        System.out.println("You cannot withdraw " + amount + " money!");
                    }
                    break;
                case 3:
                    System.out.print("How much money do you want to deposit: ");
                    double amount2 = input.nextDouble();

                    if (cash >= amount2 && amount2 > 0){
                        balance += amount2;
                        cash -= amount2;

                        System.out.println("Your new balance: " + balance + "\nYour new cash: " + cash);
                    }
                    else{
                        System.out.println("You cannot deposit " + amount2 + " money!");
                    }
                    break;
                case 4:
                    validUser = false;
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid process number!");
                    continue;
            }
        }
        
        input.close();
    }
}

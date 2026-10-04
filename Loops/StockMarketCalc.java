// This class calculates the final balance of an investment over a given number of months, 
// applying a monthly compound interest rate and adding a fixed bonus amount every quarter.

import java.util.Scanner;

public class StockMarketCalc {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double balance ,rate, bonus;
        int months;

        System.out.print("Enter initial balance: ");
        balance = input.nextDouble();

        System.out.print("Enter monthly rate (e.g. 5 for 5%): ");
        rate = input.nextDouble();

        System.out.print("Enter number of months: ");
        months = input.nextInt();

        System.out.print("Enter quarterly bonus amount: ");
        bonus = input.nextDouble();

        for (int month = 1; month <= months; month++){
            balance += (balance * rate * 0.01);

            if (month % 3 == 0){
                balance += bonus;
            }
        }

        System.out.println("Final balance: " + balance);

        input.close();
    }
}

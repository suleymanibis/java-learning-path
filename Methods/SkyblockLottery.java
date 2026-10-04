// This class simulates a Skyblock lottery system by validating a 4-digit ticket, 
// comparing it to a lucky number, and calculating the final prize after a tax deduction.

import java.util.Scanner;

public class SkyblockLottery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your 4-digit ticket number: ");
        int ticketNumber = input.nextInt();

        if(!isValidTicket(ticketNumber))
            System.out.println("Invalid ticket format. System closing.");
        else {
            System.out.print("Enter base prize pool: ");
            int basePrize = input.nextInt();

            System.out.print("Enter lucky number: ");
            int luckyNumber = input.nextInt();

            boolean isWinner = ticketNumber == luckyNumber;
            double netPrize = calculateNetPrize(basePrize, 0.15);

            printResult(isWinner, netPrize);
        }

    }

    public static boolean isValidTicket(int ticketNumber) {
        return ticketNumber >= 1000 && ticketNumber <= 9999;
    }

    public static double calculateNetPrize(double basePrize, double taxRate){
        return basePrize - (basePrize * taxRate);
    }

    public static void printResult(boolean isWinner, double netPrize){
        System.out.println(isWinner ? "Congratulations! You won " + netPrize + " coins!" : "Better luck next time!");
    }
}

package MixedProjects;
import java.util.Scanner;

public class Merchant {
    public static void main(String[] args) {
        final double TAX_RATE = 15; // Keyword final means that this variable cannot be changed until the end of the program.
        final double DISCOUNT_RATE = 10;
        double swordCost;
        int quantity;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the sword cost: ");
        swordCost = input.nextDouble();
        System.out.print("Enter the quantity: ");
        quantity = input.nextInt();

        double totalCost = swordCost * quantity;

        if (quantity >= 5){
            totalCost -= totalCost * DISCOUNT_RATE * 0.01;
            System.out.println("INFO: We have offered %" + DISCOUNT_RATE + " discount for you, since you buy " + quantity + " pieces of swords.");
        }

        double tax = totalCost * TAX_RATE * 0.01;

        System.out.println("INFO: Total Cost: " + totalCost);
        System.out.println("INFO: Tax: " + tax);
        System.out.println("INFO: Total owed: " + (totalCost + tax));

        input.close(); // We close the scanner to prevent data leakage.
    }
}

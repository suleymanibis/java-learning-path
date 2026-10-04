// This class generates the Collatz Conjecture (3n+1) sequence for a given positive integer, 
// tracking the steps taken and the highest value reached during the process.

import java.util.Scanner;

public class CollatzConjecture {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;
        int steps = 0;
        int maxReached;

        System.out.print("Enter a positive integer: ");
        n = input.nextInt();

        if (n <= 0)
            System.out.println("Invalid number. Must be positive.");
        else {
            steps = 0;
            maxReached = n;

            System.out.print("Sequence: " + n + " ");

            while (n != 1 ) {

                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = 3 * n + 1;
                }
                System.out.print(n + " ");
                steps++;

                if (n > maxReached) {
                    maxReached = n;
                }
            }

            System.out.println("\nTotal steps: " + steps);
            System.out.println("Maximum value reached: " + maxReached);
        }

        input.close();
    }
}

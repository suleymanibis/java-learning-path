package Loops;
// This class implements a terminal hacking mini-game 
// where the player must guess a randomly generated 3-digit secret PIN 
// within 7 attempts using higher or lower hints.

import java.util.Scanner;
import java.util.Random;

public class TerminalHack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int secretPin = random.nextInt(100, 1000);
        int guess = 0;
        int attemptsLeft = 7;

        while (attemptsLeft > 0 && guess != secretPin) {
            System.out.print("Enter your guess (Attempts left: " + attemptsLeft + "): ");
            guess = input.nextInt();

            if (guess < secretPin)
                System.out.println("Access Denied. Hint: Try a HIGHER number.");
            else if (guess > secretPin)
                System.out.println("Access Denied. Hint: Try a LOWER number.");

            attemptsLeft--;
        }

        if (guess == secretPin)
            System.out.println("Access Granted! Password cracked.");
        else if (attemptsLeft <= 0)
            System.out.println("System Locked. The secret PIN was: " + secretPin);

        input.close();
    }
}

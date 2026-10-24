package Loops;

import java.util.Scanner;

public class BlackHoleLock6174 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number, big, small, steps, d, rest;
        String bigText, smallText, resultText;

        System.out.print("Enter a 4-digit-number: ");
        number = input.nextInt();

        if (number >= 1000 && number < 10000) {
            if (number % 1111 != 0) {
                steps = 0;
                while (number != 6174) {
                    big = 0;
                    bigText = "";
                    for (d = 9; d >= 0; d--) {
                        rest = number;
                        for (int i = 0; i < 4; i++) {
                            int lastDigit = rest % 10;
                            if (lastDigit == d) {
                                big = big * 10 + d;
                                bigText = bigText + d;
                            }
                            rest /= 10;
                        }
                    }

                    small = 0;
                    smallText = "";
                    for (d = 0; d <= 9; d++) {
                        rest = number;
                        for(int i = 0; i < 4; i++) {
                            int lastDigit = rest % 10;
                            if (lastDigit == d) {
                                small = small * 10 + d;
                                smallText = smallText + d;
                            }
                            rest /= 10;
                        }
                    }

                    number = big - small;
                    steps++;
                    resultText = "" + number;

                    while (resultText.length() < 4) {
                        resultText = "0" + resultText;
                    }

                    System.out.println("Step " + steps + ": " + bigText + " - " + smallText + " = " + resultText);
                }
                System.out.println("Steps to 6174: " + steps);
            } else {
                System.out.println("Invalid number: all digits are the same.");
            }
        } else {
            System.out.println("Invalid number.");
        }
    }
}

package Loops;

import java.util.Scanner;

public class BlackHoleLock {
    public static void main(String[] args) {
        int number, big, small, steps, d, rest;
        String bigText;
        String smallText;
        String resultText;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a 3-digit-number: ");
        number = input.nextInt();

        if (number >= 100 && number <= 999) {
            if (number % 111 != 0) {
                steps = 0;
                while (true) {
                    if (number == 495) {
                        break;
                    }

                    big = 0;
                    small = 0;
                    bigText = "";
                    smallText = "";

                    int bigDigitCount = 0, smallDigitCount = 0;

                    for (d = 9; d >= 0; d--) {
                        rest = number;

                        while (rest > 0) {
                            int lastDigit = rest % 10;

                            if (lastDigit == d) {
                                big = big * 10 + d;
                                bigText = bigText + d;
                                bigDigitCount++;
                            }

                            rest /= 10;
                        }
                    }

                    while (bigDigitCount < 3) {
                        big = big * 10;
                        bigText = bigText + "0";
                        bigDigitCount++;
                    }

                    for (d = 0; d <= 9; d++) {
                        rest = number;

                        while (rest > 0) {
                            int lastDigit = rest % 10;

                            if (lastDigit == d) {
                                small = small * 10 + d;
                                smallText = smallText + d;
                                smallDigitCount++;
                            }

                            rest /= 10;
                        }
                    }

                    while (smallDigitCount < 3) {
                        smallText = "0" + smallText;
                        smallDigitCount++;
                    }

                    number = big - small;
                    steps++;

                    if (number < 100 && number >= 10) {
                        resultText = "0" + number;
                    } else if (number < 10) {
                        resultText = "00" + number;
                    } else {
                        resultText = "" + number;
                    }

                    System.out.println("Step " + steps + ": " + bigText + " - " + smallText + " = " + resultText);

                }
                System.out.println("Steps to 495: " + steps);
            } else {
                System.out.println("Invalid number: all digits are the same.");
            }
        } else {
            System.out.println("Invalid number.");
        }
    }
}

package Selections;

import java.util.Scanner;

public class NextDay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a date (day month year): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        int maxDay = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> -1;
        };

        if (day <= 0 || day > 31 || year <= 0 || month == -1) {
            System.out.println("Invalid date.");
        } else {
            if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month == 2) {
                maxDay = 29;
            }

            if (day > maxDay) {
                System.out.println("Invalid date.");
            } else {
                if (day == maxDay) {
                    day = 1;
                    month++;
                } else {
                    day++;
                }

                if (month == 13) {
                    month = 1;
                    year++;
                }

                System.out.println("Next day: " + day + "/" + month + "/" + year);
            }
        }
    }
}

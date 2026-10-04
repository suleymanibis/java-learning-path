import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            System.out.printf("%d is a leap year!\n", year);
        else
            System.out.printf("%d is not a leap year!\n", year);

        System.out.print("Enter a day (1-7): ");
        int day = input.nextInt();

        if (day > 7 || day < 1) {
            System.out.println("Invalid number!");
            System.exit(0);
        }

        String currentDay = getDay(day);
        String nonLeapDay = getDay(day, "nonleap");
        String leapDay = getDay(day, "leap");

        System.out.printf("If a date is on %s this year, after a non leap year, that day will be on %s.\nAfter a leap year, that day will be on %s.", currentDay, nonLeapDay, leapDay);
        input.close();
    }

    public static String getDay(int day, String state) {
        state = state.toLowerCase();
        if (state.equals("leap")) {
            day += 2;
        } else if (state.equals("nonleap")) {
            day++;
        }

        if (day > 7) {
            day %= 7;
        }

        if (day % 7 == 0) {
            day = 7;
        }

        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "You have entered an invalid day!";
        };
    }

    // overloading
    public static String getDay(int day) {
        return getDay(day, "");
    }
}

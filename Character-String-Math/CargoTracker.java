// This class calculates the exact distance to a destination using X and Y coordinates 
// and generates a unique, formatted tracking code based on the pilot's initials, destination name, and distance.

import java.util.Scanner;

public class CargoTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double x, y;
        String fullname;
        String target;

        System.out.print("Enter pilot's full name: ");
        fullname = input.nextLine();

        int spaceIndex = fullname.indexOf(" ");
        String name = fullname.substring(0, spaceIndex);
        String surname = fullname.substring(spaceIndex + 1);

        System.out.print("Enter destination name: ");
        target = input.nextLine();

        System.out.print("Enter X and Y coordinates: ");
        x = input.nextDouble();
        y = input.nextDouble();

        double exactDistance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        String trackingCode = ("" + name.charAt(0) + surname.charAt(0) + "-" + target.substring(0, 3) + "-" + Math.round(exactDistance)).toUpperCase();

        System.out.printf("Tracking Code: %s\n", trackingCode);
        System.out.printf("Exact Distance: %.2f lightyears", exactDistance);
    }
}

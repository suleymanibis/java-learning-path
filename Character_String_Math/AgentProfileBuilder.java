package Character_String_Math;
// This class formats an agent's full name, generates a unique codename using string manipulation,
// and calculates their pentagonal operation area based on a given radius.

import java.util.Scanner;
public class AgentProfileBuilder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String fullName, profileName, codeName;
        double radius, area;
        double pi = Math.PI;

        System.out.print("Enter agent's full name (lowercase): ");
        fullName = input.nextLine();

        System.out.print("Enter bounding radius: ");
        radius = input.nextDouble();

        int spaceIndex = fullName.indexOf(" ");
        String name = fullName.substring(0, spaceIndex);
        String surname = fullName.substring(spaceIndex + 1);

        String ch1 = Character.toString(Character.toUpperCase(name.charAt(0)));
        String ch2 = Character.toString(Character.toUpperCase(surname.charAt(0)));

        name = ch1 + name.substring(1);
        surname = ch2 + surname.substring(1);

        profileName = name + " " + surname;

        codeName = surname.charAt(0) + name.charAt(name.length() - 1) + fullName.length() + "";

        double s = 2 * radius * Math.sin(pi/5);
        area = (5 * s * s)/(4 * Math.tan(pi/5));

        System.out.printf("Agent Profile: %s\n", profileName);
        System.out.printf("Codename: %s\n", codeName);
        System.out.printf("Operation Area: %.2f sq units", area);
        
        input.close();
    }
}

package GuildMaster;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuildApp {
    public static void main(String[] args) {
        String name, role;
        int choice, level;
        Guild shadowWarlords;
        Hero newHero;
        Scanner inp = new Scanner(System.in);

        shadowWarlords = new Guild("Shadow Warlords");

        mainLoop:
        while (true) {
            System.out.println("""
                    === SHADOW WARLORDS MENU ===
                    1- Add member
                    2- Kick member
                    3- Show guild
                    0- Exit
                    """);

            System.out.print("Your choice: ");

            while (true) {
                try {
                    choice = inp.nextInt();
                    if (choice < 0 || choice > 3) {
                        System.out.println("Error: Enter a valid choice!");
                        continue mainLoop;
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Enter a valid choice!");
                    inp.nextLine();
                    continue mainLoop;
                }
            }


            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if (choice == 1) {
                System.out.print("Member's name: ");
                name = inp.next();

                System.out.print("Member's role: ");
                role = inp.next();

                while (true) {
                    System.out.print("Member's level: ");
                    try {
                        level = inp.nextInt();
                        if (level < 0) {
                            System.out.println("Error: Enter a valid choice!");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Enter a valid choice!");
                        inp.nextLine();
                    }
                }

                newHero = new Hero(name, role, level);
                shadowWarlords.recruit(newHero);
            } else if (choice == 2) {
                System.out.print("Member's name: ");
                name = inp.next();
                shadowWarlords.kick(name);
            } else {
                shadowWarlords.showRoster();
            }
        }
    }
}

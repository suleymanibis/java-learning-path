import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon {
    public static void main(String[] args) {
        int choice, damage;
        GameObject chosenObject;
        GameObject[] gameObjects = new GameObject[2];
        Scanner inp = new Scanner(System.in);

        gameObjects[0] = new NPC("Blacksmith");
        gameObjects[1] = new Crate("Old chest");

        dungeon:
        while (true) {
            System.out.println("""
                    ======================
                    1- Blacksmith
                    2- Old chest
                    0- Exit
                    ======================
                    """);
            System.out.print("Your choice: ");

            while (true) {
                try {
                    choice = inp.nextInt();
                    if (choice < 0 || choice > (gameObjects.length + 1)) {
                        System.out.println("Error: Enter a valid choice!");
                        continue dungeon;
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Enter a valid choice!");
                    inp.nextLine();
                    continue dungeon;
                }
            }

            if (choice == 0) {
                break dungeon;
            }

            chosenObject = gameObjects[choice - 1];
            chosenObject.interact();

            while (true) {
                System.out.print("Enter a damage amount: ");
                try {
                    damage = inp.nextInt();
                    if (damage < 0) {
                        System.out.println("Error: Enter a valid damage amount!");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Enter a valid damage amount!");
                    inp.nextLine();
                }
            }

            if (chosenObject instanceof Destructible) {
                ((Destructible) chosenObject).takeDamage(damage); // type casting
            } else {
                System.out.println("Error: This is not a destructible object!");
                continue;
            }
        }
    }
}

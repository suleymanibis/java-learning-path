import java.util.Scanner;

public class Arena {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your character's name: ");
        String name = input.nextLine();

        Hero hero = new Hero();

        hero.name = name;
        hero.maxHp = 100;
        hero.hp = hero.maxHp;

        int choice;

        gameMainLoop:
        while (!hero.isDead) {
            System.out.println("""
                    --- ARENA MENU ---
                    1- Damage
                    2- Heal
                    3- Display status
                    0- Exit
                    """);

            System.out.print("Your choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                input.nextLine();
                System.out.println("\nError: Enter a valid choice!");
                continue;
            }

            switch (choice) {
                case 1:
                    int damage = 0;
                    System.out.print("Enter the damage amount: ");

                    if (input.hasNextInt()) {
                        damage = input.nextInt();
                        System.out.printf("\n%s was damaged %d\n", hero.name, damage);
                        hero.takeDamage(damage);

                    } else {
                        input.nextLine();
                        System.out.println("Error: Enter a valid amount!");

                    }
                    break;
                case 2:
                    int healAmount = 0;
                    System.out.print("Enter the heal amount: ");

                    if (input.hasNextInt()) {
                        healAmount = input.nextInt();
                        hero.heal(healAmount);
                        if (hero.hp == hero.maxHp){
                            System.out.printf("\n%s was healed %d (Reached max HP)\n", hero.name, healAmount);
                        } else
                            System.out.printf("\n%s was healed %d\n", hero.name, healAmount);
                    } else {
                        input.nextLine();
                        System.out.println("Error: Enter a valid amount!");
                    }
                    break;
                case 3:
                    hero.displayStats();
                    break;
                case 0:
                    break gameMainLoop;
                default:
                    System.out.println("\nError: Enter a valid choice!");
            }
        }
    }
}

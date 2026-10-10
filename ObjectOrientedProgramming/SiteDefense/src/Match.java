import java.util.InputMismatchException;
import java.util.Scanner;

public class Match {
    public static void main(String[] args){
        int choice, weaponChoice;
        Agent agent;
        Weapon[] weapons;
        Weapon vandal, phantom, warden;
        String agentName;

        Scanner inp = new Scanner(System.in);

        vandal = new Weapon("Vandal", 2900, 50);
        phantom = new Weapon("Phantom", 2800, 40);
        warden = new Weapon("Warden", 3000, 120);

        weapons = new Weapon[3];
        weapons[0] = vandal;
        weapons[1] = phantom;
        weapons[2] = warden;

        System.out.print("Enter your agent's name: ");
        agentName = inp.nextLine();

        agent = new Agent(agentName);

        mainLoop:
        while (true){
            System.out.println("""
                    
                    ======== MENU ========
                    1- Shop
                    2- Equipment Status
                    0- Exit
                    ======================
                    
                    """);
            System.out.print("Your choice (0-2): ");

            try {
                choice = inp.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Enter a valid choice!");
                inp.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    int i = 1;
                    System.out.println("==== WEAPONS SHOP ====");
                    for(Weapon weapon: weapons){
                        System.out.printf("%d- Weapon name: %s | Weapon price: %d | Weapon damage: %d\n",
                                i, weapon.getName(), weapon.getPrice(), weapon.getDamage());
                        i++;
                    }
                    System.out.println("======================");
                    System.out.print("\nWhich weapon do you buy (1-3): ");

                    try {
                        weaponChoice = inp.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Enter a valid weapon choice!");
                        inp.nextLine();
                        continue;
                    }

                    if(weaponChoice > weapons.length || weaponChoice < 1) {
                        System.out.println("Error: Enter a valid weapon choice!");
                        inp.nextLine();
                        continue;
                    } else {
                        agent.buyWeapon(weapons[weaponChoice - 1]);
                    }
                    break;
                case 2:
                    agent.displayLoadouts();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break mainLoop;
                default:
                    System.out.println("Error: Enter a valid choice!");
            }
        }
    }
}

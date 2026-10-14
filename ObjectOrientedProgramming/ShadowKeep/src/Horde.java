import java.util.InputMismatchException;
import java.util.Scanner;

public class Horde {
    public static void main(String[] args) {
        int countOfEnemies, enemyType;
        String enemyName;
        Monster[] monsters;
        Scanner inp = new Scanner(System.in);

        while (true) {
            System.out.print("How many enemies will be in the army: ");
            try {
                countOfEnemies = inp.nextInt();

                if (countOfEnemies <= 0) {
                    System.out.println("Error: Enter a valid army count!");
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Enter a valid army count!");
                inp.nextLine();
            }
        }

        monsters = new Monster[countOfEnemies];

        for (int i = 1; i <= countOfEnemies; i++) {

            while (true) {
                System.out.print(i + ". Choose a type of enemy (1- Default 2- Vampire): ");
                try {
                    enemyType = inp.nextInt();
                    if (enemyType < 1 || enemyType > 2) {
                        System.out.println("Error: Enter a valid enemy type!");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Enter a valid enemy type!");
                    inp.nextLine();
                }
            }

            System.out.print(i + ". enemy's name: ");
            enemyName = inp.next();

            System.out.println("The monster was created!");

            switch (enemyType) {
                case 1:
                    monsters[i - 1] = new Monster(enemyName, 50, 10);
                    break;
                case 2:
                    monsters[i - 1] = new Vampire(enemyName);
                    break;
            }
        }

        System.out.println("The fight is starting...");

        for(Monster monster: monsters){
            monster.attack();
        }
    }
}

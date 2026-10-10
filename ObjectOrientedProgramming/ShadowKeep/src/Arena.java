import java.util.InputMismatchException;
import java.util.Scanner;

public class Arena {
    public static void main(String[] args){
        String monsterName;
        int enemyType;

        Scanner inp = new Scanner(System.in);

        System.out.print("What is your enemy's name: ");
        monsterName = inp.nextLine();

        while (true) {
            System.out.print("What is your enemy's type (1- Default 2- Vampire): ");

            try {
                enemyType = inp.nextInt();
                if(enemyType < 1 || enemyType > 2){
                    System.out.println("Error: Enter a valid enemy type!");
                    continue;
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Enter a valid enemy type!");
                inp.nextLine();
            }


        }

        System.out.println("The monster was created!");
        System.out.println("The fight is starting...");

        switch (enemyType) {
            case 1:
                Monster monster = new Monster(monsterName, 50, 10);
                monster.attack();
                break;
            case 2:
                Vampire vampire = new Vampire(monsterName);
                vampire.attack();
                break;
            default:
                System.out.println("Error: Enter a valid enemy type!");
        }
    }
}

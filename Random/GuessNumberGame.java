import java.util.Scanner;
import java.util.Random;
public class GuessNumberGame {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();

        int target = rnd.nextInt(100);
        int guess;

        while(true){
            System.out.print("Enter a guess: ");
            guess = input.nextInt();

            if(guess > target){
                System.out.println("Your guess is greater than the target.");
            }
            else if(guess < target){
                System.out.println("Your guess is less than the target.");
            }
            else{
                System.out.println("Congratulations! You have found the target number: " + target);
                break;
            }

        }
    }
}

package Character_String_Math;

import java.util.Scanner;

public class RockPaperScissors {
    public void main(String[] args){
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter your name (only First and Last): ");
        String fullname = inp.nextLine(); // John Doe

        String firstName = fullname.substring(0, fullname.indexOf(" "));
        String lastName = fullname.substring(fullname.indexOf(" ") + 1);

        firstName = firstName.toUpperCase().charAt(0) + firstName.substring(1).toLowerCase();
        lastName = lastName.toUpperCase();

        System.out.println(firstName + " " + lastName + ", let's play Paper, Rock, Scissors...");

        System.out.print("Choose your weapon (R)ock, (P)aper, (S)cissor: ");
        char choice = inp.nextLine().toUpperCase().charAt(0); // I used .toUpperCase() to prevent the difference between 'r' and 'R'.

        char compChoice = "RPS".charAt((int) (Math.random() * 3));

        String userChoiceStr = switch (choice){
            case 'R' -> "rock";
            case 'P' -> "paper";
            case 'S' -> "scissors";
            default -> "error"; // I used short-switch espression to type the user choice to the terminal.
                                // Also, I added a control value to userChoiceStr because I have to check invalid inputs.
        };

        String a = "a";

        String compChoiceStr = switch (compChoice){
            case 'R' -> "rock";
            case 'P' -> "paper";
            case 'S' -> "scissors";
            default -> "";
        };

        boolean tie = choice == compChoice;
        boolean userWin =  choice == 'R' && compChoice == 'S'
                || choice == 'P' && compChoice == 'R'
                || choice == 'S' && compChoice == 'P';


        if(userChoiceStr.equals("error")){
            System.out.println("Invalid choice");
        } else {
            System.out.println("You chose " + userChoiceStr);
            System.out.println("I chose " + compChoiceStr);

            if (tie) {
                System.out.println("We tied!");
            } else if (userWin) {
                System.out.println("You win!");
            } else {
                System.out.println("I win!");
            }
        }
    }
}

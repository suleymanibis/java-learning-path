import java.util.Scanner;

public class ValorantEcon {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int currentCredits;
        int roundOutcome;
        int lossStreak = 0;
        int kills;
        int spikePlanted;
        int finalCredits = 0;

        System.out.print("Enter current credits: ");
        currentCredits = input.nextInt();

        System.out.print("Enter round outcome (1-Win, 2-Loss): ");
        roundOutcome = input.nextInt();

        if(roundOutcome == 2){
            System.out.print("Enter loss streak count:");
            lossStreak = input.nextInt();
        } else if(roundOutcome != 1 && roundOutcome != 2){
            roundOutcome = -1;
            System.out.println("Invalid round outcome.");
        }

        if(roundOutcome != -1) {
            System.out.print("Enter total kills: ");
            kills = input.nextInt();

            System.out.print("Was the spike planted? (1-Yes, 2-No): ");
            spikePlanted = input.nextInt();

            if(roundOutcome == 1){
                finalCredits += 3000;
            }else {
                if(lossStreak == 1){
                    finalCredits += 1900;
                } else if(lossStreak == 2) {
                    finalCredits += 2400;
                } else {
                    finalCredits += 2900;
                }
            }

            finalCredits += kills * 200;

            if(roundOutcome == 2 && spikePlanted == 1){
                finalCredits += 300;
            }

            finalCredits += currentCredits;

            if (finalCredits > 9000){
                finalCredits = 9000;
            }

            System.out.println("Final credits for next round: " + finalCredits);

            input.close();
        }
    }
}

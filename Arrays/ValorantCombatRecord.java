// This class calculates and displays a Valorant match summary, 
// including total kills, aces, and the best round based on user input.

package Arrays;

import java.util.Scanner;

public class ValorantCombatRecord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rounds played: ");
        int numRounds = input.nextInt();

        if (numRounds > 0) {
            int[] rounds = new int[numRounds];

            for (int i = 0; i < rounds.length; i++) {
                System.out.print("Enter kills for round " + (i + 1) + ": ");
                rounds[i] = input.nextInt();
            }

            int totalKills = calculateTotalKills(rounds);
            int aceCount = countAces(rounds);
            int bestRound = getBestRound(rounds);

            System.out.printf("""
                    --- MATCH SUMMARY ---
                    Total Kills: %d
                    Total Aces: %d
                    Best Round: Round %d""", totalKills, aceCount, bestRound);
        } else {
            System.out.println("Invalid match length.");
        }

        input.close();
    }

    public static int calculateTotalKills(int[] rounds) {
        int totalKill = 0;
        for (int killCount : rounds) {
            totalKill += killCount;
        }

        return totalKill;
    }

    public static int countAces(int[] rounds) {
        int totalAces = 0;

        for (int killCount : rounds) {
            if (killCount == 5) {
                totalAces++;
            }
        }

        return totalAces;
    }

    public static int getBestRound(int[] rounds) {
        int maxIndex = 0;
        for (int i = 0; i < rounds.length; i++) {
            if (rounds[i] > rounds[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex + 1;
    }
}

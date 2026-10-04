import java.util.Scanner;

public class AgeOfHistoryCalc {
    public static final double BASE_COST = 250;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter current stability (0-100): ");
        double currentStability = input.nextDouble();

        System.out.print("Enter number of annexed provinces: ");
        int provinces = input.nextInt();

        System.out.print("Enter Casus Belli (1-Reconquest, 2-Conquest, 3-No CB): ");
        int cbCode = input.nextInt();

        double cost = getAssimilationCost(provinces, BASE_COST);
        double ae = getAggressiveExpansion(provinces, cbCode);
        double rawStability = currentStability - ae;
        double finalStability = capStability(rawStability);

        printReport(cost, ae, finalStability);
        input.close();
    }

    public static double getAssimilationCost(int provinces, double baseCost) {
        if (provinces > 5) return provinces * baseCost * 1.15;
        else return provinces * baseCost;
    }

    public static double getAggressiveExpansion(int provinces, int cbCode) {
        return switch (cbCode) {
            case 1 -> 2.5 * provinces;
            case 2 -> 5.0 * provinces;
            case 3 -> 10.0 * provinces;
            default -> 0;
        };
    }

    public static double capStability(double rawStability) {
        if (rawStability > 100)
            return 100;
        else if (rawStability < 0)
            return 0;

        return rawStability;
    }

    public static void printReport(double cost, double ae, double finalStability) {
        System.out.printf("""
                --- CONQUEST REPORT ---
                Assimilation Cost: %.1f gold
                Aggressive Expansion: %.1f
                New National Stability: %.1f
                """, cost, ae, finalStability);
    }
}

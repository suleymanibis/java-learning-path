package Selections;

import java.util.Scanner;

public class DroneOptimization {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int cropType;
        int gridSize;
        int totalTiles = 0;
        int totalWater = 0;
        int totalFertilizer = 0;
        int totalSeconds = 0;

        System.out.print("Enter crop type (1-Pumpkin, 2-Sunflower, 3-Cactus): ");
        cropType = input.nextInt();

        System.out.print("Enter grid size (N for NxN): ");
        gridSize = input.nextInt();

        totalTiles = gridSize * gridSize;

        switch (cropType) {
            case 1:
                totalWater = 2 * totalTiles;
                totalFertilizer = 1 * totalTiles;
                totalSeconds = 3 * totalTiles;
                break;
            case 2:
                totalWater = totalTiles;
                totalFertilizer = 2 * totalTiles;
                totalSeconds = 4 * totalTiles;
                break;
            case 3:
                totalWater = 0 * totalTiles;
                totalFertilizer = 1 * totalTiles;
                totalSeconds = 2 * totalTiles;
                break;
            default:
                cropType = -1;
                System.out.println("Invalid crop type.");
                break;
        }

        if (cropType != -1) {
            if (gridSize > 5) {
                totalSeconds += 30;
            }
            int minutes = totalSeconds / 60;
            int remainingSeconds = totalSeconds % 60;

            System.out.println("Total water: " + totalWater);
            System.out.println("Total fertilizer: " + totalFertilizer);
            System.out.println("Harvest time: " + minutes + " min " + remainingSeconds + " sec");
        }
        input.close();
    }
}

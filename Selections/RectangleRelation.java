package Selections;

import java.util.Scanner;

public class RectangleRelation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first rectangle (x1 y1 x2 y2): ");
        int r1x1 = input.nextInt();
        int r1y1 = input.nextInt();
        int r1x2 = input.nextInt();
        int r1y2 = input.nextInt();


        System.out.print("Enter the second rectangle (x1 y1 x2 y2): ");
        int r2x1 = input.nextInt();
        int r2y1 = input.nextInt();
        int r2x2 = input.nextInt();
        int r2y2 = input.nextInt();

        if (r1x1 < r1x2 && r1y1 < r1y2 &&
                r2x1 < r2x2 && r2y1 < r2y2) {

            if (r1x1 == r2x1 && r1y1 == r2y1 &&
                    r1x2 == r2x2 && r1y2 == r2y2) {

                System.out.println("The rectangles are identical.");

            } else if (r1x1 >= r2x1 && r1y1 >= r2y1 &&
                    r1x2 <= r2x2 && r1y2 <= r2y2) {

                System.out.println("The first rectangle is inside the second.");

            } else if (r2x1 >= r1x1 && r2y1 >= r1y1 &&
                    r2x2 <= r1x2 && r2y2 <= r1y2) {

                System.out.println("The second rectangle is inside the first.");

            } else if (r1x2 < r2x1 || r2x2 < r1x1 ||
                    r1y2 < r2y1 || r2y2 < r1y1) {

                System.out.println("The rectangles are separate.");

            } else if (r1x2 == r2x1 || r2x2 == r1x1 ||
                    r1y2 == r2y1 || r2y2 == r1y1) {

                System.out.println("The rectangles touch.");

            } else {

                System.out.println("The rectangles overlap.");
            }

        } else {
            System.out.println("Invalid rectangle.");
        }
    }
}

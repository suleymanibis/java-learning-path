package Character_String_Math;

import java.util.Scanner;

public class AngelsOfTriangel {
    public static final double PI = Math.PI;
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter the coordinates of the first corner A (x y): ");
        int x1 = inp.nextInt();
        int y1 = inp.nextInt();

        System.out.print("Enter the coordinates of the second corner B (x y): ");
        int x2 = inp.nextInt();
        int y2 = inp.nextInt();

        System.out.print("Enter the coordinates of the third corner C (x y): ");
        int x3 = inp.nextInt();
        int y3 = inp.nextInt();

        double a = Math.sqrt(Math.pow((x2 - x3) , 2) + Math.pow(y2 - y3, 2));
        double b = Math.sqrt(Math.pow((x1 - x3) , 2) + Math.pow(y1 - y3, 2));
        double c = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2));


        double angleA = Math.acos((a*a - b*b - c*c) / (-2 * b * c)) / PI * 180;  // acos method returns radian so we should convert it to degrees
        double angleB = Math.acos((b*b - a*a - c*c) / (-2 * a * c)) / PI * 180;
        double angleC = Math.acos((c*c - a*a - b*b) / (-2 * a * b)) / PI * 180;

        System.out.printf("\nAngle A: %.2f\nAngle B: %.2f\nAngle C: %.2f", angleA, angleB, angleC);

    }
}

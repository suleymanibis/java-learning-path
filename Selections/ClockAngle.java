package Selections;

import java.util.Scanner;

public class ClockAngle {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the hour (0-23): ");
        int hour = input.nextInt();

        System.out.print("Enter the minute (0-59): ");
        int minute = input.nextInt();

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59){
            System.out.println("Invalid time.");
        } else {
            hour %= 12;

            double hourHandDegree;
            double minuteHandDegree;
            double angle = 1;

            hourHandDegree = hour * 30 + minute * 0.5;
            minuteHandDegree = minute * 6;

            if(minuteHandDegree > hourHandDegree){
                angle = minuteHandDegree - hourHandDegree;
            } else {
                angle = hourHandDegree - minuteHandDegree;
            }

            if (angle > 180){
                angle = 360 - angle;
            }

            System.out.println("Angle: " + angle + " degrees");
        }
    }
}

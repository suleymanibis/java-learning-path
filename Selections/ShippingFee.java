package Selections;

import java.util.Scanner;

public class ShippingFee {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int serviceType;
        int grams;
        int pricePerKg;
        int billedKg;
        int fee;

        System.out.print("Enter the service type (1-Standard, 2-Express, 3-Same-Day): ");
        serviceType = input.nextInt();

        System.out.print("Enter the package weight in grams: ");
        grams = input.nextInt();

        pricePerKg = switch (serviceType){
            case 1 -> 10;
            case 2 -> 16;
            case 3 -> 24;
            default -> -1;
        };

        if(pricePerKg != -1){

            if(grams % 1000 > 0){
                billedKg = (grams / 1000) + 1;
            } else {
                billedKg = (grams / 1000);
            }

            if(billedKg <= 2){
                fee = 2 * pricePerKg;
            } else if (billedKg <= 10) {
                fee = billedKg * pricePerKg;
            } else {
                fee = 10 * pricePerKg + (billedKg - 10) * pricePerKg / 2;
            }

            if((serviceType == 2 ||serviceType == 3) && billedKg > 20){
                fee += 40;
            }

            System.out.println("Billed weight: " + billedKg + " kg");
            System.out.println("Fee: " + fee + " TL");

        }else {
            System.out.println("Invalid service type.");
        }
    }
}

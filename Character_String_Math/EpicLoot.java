package Character_String_Math;

import java.util.Scanner;

public class EpicLoot {
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);

        System.out.print("Promosyon kodunu giriniz: ");
        String promotionCode = inp.nextLine().toUpperCase();

        String prefix = promotionCode.substring(0, 4);

        int prize = (int) (100 + Math.random() * 901);

        if(prefix.equals("EPIC")){
            if (promotionCode.length() > 4 && promotionCode.charAt(4) == '-') {
                System.out.println("Doğrulandı! Şanslı kod çarpanı aktif.");
                prize *= 2;
            }

            System.out.println("Kazanılan Ödül: " + prize + " Coin");
        } else {
            System.out.println("Geçersiz kod!");
        }
    }
}

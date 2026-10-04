import java.util.Scanner;
import java.util.TreeMap;


public class VendingMachine {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        TreeMap<Integer, Integer> banknotes = new TreeMap<Integer, Integer>(); // To see a sorted output, I used TreeMap
        while (true) {
            System.out.println("""
                    1- Kahve 15 TL
                    2- Çikolata 22 TL
                    3- Enerji İçeceği 45 TL
                    4- Çıkış
                    """);

            System.out.print("Lütfen bir seçim yapın: ");
            int choice = inp.nextInt();

            int price = switch (choice) {
                case 1 -> 15;
                case 2 -> 22;
                case 3 -> 45;
                case 4 -> -1;
                default -> -2;
            };

            if (price == -1) {
                System.out.println("Çıkış yapılıyor...");
                break;
            }

            if (price == -2) {
                System.out.println("Lütfen geçerli bir seçim yapınız!");
                continue;
            }

            System.out.print("Lütfen ne kadar para verceğini girin: ");

            int money = inp.nextInt();

            if (money < 0) {
                System.out.println("Lütfen geçerli bir miktar girin!");
                continue;
            }

            if (money < price) {
                System.out.println("Yetersiz bakiye, tekrar deneyin!");
                continue;
            }

            int changeAmount = money - price;

            System.out.println("Para üstü: " + changeAmount + " TL");

            if (changeAmount >= 200) {
                banknotes.put(200, changeAmount / 200);
                changeAmount %= 200;
            }

            if (changeAmount >= 100) {
                banknotes.put(100, changeAmount / 100);
                changeAmount %= 100;
            }

            if (changeAmount >= 50) {
                banknotes.put(50, changeAmount / 50);
                changeAmount %= 50;
            }

            if (changeAmount >= 20) {
                banknotes.put(20, changeAmount / 20);
                changeAmount %= 20;
            }

            if (changeAmount >= 10) {
                banknotes.put(10, changeAmount / 10);
                changeAmount %= 10;
            }

            if (changeAmount >= 5) {
                banknotes.put(5, changeAmount / 5);
                changeAmount %= 5;
            }

            if (changeAmount >= 1) {
                banknotes.put(1, changeAmount);
            }

            for (int moneyType : banknotes.keySet()) {
                System.out.printf("\n%d adet %d TL", banknotes.get(moneyType), moneyType);
            }
            System.out.println("\n");

            banknotes.clear();
        }
    }
}

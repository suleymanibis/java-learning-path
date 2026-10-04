package Methods;

import java.util.Scanner;

public class LuksAkselReservation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean[] seats = new boolean[30];
        mainLoop:
        while (true){
            System.out.println("""
                --- LÜKS AKSEL GİŞE ---
                1- Koltukları Göster
                2- Rezervasyon Yap
                3- İptal Et
                4- Çıkış""");
            System.out.print("Seçiminiz: ");
            int choice = input.nextInt();
            int seatNum = 0;
            switch (choice){
                case 1:
                    displaySeats(seats);
                    break;
                case 2:
                    System.out.print("Rezerve etmek istediğiniz koltuk numarasını girin: ");
                    seatNum = input.nextInt();
                    reserveSeat(seats,seatNum);
                    break;
                case 3:
                    System.out.print("Rezervasyonunu iptal etmek istediğiniz koltuk numarasını girin: ");
                    seatNum = input.nextInt();
                    cancelSeat(seats,seatNum);
                    break;
                case 4:
                    System.out.println("İyi yolculuklar!");
                    break mainLoop;
                default:
                    System.out.println("Böyle bir seçenek mevcut değil!");
            }
        }

    }

    public static void displaySeats(boolean[] seats){
        int i = 1;
        for (boolean isTaken: seats){
            if(isTaken){
                System.out.print("[X] ");
            } else {
                System.out.print(i + " ");
            }

            if (i %3 == 0){
                System.out.println();
            }

            i++;
        }
    }

    public static void reserveSeat(boolean[] seats, int seatNum){
        if (seatNum <= 30 && seatNum >= 1){
            if(!(seats[seatNum - 1])){
                seats[seatNum - 1] = true;
                System.out.println("Koltuk " + seatNum + " başarıyla rezerve edildi!");
            } else {
                System.out.println("Koltuk " + seatNum + " zaten dolu!");
            }
        } else {
            System.out.println("Geçerli bir koltuk numarası giriniz!");
        }
    }

    public static void cancelSeat(boolean[] seats, int seatNum){
        if (seatNum <= 30 && seatNum >= 1){
            if(seats[seatNum - 1]){
                seats[seatNum - 1] = false;
                System.out.println("Koltuk " + seatNum + "'(n)in rezervasyonu başarıyla iptal edildi!");
            } else {
                System.out.println("Koltuk " + seatNum + " zaten boş!");
            }
        } else {
            System.out.println("Geçerli bir koltuk numarası giriniz!");
        }
    }
}

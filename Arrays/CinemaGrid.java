package Arrays;

import java.util.Scanner;

public class CinemaGrid {
    final public static int ROW_COUNT = 5;
    final public static int COLUMN_COUNT = 5;

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        char[][] seats = new char[ROW_COUNT][COLUMN_COUNT];

        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++)
                seats[i][j] = 'O';
        }

        int row = 0;
        int column = 0;

        while (true) {
            displaySeats(seats);

            System.out.println();
            System.out.print("Satır giriniz (1-5) [Çıkış için 0]: ");

            if (inp.hasNextInt()) {
                row = inp.nextInt() - 1;
            } else {
                System.out.println("Hata: Geçersiz giriş!");
                inp.nextLine();
                continue;
            }

            if (row == -1) {
                System.out.println("Sistemden çıkılıyor...");
                break;
            }

            System.out.print("Sütun giriniz (1-5) [Çıkış için 0]: ");
            if (inp.hasNextInt()) {
                column = inp.nextInt() - 1;
            } else {
                System.out.println("Hata: Geçersiz giriş!");
                inp.nextLine();
                continue;
            }

            boolean isError = row > 4 || row < 0 || column > 4 || column < 0;

            if (isError) {
                System.out.println("Hata: Geçersiz koordinat. Satır ve sütun 1-5 arasında olmalıdır.");
            } else {
                reserveSeat(seats, row, column);
            }
        }
    }

    public static void displaySeats(char[][] seats) {
        System.out.println("\nGüncel Salon: ");
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++)
                System.out.print(seats[i][j] + " ");
            System.out.println();
        }
    }

    public static void reserveSeat(char[][] seats, int row, int column) {
        if (seats[row][column] == 'O') {
            seats[row][column] = 'X';
            System.out.println("Koltuk başarıyla rezerve edildi!");
        } else {
            System.out.println("Hata: Bu koltuk zaten dolu!");
        }
    }
}

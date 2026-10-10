package Games;

import java.util.Scanner;

public class NavalStrike {
    final public static int ROW_COUNT = 5;
    final public static int COLUMN_COUNT = 5;

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        char[][] board = new char[ROW_COUNT][COLUMN_COUNT];
        boolean[][] ships = new boolean[ROW_COUNT][COLUMN_COUNT];

        fillArray(board, '~');
        //fillArray(ships, false); unnecessary

        ships[1][4] = true;
        ships[3][0] = true;
        ships[4][2] = true;

        int row = 0;
        int column = 0;
        int hitted = 0;
        boolean isHitted = false;
        while (hitted < 3) {
            displayBoard(board);

            System.out.println();
            System.out.print("Enter the row (1-5) [For exit, enter 0]: ");

            if (inp.hasNextInt()) {
                row = inp.nextInt();
            } else {
                System.out.println("Error: Invalid input! Please enter only number!");
                inp.nextLine();
                continue;
            }

            if (row == 0) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter the column (1-5): ");

            if (inp.hasNextInt()) {
                column = inp.nextInt();
            } else {
                System.out.println("Error: Invalid input! Please enter only number.");
                inp.nextLine();
                continue;
            }

            row--;
            column--;

            boolean isBoundError = row < 0 || row > 4 || column < 0 || column > 4;

            if(!isBoundError){
                isHitted = hitTarget(board, ships, row, column);
                if (isHitted)
                    hitted++;
                continue;
            } else {
                System.out.println("Error: Coordinates should be between 1 and 5!");
                continue;
            }
        }

        if (hitted == 3){
            System.out.println("You won the game by hitting all targets!");
        }
    }

    public static void fillArray(char[][] charArray, char c) {
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                charArray[i][j] = c;
            }
        }
    }

    public static void fillArray(boolean[][] boolArray, boolean b) {
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                boolArray[i][j] = b;
            }
        }
    }

    public static void displayBoard(char[][] board) {
        System.out.println("\nCurrent Board: ");

        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean hitTarget(char[][] board, boolean[][] ships, int row, int column) {
        if (board[row][column] == 'X') {
            System.out.println("You've already tried to hit these coordinates " + (row + 1) + "-" + (column + 1) + "!");
        } else if (board[row][column] == '*') {
            System.out.println("You've already hitted these coordinates " + (row + 1) + "-" + (column + 1) + "!");
        } else {
            if (ships[row][column]) {
                board[row][column] = '*';
                System.out.println("The target is hitted!");
                return true;
            } else {
                board[row][column] = 'X';
                System.out.println("You missed the target!");
            }
        }
        return false;
    }
}

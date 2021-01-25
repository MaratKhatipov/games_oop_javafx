package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = true;
        for (int row = 0; row < board.length; row++) {
           if (board[row][row] == 1) {
           result = (Win.monoHorizontal(board, row) || Win.monoVertical(board, row));
           if (result) {
               break;
           }
           }
        }
        return result;
    }

    public static boolean monoHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(int[][] board, int coll) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][coll] != 1) {
                result = false;
                break;
            }
        }

        return result;
    }
}



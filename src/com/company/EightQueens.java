package com.company;

public class EightQueens {
    static int size = 8;
    static int[][] board = new int[size][size];

    public static boolean checkEnd() {
        for (int i = 0; i < size; i++) {
            if (board[i][size-1] > 0) return true;
        }
        return false;
    }

    public static boolean checkDiagA(int n, int m) {
        n++;
        m++;
        while (n > 0 && n < size && m > 0 && m < size) {
           if (board[m,n] > 0) return false;
           n++;
           m++;
        }
        return true;
    }

    public static boolean checkDiagB(int n, int m) {
        n--;
        m--;
        while (n > 0 && n < size && m > 0 && m < size) {
            if (board[m,n] > 0) return false;
            n--;
            m--;
        }
        return true;
    }

    public static boolean checkAntiDiagA(int m, int n) {
        n--;
        m++;
        while (n > 0 && n < size && m > 0 && m < size) {
            if (board[m,n] > 0) return false;
            n--;
            m++;
        }
        return true;
    }

    public static boolean checkAntiDiagB(int m, int n) {
        n++;
        m--;
        while (n > 0 && n < size && m > 0 && m < size) {
            if (board[m,n] > 0) return false;
            n++;
            m--;
        }
        return true;
    }
}

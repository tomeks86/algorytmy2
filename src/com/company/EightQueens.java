package com.company;

public class EightQueens {
    static int size = 8;
    static int[][] board = new int[size][size];

    public static boolean backtrack(int n) {
        if (n == size) return true;
        for (int i = 0; i < size; i++) {
            if (checkDiag(i,n) && checkAntiDiag(i,n) && checkHorizontal(i,n)) {
                fill(i,n);
                n++;
                if (backtrack(n)) return true;
                else {
                    //System.out.println();
                    //print();
                    n--;
                    undo(n);
                }
            }
        }
        return false;
    }

    public static void undo(int n) {
        for (int i = 0; i < size; i++) {
            board[i][n] = 0;
        }
    }

    public static void root(int m) {
        board[m][0] = 1;
    }

    public static boolean checkEnd() {
        for (int i = 0; i < size; i++) {
            if (board[i][size] > 0) return true;
        }
        return false;
    }

    public static boolean checkDiag(int m, int n) {
        m--;
        n--;
        while (m > -1 && n > -1) {
            if (board[m][n] > 0) return false;
            m--;
            n--;
        }
        return true;
    }

    public static boolean checkAntiDiag(int m, int n) {
        m++;
        n--;
        while (m < size && n > -1) {
            if (board[m][n] > 0) return false;
            m++;
            n--;
        }
        return true;
    }

    public static boolean checkHorizontal(int m, int n) {
        n--;
        while (n > -1) {
            if (board[m][n] > 0) return false;
            n--;
        }
        return true;
    }

    public static void boardReinit(int k) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < k; j++) {
                board[i][j] = 0;
            }
        }
    }

    public static void fill(int m, int n) {
        board[m][n] = 1;
    }

    public static void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int queensAct = size;

        for (int j = 0; j < size; j++) {
            root(j);
            if (backtrack(1)) break;
            print();
            System.out.println();
            board = new int[size][size];
        }

        print();
    }
}

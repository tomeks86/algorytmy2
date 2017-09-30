package com.company.algorytmy1a;

public class Stairs {
    public static void drawStairs(int n) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = n - i; j < n; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        drawStairs(100);
    }
}

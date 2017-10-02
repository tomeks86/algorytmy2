package com.company.algorytmy1a;

import java.util.Arrays;
import java.util.Scanner;

public class Permutations {
    private static int[] numberOfDigits = new int[10];

    private static int[] intToTable(int number) {
        String numStr = String.valueOf(number);
        int[] result = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            result[i] = Integer.parseInt(numStr.substring(i, i+1));
        }
        return result;
    }

    private static String intTabToStr(int[] table) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < table.length; i++) {
            sb.append(table[i]);
        }
        return sb.toString();
    }

    private static void swap(int[] table, int i, int j) {
        int tmp = table[i];
        table[i] = table[j];
        table[j] = tmp;
    }

    private static int[] nextPermutation(int[] table) {
        int k = -1;
        for (int i = 0; i < table.length - 1; i++) {
            if (table[i] < table[i + 1]) {
                k = i;
            }
        }
        if (k == -1) {   // already last permutation
            return null;
        } else {
            int min = table[k + 1];
            int j = k + 1;
            for (int i = k + 2; i < table.length; i++) {
                if (table[i] > table[k] & table[i] < min) {
                    j = i;
                    min = table[i];
                }
            }
            swap(table, k, j);
            Arrays.sort(table,k + 1, table.length);
            return table;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give me a number!");
        int number = sc.nextInt();
        //int number = 1223;
        int[] num = intToTable(number);
        int N = String.valueOf(number).length();
        long total = FactorialLite.factorial(N).longValue();
        int[] numberOfDigits = new int[10];
        for (int i = 0; i < num.length; i++) {
            numberOfDigits[num[i]]++;
        }
        for (int i = 0; i < 10; i++) {
            total /= FactorialLite.factorial(numberOfDigits[i]).longValue();
        }
        System.out.println("All possible permutations of the number provided: " + total + ":");
        Arrays.sort(num);
        for (long i = 0; i < total; i++) {
            System.out.println(intTabToStr(num));
            num = nextPermutation(num);
        }
    }
}

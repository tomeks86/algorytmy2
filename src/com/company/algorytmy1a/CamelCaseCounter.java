package com.company.algorytmy1a;

import java.util.Scanner;

public class CamelCaseCounter {
    public static int count(String inp) {
        int count = 1;
        for (int i = 1; i < inp.length(); i++) {
            if (Character.isUpperCase(inp.charAt(i))) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string chain; exit to terminate");
        String line = sc.nextLine();
        line = line.split("\\s+")[0];
        while (line.compareTo("exit") != 0) {
            if (Character.isLowerCase(line.charAt(0))) {
                System.out.println("First word: " + line + " contained " + count(line) + " cammel case(s)");
            } else System.out.println("not a camel case word provided!");
            System.out.println("Enter a string chain; exit to terminate");
            line = sc.nextLine().split("\\s+")[0];
        }
    }
}

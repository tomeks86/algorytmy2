package com.company.domowe2;

import java.util.Scanner;

public class DivBy11 {
    public static boolean check11(int num) {
        if (num < 0) num *= -1;
        String numS = new String(String.valueOf(num));
        int n = numS.length();
        if (n == 1) {
            if (num == 0) return true;
        }
        if (n == 2) {
            if (numS.substring(0,1).equals(numS .substring(1,2))) return true;
        }
        if (n > 2) {
            int nm1 = 0, nm2 = 0; //nm1 -> 10^odd; nm2 -> 10^even
            if (n % 2 > 0) {
                for (int i = 0; i < n / 2; i++) {
                    nm1 += Integer.valueOf(numS.substring(2*i, 2*i+1));
                    nm2 += Integer.valueOf(numS.substring(2*i+1, 2*i+2));
                }
                nm1 += Integer.valueOf(numS.substring(n-1));
            } else {
                for (int i = 0; i < n / 2; i++) {
                    nm1 += Integer.valueOf(numS.substring(2 * i + 1, 2 * i + 2));
                    nm2 += Integer.valueOf(numS.substring(2 * i, 2 * i + 1));
                }
            }
            return check11(10 * nm1 + nm2);
        }

        return false;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner inpKeyboard = new Scanner(System.in);
        System.out.print("Provide next int to check: ");
        String num = inpKeyboard.nextLine();
        //int num = inpKeyboard.nextInt();
        if (isInteger(num)) {
            int number = Integer.parseInt(num);
            while (isInteger(num)) {
                if (check11(number)) {
                    System.out.println("Number divisible by 11");
                } else {
                    System.out.println("Number NOT divisible by 11");
                }
                System.out.print("Provide next int to check: ");
                number = inpKeyboard.nextInt();
            }
        }
    }
}

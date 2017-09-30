package com.company.algorytmy1a;

import java.math.BigInteger;

public class FactorialLite {
    public static String factorialLite(int n) {
        int fact = 1;
        if (n < 0) {
            System.out.println("only positive numbers allowed!");
            fact = -1;
        } else {
            for (int i = 1; i < n; i++) {
                fact = (fact * i) % 100;
            }
        }
        if (fact < 0) {
            return "-1";
        } else {
            if (fact < 10) {
                return "0" + String.valueOf(fact);
            } else {
                return String.valueOf(fact);
            }
        }
    }

    public static BigInteger factorial(int n) {
        BigInteger fact = new BigInteger(String.valueOf(BigInteger.ONE));
        BigInteger I = new BigInteger(String.valueOf(BigInteger.ONE));
        if (n < 0) {
            System.out.println("only positive numbers allowed!");
            fact = BigInteger.valueOf(-1);
        } else {
            for (int i = 1; i < n; i++) {
                I = BigInteger.valueOf(i);
                fact = fact.multiply(I);
            }
        }
        return fact;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10001; i++) {
            System.out.println(i + " " + factorialLite(i)); // + " " + factorial(i));
        }
    }
}

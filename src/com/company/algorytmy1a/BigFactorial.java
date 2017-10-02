package com.company.algorytmy1a;

import java.math.BigInteger;
import java.util.Arrays;

public class BigFactorial {


    public static String bigFactorial(int n) {
        String result = "";


        return result;
    }

    public static void main(String[] args) {
        BiggerInteger bigInt = new BiggerInteger("479001600");
        BiggerInteger bigInt2 = new BiggerInteger("23120002343201");
        BiggerInteger bigInt3 = new BiggerInteger("21093721472197424242");
        System.out.println(Arrays.toString(bigInt3.getNumber().toArray()));
        System.out.println(bigInt.toString());
        System.out.println(bigInt2.toString());
        System.out.println(bigInt3.toString());

        BiggerInteger bigSum = BiggerInteger.addBigInt(bigInt, bigInt2);
        System.out.println(Arrays.toString(bigSum.getNumber().toArray()));
        System.out.println(bigSum.toString());
        System.out.println(Long.valueOf(bigInt.toString()) + Long.valueOf(bigInt2.toString()));

        System.out.println(Long.valueOf(bigInt.toString()) * 99);
        System.out.println(BiggerInteger.multBigInt(bigInt, 99).toString());
        System.out.println();
        System.out.println(BiggerInteger.multBigInt(bigInt, 13).toString());
        //System.exit(0);
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + BiggerInteger.factorial(i));
        }
        //System.out.println(BiggerInteger.factorial(10));

    }
}

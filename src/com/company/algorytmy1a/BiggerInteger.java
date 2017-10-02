package com.company.algorytmy1a;

import java.util.ArrayList;

public class BiggerInteger {

    private ArrayList<String> number;
    private static final int base = 1000000;

    public BiggerInteger() {
        number = new ArrayList<>();
    }

    public BiggerInteger(String strValue) {
        number = new ArrayList<>();
        int len = strValue.length();
        int res = len % 6;
        for (int i = len / 6 - 1; i > -1; i--) {
            number.add(strValue.substring(res + i * 6, res + (i + 1) * 6));
        }
        if (res > 0) {
            number.add(strValue.substring(0, res));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = number.size() - 1; i > -1; i--) {
            sb.append(number.get(i));
        }
        return sb.toString();
    }

    public static BiggerInteger addBigInt(BiggerInteger b1, BiggerInteger b2) {
        ArrayList<String> result = new ArrayList<>();
        int b1s = b1.getNumber().size();
        int b2s = b2.getNumber().size();
        int res = 0;
        int part_res;
        if (b1s > b2s) {
            for (int i = 0; i < b2s; i++) {
                part_res = Integer.parseInt(b1.getNumber().get(i)) + Integer.parseInt(b2.getNumber().get(i)) + res;
                res = part_res / base;
                part_res %= base;
                result.add(("000000" + String.valueOf(part_res)).substring(String.valueOf(part_res).length()));
            }
            for (int i = b2s; i < b1s; i++) {
                part_res = Integer.parseInt(b1.getNumber().get(i)) + res;
                res = part_res / base;
                part_res %= base;
                result.add(("000000" + String.valueOf(part_res)).substring(String.valueOf(part_res).length()));
            }
        } else if (b2s > b1s) {
            for (int i = 0; i < b1s; i++) {
                part_res = Integer.parseInt(b1.getNumber().get(i)) + Integer.parseInt(b2.getNumber().get(i)) + res;
                res = part_res / base;
                part_res %= base;
                result.add(("000000" + String.valueOf(part_res)).substring(String.valueOf(part_res).length()));
            }
            for (int i = b1s; i < b2s; i++) {
                part_res = Integer.parseInt(b2.getNumber().get(i)) + res;
                res = part_res / base;
                part_res %= base;
                result.add(("000000" + String.valueOf(part_res)).substring(String.valueOf(part_res).length()));
            }
        } else { //b1s == b2s
            for (int i = 0; i < b1s; i++) {
                part_res = Integer.parseInt(b1.getNumber().get(i)) + Integer.parseInt(b2.getNumber().get(i)) + res;
                res = part_res / base;
                part_res %= base;
                result.add(("000000" + String.valueOf(part_res)).substring(String.valueOf(part_res).length()));
            }
        }
        if (res > 0) result.add(String.valueOf(res));
        else result.set(result.size() - 1, dropZeros(result.get(result.size() - 1)));

        BiggerInteger resBI = new BiggerInteger();
        resBI.setNumber(result);
        return resBI;
    }

    public static BiggerInteger multBigInt(BiggerInteger b, int v) {    //v <= 100; important!
        if (v > 100) throw new IllegalStateException();
        ArrayList<String> result = new ArrayList<>();
        int res = 0;
        int part_res;
        for (int i = 0; i < b.getNumber().size(); i++) {
            part_res = Integer.parseInt(b.getNumber().get(i)) * v + res;
            res = part_res / base;
            part_res %= base;
            result.add(("000000" + String.valueOf(part_res)).substring(String.valueOf(part_res).length()));
        }
        if (res > 0) result.add(String.valueOf(res));
        else result.set(result.size() - 1, dropZeros(result.get(result.size() - 1)));

        BiggerInteger resBI = new BiggerInteger();
        resBI.setNumber(result);
        return resBI;
    }

    private static String dropZeros(String inp) {
        int i = 0;
        while (i < inp.length()) {
            if (inp.substring(i, i + 1).compareTo("0") == 0) i++;
            else break;
        }
        return inp.substring(i);
    }

    public static BiggerInteger factorial(int n) {
        if (n > 100) throw new IllegalStateException();
        BiggerInteger b = new BiggerInteger("1");
        if (n == 1) return b;
        else {
            for (int i = 2; i < n + 1; i++) {
                b = multBigInt(b, i);
            }
        }
        return b;
    }

    public ArrayList<String> getNumber() {
        return number;
    }

    public void setNumber(ArrayList<String> number) {
        this.number = number;
    }
}

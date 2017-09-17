package com.company;

public class Recurence {

    public static int fibN(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibN(n - 1) + fibN(n - 2);
    }

    public static int pow(int base, int exp) {
        if (exp == 1) {
            return base;
        } else {
            int t = pow(base, exp / 2);
            if ((exp % 2) > 0) {
                return t * t * base;
            } else {
                return t * t;
            }
        }
    }

    public static int binarySearch(int[] T, int L, int P, int x) {
        if (P - L == 0) {
            return L;
        }
        int c = (P + L) / 2;
        if (T[c] >= x) {
            return binarySearch(T, L, c, x);
        } else {
            return binarySearch(T, c+1, P, x);
        }
    }

    public static void hanoi(int n, char a, char b, char c) {    //moving only from a -> c!
        if (n == 1) {
            System.out.println(a + " -> " + c);
        } else if (n == 2) {
            System.out.println(a + " -> " + b);
            System.out.println(a + " -> " + c);
            System.out.println(b + " -> " + c);
        } else {
            hanoi(n-1,a, c, b);
            hanoi(1,a,b,c);
            hanoi(n-1,b,a,c);
        }
    }

    public static void main(String[] args) {

        /*for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + fibN(i));
        }*/

        hanoi(5,'1','2','3');
        System.out.println();
        System.out.println(pow(3,4));

        int[] myList = {-5, -3, -2, 0, 3, 5, 7, 8, 10};

        int x = binarySearch(myList, 0, myList.length - 1, 3);
        System.out.println(x);

    }
}

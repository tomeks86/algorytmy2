package com.company;

public class StashLite {
    static int maxSize = 500;
    static int[] T = new int[maxSize];
    static int actSize = 0;

    public static boolean addElement(int value) {
        if (actSize < maxSize) {
            //T[actSize] = value;
            int son = actSize;
            int parent = (actSize - 1) / 2;
            actSize++;
            while (son > 0) {
                if (T[parent] < value) {
                    T[son] = T[parent];
                    son = parent;
                    parent = (parent - 1) / 2;
                }
                else break;
            }
            T[son] = value;
            return true;
        } else {
            System.out.println("Max size already attained");
            return false;
        }
    }

    public static void swap(int i, int j) {
        int tmp = T[i];
        T[i] = T[j];
        T[j] = tmp;
    }

    public static boolean puch() {
        if (actSize > 0) {
            //System.out.println(T[0]);
            actSize--;
            T[0] = T[actSize];
            int parent = 0, son;
            int son1 = 2 * parent + 1;
            int son2 = 2 * parent + 2;
            while (son1 < actSize | son2 < actSize) {
                if (son1 < actSize & son2 < actSize) {
                    son = (T[son1] > T[son2] ? son1 : son2);
                } else son = son1;
                if (T[parent] < T[son]) {
                    swap(parent, son);
                    parent = son;
                    son1 = 2 * parent + 1;
                    son2 = 2 * parent + 2;
                } else break;
            }
            return true;
        } else return false;
    }

    public static void printStash() {
        int i = 0, I = 0;
        int elLev;
        while (i < actSize) {
            elLev = Math.pow(2,I);
            for (int j = 0; j < elLev; j++) {
                System.out.print(T[i] + " ");
                i++;
                if (i >= actSize) break;
            }
            I++;
            System.out.println();
        }
    }

    public static void sortT() {
        int top = T[0];
        while(puch()) {
            T[actSize] = top;
            sortT();
        }
    }

    public static void main(String[] args) {
        addElement(1);
        addElement(13);
        addElement(5);
        addElement(57);
        addElement(7);
        addElement(37);
        addElement(-3);
        addElement(1);
        addElement(1);
        addElement(-5);
        printStash();
        System.out.println();
        puch();
        System.out.println();
        printStash();
        int size = actSize;
        System.out.println();
        sortT();
        for (int i = 0; i < size; i++) {
            System.out.print(T[i] + " ");
        }
        System.out.println();
    }
}

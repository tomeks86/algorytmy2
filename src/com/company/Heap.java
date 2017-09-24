package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap {

    public static void addElement(ArrayList<Integer> stash, int value) {
        int son = stash.size();
        stash.add(value);
        int parent = (son - 1) / 2;
        while (son > 0) {
            if (stash.get(parent) < value) {
                stash.set(son, stash.get(parent));
                son = parent;
                parent = (parent - 1) / 2;
            } else break;
        }
        stash.set(son, value);
    }

    public static void printStash(ArrayList<Integer> stash) {
        int i = 0, I = 0;
        int actSize = stash.size();
        int elLev;
        while (i < actSize) {
            elLev = Math.pow(2,I);
            for (int j = 0; j < elLev; j++) {
                System.out.print(stash.get(i) + " ");
                i++;
                if (i >= actSize) break;
            }
            I++;
            System.out.println();
        }
    }

    public static void swap(ArrayList<Integer> stash, int i, int j) {
        int tmp = stash.get(i);
        stash.set(i,stash.get(j));
        stash.set(j,tmp);
    }

    public static boolean puch(ArrayList<Integer> stash) {
        int actSize = stash.size() - 1; //lowered by one on the start
        stash.set(0,stash.get(actSize));
        stash.remove(actSize);
        if (actSize > 1) {
            int parent = 0, son;
            int son1 = 2 * parent + 1;
            int son2 = 2 * parent + 2;
            while (son1 < actSize | son2 < actSize) {
                if (son1 < actSize & son2 < actSize) {
                    son = (stash.get(son1) > stash.get(son2) ? son1 : son2);
                } else son = son1;
                if (stash.get(parent) < stash.get(son)) {
                    swap(stash, parent, son);
                    parent = son;
                    son1 = 2 * parent + 1;
                    son2 = 2 * parent + 2;
                } else break;
            }
            return true;
        } else return false;
    }

    public static int[] sort(ArrayList<Integer> stash) {
        ArrayList<Integer> st = (ArrayList<Integer>) stash.clone();
        int dim = stash.size();
        int[] res = new int[dim];
        for (int i = 0; i < dim; i++) {
            //res[dim - 1 - i] = st.get(0);
            res[i] = st.get(0);
            puch(st);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> stash = new ArrayList<>();
        addElement(stash, -21);
        addElement(stash, 3);
        addElement(stash, 15);
        addElement(stash, -15);
        addElement(stash, 315);
        addElement(stash, 3135);
        addElement(stash, 31);
        System.out.println(stash.get(0));
        puch(stash);
        System.out.println();
        printStash(stash);
        System.out.println();
        System.out.println(Arrays.toString(sort(stash)));
    }
}

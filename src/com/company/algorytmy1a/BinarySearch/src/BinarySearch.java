package com.company.algorytmy1a.BinarySearch.src;

public class BinarySearch implements BinarySearchInterface {

    public boolean contains(int[] tab, int a) {
        if (tab.length == 0) return false;
        int left = 0, right = tab.length - 1;
        int middle = (right - left) / 2;
        while (right > left) {
            if (a > tab[middle]) {
                left = middle + 1;
            } else {
                right = middle;
            }
            middle = (right + left) / 2;
        }
        if (tab[left] == a) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] testTab = {11,13,22,22,33,44,55};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.contains(testTab, -11));
        System.out.println(bs.contains(testTab, 11));
        System.out.println(bs.contains(testTab, 22));
        System.out.println(bs.contains(testTab, 33));
        System.out.println(bs.contains(testTab, 44));
        System.out.println(bs.contains(testTab, 55));
        System.out.println(bs.contains(testTab, 56));
    }
}

/* 
 * 1. Wyszukiwanie binarne
 * 2. Ustaw start na 0 i end na długość tablicy
 * 3. Dopóki end jest większe lub równe start wykonuj:
 * 		1) Ustaw middle na środkowy indeks tablicy
 * 		2) Jeżeli middle równa się szukanej liczbie zwróć prawdę
 * 		3) Jeżeli middle jest mniejsze od szukanej liczby ustaw start na middle + 1
 * 		4) Jeżeli middle jest większe od szukanej liczby ustaw end na end - 1 
 * 4. Po wyjściu z pętli zwróć fałsz - nie znaleziono liczby w tablicy */

package com.company.algorytmy1a;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;

public class PersonalIdentificationNumber {
    public static boolean isPeselCorrect(Integer[] candidate) {
        Integer[] control = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
        if (candidate.length == 11) {
            int last = 0;
            for (int i = 0; i < 10; i++) {
                try {
                    last += candidate[i] * control[i];
                } catch (NullPointerException e) {
                    return false;
                }
            }
            last %= 10;
            if (last == candidate[10]) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPeselCorrect(String string) {
        try {
            return isPeselCorrect(StringToIntTab(string));
        } catch (IllegalStateException e) {
            System.out.println("not a valid number provided!");
            return false;
        }
    }

    private static Integer[] StringToIntTab(String string) throws IllegalStateException {
        Integer[] table = new Integer[string.length()];
        for (int i = 0; i < string.length(); i++) {
            try {
                table[i] = Integer.parseInt(string.substring(i,i+1));
            } catch (NumberFormatException e) {
                throw new IllegalStateException();
                //System.out.println("Not a valid number provided!");
                //table[i] = null;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Integer[] myPesel = {8, 1, 0, 6, 1, 7, 6, 6, 3, 9, 7};
        String myPeselStr = "81m61766397";
        String myPeselStr2 = "81061766397";
        System.out.println(isPeselCorrect(myPesel));
        System.out.println(isPeselCorrect(myPeselStr));
        System.out.println(isPeselCorrect(myPeselStr2));
    }
}

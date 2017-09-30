package com.company.algorytmy1a.Game.src;

import java.util.concurrent.ThreadLocalRandom;

public class BinarySearchComputerPlayer implements Player {

    int lastGuess;
    int start = 1;
    int end = 100;
    boolean firstGuess = true;

    @Override
    public int randomNumber() {
        return 0;
    }

    @Override
    public int nextGuess(int result) {
        //System.out.println(start + " " + end);
        if (firstGuess) {
            firstGuess = false;
            lastGuess = 50;
            return 50;
        }
        if (result > 0) {
            start = lastGuess;
            lastGuess = (start + end) / 2;
        } else {
            end = lastGuess;
            lastGuess = (start + end) / 2;
        }
        //System.out.println(start + " " + end);
        return lastGuess;
    }

    @Override
    public String getName() {
        return "komputer korzystający z binary search";
    }
}

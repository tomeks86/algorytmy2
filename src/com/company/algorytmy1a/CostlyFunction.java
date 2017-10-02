package com.company.algorytmy1a;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class CostlyFunction {
    private static HashMap<Integer, Integer> values = new HashMap<>();

    public static int costlyFunctionCached(int N) {
        if (values.containsKey(N)) {
        } else {
            values.put(N,costlyFunction(N));
        }
        return values.get(N);
    }

    public static int costlyFunction(int N) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (N + 13);
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 1, 3, 6, 3, 1, 0, 3, 7};
        long timeStart = System.currentTimeMillis();
        for (int num : nums) {
            System.out.println(costlyFunction(num));
        }
        long timeStop = System.currentTimeMillis();
        System.out.println("All the calculations took: " + (timeStop - timeStart)/1000. + "s");
        timeStart = System.currentTimeMillis();
        for (int num : nums) {
            System.out.println(costlyFunctionCached(num));
        }
        timeStop = System.currentTimeMillis();
        System.out.println("All the calculations with caching took: " + (timeStop - timeStart)/1000. + "s");
    }
}

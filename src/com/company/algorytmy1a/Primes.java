package com.company.algorytmy1a;

import java.io.*;
import java.util.ArrayList;

public class Primes {

    public static ArrayList<Integer> readPrimes(String fileName){
        ArrayList<Integer> array = new ArrayList<>();
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
            array = (ArrayList<Integer>)is.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static boolean writePrimes(ArrayList<Integer> array) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("myPrimes.bin"));
            os.writeObject(array);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean writePrimesASCII(ArrayList<Integer> array) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("myPrimes.dat"));
            for (Integer num : array) {
                bw.write(num + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean isPrime(int n, ArrayList<Integer> primes) {
        for (Integer prime : primes) {
            if (n % prime == 0) return false;
            if (prime > n / prime) break;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<>();
        primes = readPrimes("myPrimes.bin");
        //int[] firstPrimes = {2, 3, 5, 7, 11}; // used for initialization of Primes.bin
        for (Integer prime : primes) {
            System.out.println(prime);
        }

        int max = 1000000;

        for (int i = primes.get(primes.size() - 1) + 1; i < max + 1; i++) {
            if (isPrime(i, primes)) primes.add(i);
        }

        writePrimes(primes);
        writePrimesASCII(primes);
    }
}

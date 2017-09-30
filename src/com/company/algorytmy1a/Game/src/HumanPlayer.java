package com.company.algorytmy1a.Game.src;

import com.company.algorytmy1a.Game.src.Player;

import java.util.Scanner;

public class HumanPlayer  implements Player {

    private Scanner scanner;

    public HumanPlayer() {
        scanner = new Scanner(System.in);
    }
    
    @Override
    public int randomNumber() {
          System.out.println("Wymysl liczbe od 1 - 100");
          int number = scanner.nextInt();
          while(number>100 || number <1) {
              System.out.println("Liczba musi byc w zakresie 1-100");
              number = scanner.nextInt();
          }
          return number;
    }

    @Override
    public int nextGuess(int result) {
           return scanner.nextInt();
    }

    @Override
    public String getName() {
        return "człowiek";
    }

}

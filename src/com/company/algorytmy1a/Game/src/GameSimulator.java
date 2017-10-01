package com.company.algorytmy1a.Game.src;

public class GameSimulator {

	public static void main(String[] args) {

        Player guessNumberPlayer = new BinarySearchComputerPlayer();
        Player giveNumberToGuessPlayer = new HumanPlayer();
//        Player giveNumberToGuessPlayer = new HumanPlayer();
//        Player guessNumberPlayer = new RandomComputerPlayer();

        int winningNumber = giveNumberToGuessPlayer.randomNumber();
		Game game = new Game(winningNumber);
        System.out.println("Zgaduje " + guessNumberPlayer.getName());
        System.out.println("Zgadnij liczbe od 1 -100");
		int number = guessNumberPlayer.nextGuess(0);
        int result = 0;

        System.out.println("Wybrano: "+number);
        while ((result = game.isWinningNumber(number)) !=0){
            if(result<0){
                System.out.println("Podaj mniejsza liczbe");
            }else{
                System.out.println("Podaj wieksza liczbe");
            }
            game.addAttempts();
            number = guessNumberPlayer.nextGuess(result);
            System.out.println("Wybrano: "+number);
            if(game.getAttempts() > 150) {
                throw new RuntimeException("Zaimplementuj metody w klasie BinarySearchComputerPlayer");
            }

        }
        System.out.println("Gratulacje wygrales w: "+game.getAttempts() + " probach");

	}
}

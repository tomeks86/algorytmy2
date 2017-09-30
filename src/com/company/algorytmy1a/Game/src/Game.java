package com.company.algorytmy1a.Game.src;

public class Game {

	int winningNumber;
	int attempts = 0;
	
	public Game(int winningNumber) {
		super();
		this.winningNumber = winningNumber;
	}

	int isWinningNumber(int number) {
		if (winningNumber<number) {
			return -1;
		} else if (winningNumber == number) {
			return 0;
		} else return 1;
	}

	public void addAttempts() {
		attempts++;
		
	}

	public int getAttempts() {
		// TODO Auto-generated method stub
		return attempts;
	}
}

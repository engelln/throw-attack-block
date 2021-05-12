package game;

// for user input
import java.util.Scanner;

import cards.Card;

// class to bring all the elements of the game together
public class Engine {
	
	// the 2 players of the game
	private static Player human = new Player();
	private static Player computer = new Player();
	// used to keep track of who wins the round
	private static Player roundWinner = null;
	private static Player roundLoser = null;
	// for user input
	private static Scanner userInput = new Scanner(System.in);
	// used to keep track to see if the game is over
	private boolean humanWin = false;
	private boolean computerWin = false;
	
	// when called starts the game
	public void run() {
		/* NEW */
		// initialize the file writer
		Printer.startWriter();
		
		
		// prints the introduction to the game
		Printer.printIntro();
		// repeats whats in the loop until someone "dies"
		gameLoop();
		// prints out game over and if the player won
		Printer.printEndGame(humanWin);
	}


	// loops until someone dies or runs out of cards
	private void gameLoop() {
		// while the game is not over
		while(!checkForGameOver()) {
			// print the play "Board"
			Printer.printBoard();
			// handle what should happen when someone types something
			handleInput();
			
			// choose a card to play for the computer
			computer.selectCard();
			// print out what the computer played
			Printer.printComputerTurn();
			
			// see who's card wins and play that card
			playRoundWinCard();
			
			// have each player draw a card
			human.drawCard();
			computer.drawCard();
		}
		// some notes from writing this loop
		
		// human turn
		// print out their lives
		// print out their cards
		// ask which card they want to play - handle input
		// play the card they want to
		
		// computers turn
		// have it play a card from its hand
		// print out the card it played and its lives
		
		// check who wins the round
		// perform the winning card's action
		// loser loses a life
		
		// each player draws a card
		
		// check if the game is over
		
	}
	
	// processes what the user puts in
	public static void handleInput() {
		// asks the player to enter a card, stores it
		Printer.askForCard();
		String input = userInput.nextLine();
		
		/* NEW */
		// prints what the player entered in the transcript, but not the console
		Printer.log(input);
		
		// checks if the word "description" is in the input
		if(input.toLowerCase().contains("description")) {
			String cardName = input.substring(12);
			// prints out the description
			Printer.print(human.getCardDescription(cardName));
			// repeat again so the player doesn't lose a turn
			handleInput();
		}
		else {
			// choose to play the card they put in
			
			/* NEW */
			// tries to play the players entered card
			try {
				human.selectCard(input);
			} 
			// this happens if the card is not in the player's hand
			// used to be in the player class
			catch (CardNotInHandException e) {
				System.out.println("That card is not in your hand!");
				handleInput();
			}
		}
		
	}
	
	// plays the card of who won the round
	public void playRoundWinCard() {
		// locates who won the round, stores in the player winner variables
		findWinner();
		// if the players didn't tie
		if(roundWinner != null) {
			// play the card of the winner
			roundWinner.getPlayedCard().playCard();
		}
		
	}

	
	
	
	// used to find who won and lost
	private void findWinner() {
		// resets the winner and loser
		roundWinner = null;
		roundLoser = null;
		// checks who chose what card
		Card playerCard = human.getPlayedCard();
		Card computerCard = computer.getPlayedCard();
		//player wins
		if(playerCard.compareTo(computerCard) == 1) {
			// the round winner is the human and loser is the computer
			roundWinner = human;
			roundLoser = computer;
			Printer.print("You win this round!");
		}
		// both the same
		else if(playerCard.compareTo(computerCard) == 0){
			
			Printer.print("You both tied this round!");
		}
		//player loses
		else if(playerCard.compareTo(computerCard) == -1) {
			roundWinner = computer;
			roundLoser = human;
			Printer.print("The Computer won this round!");
		}
		
		
	}
	
	// checks if the game is over yet by checking if both players are still alive
	public boolean checkForGameOver() {
		if(human.checkIfAlive() && !computer.checkIfAlive()) {
			humanWin = true;
		}
		else if(!human.checkIfAlive() && computer.checkIfAlive()) {
			computerWin = true;
		}
		
		if(computerWin || humanWin) {
			return true;
		}
		else {
			return false;
		}
	}

	// various getters
	public static Player getComputer() {
		return computer;
	}
	
	public static Player getHuman() {
		return human;
	}

	public static Player getRoundWinner() {
		return roundWinner;
	}
	
	public static Player getRoundLoser() {
		return roundLoser;
	}


}

package game;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

import cards.Card;

// class to handle most of the large scale printing
public class Printer {
	
	// the object that will write the transcript to the file
	private static PrintWriter output;
	
	// method to initialize the PrintWriter
	public static void startWriter() {
		try {
			// try to create a new PrintWriter object if the given file exists
			output = new PrintWriter("txt/lines.txt");
		} catch (FileNotFoundException e) {
			// if not, tell the user and stop the program
			System.out.println("The output file was not found. Please make sure lines.txt exists.");
			System.exit(0);
		}
	}
	
	/* From here on, where ever something is printed out to the console using System.out.println() / System.out.print(),
	   It will be printed to the output file as well using output.println() / output.print(). */
	
	
	// prints out the message seen every round
	public static void printBoard() {
		System.out.println("\nYour Lives: " + Engine.getHuman().getLives());
		output.println("\nYour Lives: " + Engine.getHuman().getLives());
		
		System.out.println("Opponent's lives: " + Engine.getComputer().getLives());
		output.println("Opponent's lives: " + Engine.getComputer().getLives());
		
		System.out.print("Your hand: ");
		output.print("Your hand: ");
		
		for(Card card : Engine.getHuman().getHand()) {
			System.out.print(card.getName() + "   ");
			output.print(card.getName() + "   ");
		}
		System.out.println();
		output.println();
		
	}

	// prints to ask for a card
	public static void askForCard() {
		System.out.print("Enter card to play: ");
		output.print("Enter card to play: ");
		
	}

	// prints at the start of a game
	public static void printIntro() {
		System.out.println("Welcome to Throw, Attack, Block - A Rock Paper Scissors style game. "
				+ "\nType the name of your card to play it,"
				+ "\nor type \"description (Card Name)\" to see what the card does."
				+ "\nFirst person to run out of lives or cards loses."
				+ "\nType correctly, or else you lose a turn!");
		output.println("Welcome to Throw, Attack, Block - A Rock Paper Scissors style game. "
				+ "\nType the name of your card to play it,"
				+ "\nor type \"description (Card Name)\" to see what the card does."
				+ "\nFirst person to run out of lives or cards loses."
				+ "\nType correctly, or else you lose a turn!");
		
		
	}

	// prints at the end of a game
	public static void printEndGame(boolean humanWin) {
		System.out.println("\nGame Over!");
		output.println("\nGame Over!");
		if(humanWin) {
			System.out.println("You win!");
			output.println("You win!");
			
		}
		else {
			System.out.println("You lose!");
			output.println("You lose!");
		}
		
		System.out.println("You had: " + Engine.getHuman().getLives() + " lives");
		output.println("You had: " + Engine.getHuman().getLives() + " lives");
		
		System.out.println("The computer had: " + Engine.getComputer().getLives() + " lives");
		output.println("The computer had: " + Engine.getComputer().getLives() + " lives");
		
		output.close();
		
	}

	// prints what the computer played
	public static void printComputerTurn() {
		System.out.println("Opponent played: " + Engine.getComputer().getPlayedCard().getName() + "\n");
		output.println("Opponent played: " + Engine.getComputer().getPlayedCard().getName() + "\n");
			
	}


	// method to print to both the console and output file
	public static void print(String line) {
		System.out.println(line);
		output.println(line);
		
	}

	// method to only log to the transcript and not print out to the console
	public static void log(String line) {
		output.println(line);
		
	}
	
	

}

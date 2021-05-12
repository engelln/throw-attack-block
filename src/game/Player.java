package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cards.Card;

// class used to create the players
public class Player {
	
	// each player has lives
	private int lives;
	// each player can be alive
	private boolean isAlive;
	// keep track of what card the player chooses to play
	private Card playedCard = null;
	// keep track of what card they cannot play
	private Card blockedCard = null;
	// the player has a deck and hand
	private ArrayList<Card> deck;
	private ArrayList<Card> hand;
	// random number generator for if the player is the computer
	private Random rng = new Random();
	
	
	public Player() {
		// starts with 10 lives
		lives = 10;
		// starts alive
		isAlive = true;
		// has a deck and a hand
		deck = new ArrayList<>();
		hand  = new ArrayList<>();
		// starts with a full deck
		fillDeck();
		//  and 3 cards in hand
		fillHand();
	}
	
	// player can take a given amount of damage
	public void takeDamage(int dmg) {
		// make sure the player has more lives than damage applied
		if(lives > dmg) {
			lives -= dmg;
		}
		// if not they die
		else {
			isAlive = false;
		}
	}
	
	// a player can get more lives
	public void addLives(int moreLives) {
		lives += moreLives;
	}
	
	// checks the amount of lives and sets if the player is alive
	public boolean checkIfAlive() {
		if(lives <= 0) {
			isAlive = false;
		}
		else if(hand.size() == 0 && deck.size() == 0) {
			isAlive = false;
		}
		return isAlive;
	}
	
	
	
	
	
	// deck related methods
	// player can fill up a deck at the beginning of the game
	public void fillDeck() {
		addCards(DeckDispenser.dispenseDeck());
		shuffleDeck();
	}
	
	// player can add cards to the deck
	public void addCardToDeck(Card card) {
		deck.add(card);
	}
	
	// for an arraylist
	public void addCards(Card[] cards) {
		for(Card card : cards) {
			deck.add(card);
		}
	}
	
	// getter for deck
	public ArrayList<Card> getDeck(){
		return deck;
	}
	
	// shuffles the deck
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	
	
	
	
	// hand related methods
	
	// fills the hand
	public void fillHand() {
		for(int i = 0; i < 3; i++) {
			drawCard();
		}
	}
	
	// add a card to the hand
	public void addCardToHand(Card card) {
		hand.add(card);
	}
	
	// getter for the hand
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	// empty the hand
	public void discardHand() {
		hand.clear();
	}
	
	// remove a certain card
	public void discardCardInHand(int index) {
		hand.remove(index);
	}
	
	// draw a card from the deck
	public void drawCard() {
		if(deck.size() > 0) {
			hand.add(deck.remove(0));
		}
	}
	
	// get a card's description
	public String getCardDescription(String cardName) {
		String returnString = "Not found";
		for (Card card : hand) {
			if(card.getName().equalsIgnoreCase(cardName)){
				returnString = card.getDescription();
				break;
			}
		}
		return returnString;
	}
	
	// for the human
	// select a card to play
	public void selectCard(String cardName) throws CardNotInHandException {
		Card selectedCard = null;
		for(Card card : hand) {
			if(card.getName().equalsIgnoreCase(cardName)) {
				selectedCard = card;
				break;
			}
		}
		
		// if the hand has the card with the name
		if(hand.contains(selectedCard)) {
			// if there is a blocked card
			if(blockedCard != null) {
				// if the card and blocked card type are not the same
				if(selectedCard.compareTo(blockedCard) != 0) {
					playedCard = selectedCard;
					// remove the current blocked card
					blockedCard = null;
					//remove the selected card
					hand.remove(selectedCard);
				}
				// if the card they are trying to play is blocked
				else {
					// tell them and ask for input again
					System.out.println("That card is blocked for this turn!");
					if (!Engine.getHuman().getHand().isEmpty()){
						Engine.handleInput();
					}


				}
			}
			else {
				playedCard = selectedCard;
				hand.remove(selectedCard);
			}
		}
		// if the card is not in the hand
		else {
			/* NEW */
			// code moved to engine class
			//System.out.println("That card is not in your hand!");
			//Engine.handleInput();
			
			// throw the custom CardNotInHandException if the player enters an invalid card
			throw new CardNotInHandException();
		}
	}
		

	
	
	// for the computer
	// selects a random card from the hand to play
	public void selectCard() {
		Card cardToPlay = hand.get(rng.nextInt(hand.size()));
		playedCard = cardToPlay;
		hand.remove(cardToPlay);
	}

	// getters and setters
	public int getLives() {
		return lives;
	}

	public Card getPlayedCard() {
		return playedCard;
	}

	public Card getBlockedCard() {
		return blockedCard;
	}

	public void setBlockedCard(Card blockedCard) {
		this.blockedCard = blockedCard;
	}
		


}

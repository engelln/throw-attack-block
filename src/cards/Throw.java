package cards;

import data.CardDescriptions;

import data.CardNames;
import game.Engine;

//class for the throw card and superclass for all the sub throw cards
public class Throw extends Card {

	// constructor calls the superclass one to set the name and description
	// only used for subclasses
	public Throw(String name, String description) {
		super(name, description);
	}
	
	// if we make a regular throw card, its name and description come from the data files
	public Throw() {
		super(CardNames.THROW, CardDescriptions.THROW);
	}
	
	// used to check which card wins
	@Override
	public int compareTo(Card card) {
		// if its a throw they tie
		if(card instanceof Throw) {
			return 0;
		}
		// if its a block they win
		else if(card instanceof Block) {
			return 1;
		}
		// if its an attack they lose
		else if(card instanceof Attack) {
			return -1;
		}
		else {
			return -2;
		}
	}

	// used for a regular throw
	@Override
	public void playCard() {
		// the loser takes 1 damage
		Engine.getRoundLoser().takeDamage(1);
	}

}

package cards;

import data.CardNames;
import game.Engine;
import data.CardDescriptions;

// class for the block card and superclass for all the sub block cards
public class Block extends Card {
	
	// used to check which card wins
	@Override
	public int compareTo(Card card) {
		// if its a throw they lose
		if(card instanceof Throw) {
			return -1;
		}
		// if its a block they tie
		else if(card instanceof Block) {
			return 0;
		}
		// if its an attack they win
		else if(card instanceof Attack) {
			return 1;
		}
		else {
			return -2;
		}
	}
	// constructor calls the superclass one to set the name and description
	// only used for subclasses
	public Block(String name, String description) {
		super(name, description);
	}
	
	// if we make a regular block card, its name and description come from the data files
	public Block() {
		super(CardNames.BLOCK, CardDescriptions.BLOCK);
	}

	// used for a regular block
	@Override
	public void playCard() {
		// the block gets put back into the hand
		Engine.getRoundWinner().addCardToHand(this);
	}

}

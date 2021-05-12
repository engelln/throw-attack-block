package cards;

import data.CardDescriptions;
import data.CardNames;
import game.Engine;

//class for the attack card and superclass for all the sub attack cards
public class Attack extends Card {

	// used to see which card will win the round, or if they tie
	@Override
	public int compareTo(Card card) {
		// if its a throw they win
		if(card instanceof Throw) {
			return 1;
		}
		// if its a block they lose
		else if(card instanceof Block) {
			return -1;
		}
		// if its the same they tie
		else if(card instanceof Attack) {
			return 0;
		}
		else {
			return -2;
		}
	}
	// constructor calls the superclass one to set the name and description
	// only used for subclasses
	public Attack(String name, String description) {
		super(name, description);
	}
	
	// if we make a regular attack card, its name and description come from the data files
	public Attack() {
		super(CardNames.ATTACK, CardDescriptions.ATTACK);
	}

	// used when a regular attack card is played
	@Override
	public void playCard() {
		// it takes 1 damage from the round loser
		Engine.getRoundLoser().takeDamage(1);
	}
	

}

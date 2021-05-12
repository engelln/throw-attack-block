package cards;

import data.CardDescriptions;
import data.CardNames;
import game.Engine;

public class FrenzyAttack extends Attack {

	public FrenzyAttack(){
		super(CardNames.FRENZY_ATTACK,CardDescriptions.FRENZY_ATTACK);
	}
	
	@Override
	public void playCard() {
		// deal 1 damage to loser
		Engine.getRoundLoser().takeDamage(1);
		
		// give 1 extra damage for every 2 cards
		int extraDamage = 0;
		for(int i = 0; i > Engine.getRoundWinner().getHand().size(); i++) {
			extraDamage++;
		}
		extraDamage = Math.floorDiv(extraDamage, 2);
		Engine.getRoundLoser().takeDamage(extraDamage);
		// empty the winner's hand
		Engine.getRoundWinner().discardHand();
	}


}

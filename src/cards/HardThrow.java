package cards;

import data.CardDescriptions;
import data.CardNames;
import game.Engine;

public class HardThrow extends Throw{

	public HardThrow(){
		super(CardNames.HARD_THROW,CardDescriptions.HARD_THROW);
	}

	@Override
	public void playCard() {
		// loser takes 2 damage
		Engine.getRoundLoser().takeDamage(2);
		// loser cannot play a block next turn
		Engine.getRoundLoser().setBlockedCard(new Block());
	}
	
	

}

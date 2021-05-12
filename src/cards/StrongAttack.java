package cards;

import data.CardDescriptions;
import data.CardNames;
import game.Engine;

public class StrongAttack extends Attack {

	public StrongAttack(){
		super(CardNames.STRONG_ATTACK,CardDescriptions.STRONG_ATTACK);
	}
	
	@Override
	public void playCard() {
		// deal 2 damage to loser
		Engine.getRoundLoser().takeDamage(2);
		// winner draws an extra card
		Engine.getRoundWinner().drawCard();
	}

}

package cards;

import data.CardDescriptions;
import data.CardNames;
import game.Engine;

public class ExtraStrongAttack extends Attack {

	public ExtraStrongAttack(){
		super(CardNames.EXTRA_STRONG_ATTACK,CardDescriptions.EXTRA_STRONG_ATTACK);
	}
	
	@Override
	public void playCard() {
		// deal 3 damage to loser
		Engine.getRoundLoser().takeDamage(3);
	}

}

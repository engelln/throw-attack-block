package cards;

import data.CardDescriptions;
import data.CardNames;
import game.Engine;

public class LivelyThrow extends Throw {

	public LivelyThrow(){
		super(CardNames.LIVELY_THROW,CardDescriptions.LIVELY_THROW);
	}

	@Override
	public void playCard() {
		// loser takes 1 damage
		Engine.getRoundLoser().takeDamage(1);
		// winner gets 2 lives
		Engine.getRoundWinner().addLives(2);
		// loser can't play an attack
		Engine.getRoundLoser().setBlockedCard(new Attack());
	}

	
}

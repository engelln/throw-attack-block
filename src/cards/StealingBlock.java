package cards;

import data.CardDescriptions;
import data.CardNames;
import game.Engine;

public class StealingBlock extends Block{

	public StealingBlock(){
		super(CardNames.STEALING_BLOCK,CardDescriptions.STEALING_BLOCK);
	}

	@Override
	public void playCard() {
		// winner gets the loser's played card
		Engine.getRoundWinner().addCardToHand(Engine.getRoundLoser().getPlayedCard());
		// winner gets to keep this card
		Engine.getRoundWinner().addCardToHand(this);
	}
	

}

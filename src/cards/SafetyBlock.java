package cards;

import data.CardDescriptions;
import data.CardNames;
import game.Engine;

public class SafetyBlock extends Block {

	public SafetyBlock(){
		super(CardNames.SAFETY_BLOCK,CardDescriptions.SAFETY_BLOCK);
	}

	@Override
	public void playCard() {
		// winner gets 2 lives
		Engine.getRoundWinner().addLives(2);
		// winner keeps this card
		Engine.getRoundWinner().addCardToHand(this);
	}

}

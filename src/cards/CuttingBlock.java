package cards;

import data.CardDescriptions;
import java.util.Random;
import data.CardNames;
import game.Engine;

public class CuttingBlock extends Block{
	
	Random rng = new Random();

	public CuttingBlock(){
		super(CardNames.CUTTING_BLOCK,CardDescriptions.CUTTING_BLOCK);
	}

	@Override
	public void playCard() {
		// if the loser's hand has more than 1 card
		if(Engine.getRoundLoser().getHand().size() > 1) {
			// discard a random card from the loser
			Engine.getRoundLoser().discardCardInHand(rng.nextInt(Engine.getRoundLoser().getHand().size()));
		}
		// add this back to the winner's hand
		Engine.getRoundWinner().addCardToHand(this);
	}

}

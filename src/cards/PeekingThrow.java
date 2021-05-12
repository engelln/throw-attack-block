package cards;

import data.CardDescriptions;
import data.CardNames;
import game.Engine;

public class PeekingThrow extends Throw {

	public PeekingThrow(){
		super(CardNames.PEEKING_THROW,CardDescriptions.PEEKING_THROW);
	}

	@Override
	public void playCard() {
		// loser takes 1 damage
		Engine.getRoundLoser().takeDamage(1);
		
		// here we actually need to check if the two objects are the same, not just if their contents are equal
		// if the winner is the human then print out the computer's cards in hand
		if(Engine.getRoundWinner() == Engine.getHuman()) {
			System.out.print("Opponent's hand: ");
			for(Card card : Engine.getRoundLoser().getHand()) {
				System.out.print(card.getName() + "   ");
			}
			System.out.println();
		}
		// block the loser from using a throw
		Engine.getRoundLoser().setBlockedCard(new Throw());
	}

}

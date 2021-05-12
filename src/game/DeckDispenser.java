package game;

// we need all the cards package classes
import cards.*;

// when a player asks for a new deck at the start of the game, this class will hand one out
public class DeckDispenser {
	
	public static Card[] dispenseDeck(){
		Card[] cards = {
				new Attack(),
				new Attack(),
				new Attack(),
				new StrongAttack(),
				new StrongAttack(),
				new StrongAttack(),
				new ExtraStrongAttack(),
				new ExtraStrongAttack(),
				new ExtraStrongAttack(),
				new FrenzyAttack(),
				new FrenzyAttack(),
				new FrenzyAttack(),
				
				new Block(),
				new Block(),
				new Block(),
				new SafetyBlock(),
				new SafetyBlock(),
				new SafetyBlock(),
				new CuttingBlock(),
				new CuttingBlock(),
				new CuttingBlock(),
				new StealingBlock(),
				new StealingBlock(),
				new StealingBlock(),
				
				new Throw(),
				new Throw(),
				new Throw(),
				new HardThrow(),
				new HardThrow(),
				new HardThrow(),
				new LivelyThrow(),
				new LivelyThrow(),
				new LivelyThrow(),
				new PeekingThrow(),
				new PeekingThrow(),
				new PeekingThrow()

				
		};
		
		return cards;
		
	}

}

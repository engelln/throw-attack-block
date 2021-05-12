package data;

// lcass to hold the card descriptions
public class CardDescriptions {

	public static final String ATTACK = "Deal 1 damage, beats any throw.";
	public static final String STRONG_ATTACK = "Deal 2 damage, beats throw and you get to draw an extra card.";
	public static final String EXTRA_STRONG_ATTACK = "Deal 3 damage, beats any throw.";
	public static final String FRENZY_ATTACK = "Deals 1 damage + 1 damage for every 2 cards in your hand, beats throw but you must discard entire hand.";
	
	public static final String BLOCK = "Deals no damage, but beats any attack. You keep the card if opponent plays attack.";
	public static final String SAFETY_BLOCK = "Beats attack, If block is successful, get 2 life.";
	public static final String CUTTING_BLOCK = "Beats attack, If block is successful, your opponent must discard a random card.";
	public static final String STEALING_BLOCK = "Beats attack, If block is successful, you get the opponent's attack card in hand.";
	
	public static final String THROW = "Deal 1 damage, beats any block.";
	public static final String HARD_THROW = "Deal 2 damage, beats any block, opponent cannot play block next turn.";
	public static final String LIVELY_THROW = "Deal 1 damage, beat any block, get 2 extra lives, and the opponent cannot play an attack next turn.";
	public static final String PEEKING_THROW = "Deal 1 damage, beat any block, look at the opponents hand, and opponent cannot play a throw next turn.";
	
}

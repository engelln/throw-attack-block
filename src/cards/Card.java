package cards;


// superclass for all the cards, all cards are playable and comparable
public class Card implements Playable, Comparable<Card> {
	
	// all cards have a name and description
	private String name = "";
	private String description = "";
	
	// constructor sets name and description
	public Card(String name, String description) {
		this.name = name;
		this.description = description;
	}

	// method from the playable interface
	@Override
	public void playCard() {
		
	}

	// getters for name and description
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	// from the comparable interface, will be used to see which card wins
	@Override
	public int compareTo(Card arg0) {
		return 0;
	}

}

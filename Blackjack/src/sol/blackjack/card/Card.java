package sol.blackjack.card;

public class Card {
	
	private int value;
	private Suit suit;
	
	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}
	
	public int value() {
		return value;
	}
	
	public Suit suit() {
		return suit;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", suit=" + suit + "]";
	}

}

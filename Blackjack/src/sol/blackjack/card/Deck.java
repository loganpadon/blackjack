package sol.blackjack.card;

import java.util.LinkedList;
import java.util.Random;

public class Deck {

	private LinkedList<Card> deck = new LinkedList<>();

	public void deal(Player player) {
		Card card = deck.removeFirst();
		player.add(card);
	}

	private void populate() {
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				int value = j;
				Suit suit = Suit.values()[i];
				Card card = new Card(value, suit);
				deck.add(card);
			}
		}
	}

	private void shuffle() {
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			Card card = deck.remove(random.nextInt(52));
			deck.add(card);
		}
	}

	public Deck() {
		populate();
		shuffle();
	}

}

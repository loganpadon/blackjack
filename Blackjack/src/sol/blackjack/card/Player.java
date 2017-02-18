package sol.blackjack.card;

import java.util.LinkedList;

public class Player {

	private LinkedList<Card> hand = new LinkedList<>();

	public void add(Card card) {
		hand.add(card);
	}

	public int check(Player player) {
		int total = 0;
		for (Card card : player.hand()) {
			int value = card.value();
			if (value > 10)
				value = 10;
			if (value == 1) {
				if (total + 11 > 21)
					value = 1;
				else
					value = 11;
			}
			total += value;

		}
		System.out.println(total);
		if (total > 21)
			return 1;
		else
			return 0;
	}

	public LinkedList<Card> hand() {
		return (LinkedList<Card>) hand.clone();
	}

	public Card hand(int i) {
		return hand.get(i);
	}
}

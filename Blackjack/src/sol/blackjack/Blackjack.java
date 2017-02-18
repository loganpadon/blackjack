//Still need to add pictures, figure out where the println is coming from, and pretty up 
//the program a bit. Bonne chance! 
package sol.blackjack;

import javax.swing.JOptionPane;

import sol.blackjack.card.Card;
import sol.blackjack.card.Deck;
import sol.blackjack.card.Player;

public class Blackjack {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Player player = new Player();
		Player dealer = new Player();
		String[] options = { "Hit", "Stand" };
		int total = 0;
		int goodGuy = 0;
		int badGuy = 0;
		int total2 = 0;
		int answer = 0;

		deck.deal(dealer);
		deck.deal(dealer);
		deck.deal(player);
		do {
			deck.deal(player);
			goodGuy = player.check(player);
			if (goodGuy == 1) {
				JOptionPane.showMessageDialog(null, "Your hand is "+player.hand()+
						"\nThe dealer's hand is"+dealer.hand()+"\nBusted! You lose.");
				System.exit(0);
			}
			answer = JOptionPane.showOptionDialog(null, "Your hand is "
					+ player.hand() + "\nThe dealer's hand is" + dealer.hand(1)
					+ "\nHit or Stand?", "Blackjack",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, options, options[0]);
		} while (answer == 0);
		
		while (total <= 16) {
			deck.deal(dealer);
			for (Card card : dealer.hand()) {
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
				badGuy = player.check(dealer);
				if (badGuy == 1) {
					JOptionPane.showMessageDialog(null, "Your hand is "+player.hand()+
					"\nThe dealer's hand is"+dealer.hand()+"\nThe dealer busted! You win!");
					System.exit(0);
				}
			}

		}
		
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
			total2 += value;

		}
		if (total2 > total)
			JOptionPane.showMessageDialog(null, "Your hand is "+player.hand()+
					"\nThe dealer's hand is"+dealer.hand()+"\nYou win!");
		else
			JOptionPane.showMessageDialog(null, "Your hand is "+player.hand()+
					"\nThe dealer's hand is"+dealer.hand()+"\nYou lose.");
	}
}
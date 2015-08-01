import java.util.ArrayList;
import java.util.List;

public class Guess {

	private Player player;

	public Guess(boolean suggestion, List<Card> guess, Player player) {
		this.player = player;
		if (suggestion) {
			Suggestion(guess);
		} else {
			Accusation(guess);
		}
	}

	/**
	 * Check to see if player is in room suggested. Check to see if any of the
	 * players have the card, if they do then add the discovered card to the
	 * list of cards in every players hand if they don't already have it.
	 * Otherwise do nothing.
	 */
	private void Suggestion(List<Card> guess) {
		Room room = null;
		Card discoveredCard = null;
		ArrayList<Player> players = Board.players;
		for (Card card : guess) {
			if (card instanceof Room) {
				room = (Room) card;
			}
		}
		if (player.getLocation().equals(room.getLocation())) {
			for (Card card : guess) {
				int playerNum = player.getNum();
				int start = player.getNum();
				while (playerNum != start) {
					playerNum = (playerNum % Board.players.size()) + 1;
					ArrayList<Card> cards = players.get(playerNum).getCards();
					for (Card c : cards) {
						if (c.equals(card)) {
							discoveredCard = c;
							break;
						}
					}
					if (discoveredCard != null) {
						break;
					}
				}
				if (discoveredCard != null) {
					break;
				}
			}
		}
		if (discoveredCard != null) {
			for (Player p : players) {
				ArrayList<Card> cards = p.getCards();
				cards.add(discoveredCard);
				p.setCards(cards);
			}
		} else {
			System.out.println("No player had any of the suggested cards");
		}
	}

	/**
	 * Check to see if the Accusation is equal to the answer, if it is then the
	 * player who made the accusation wins. Otherwise ...
	 */
	private void Accusation(List<Card> guess) { // What happens after a player
												// is eliminated?

	}
}
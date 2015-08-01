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
				p.addToHand(discoveredCard);
			}
		} else {
			System.out.println("No player had any of the suggested cards");
		}
	}

	/**
	 * Check to see if the Accusation is equal to the answer, if it is then the
	 * player who made the accusation wins. Otherwise they are eliminated from
	 * the game and their cards are delegated out to the remaining players.
	 */
	private void Accusation(List<Card> guess) {
		for (Card card : guess) {
			if(!Board.answer.contains(card)){
				for(Player p : Board.players){
					for(int i = 0; i < player.getCards().size(); i++){
						p.addToHand(player.getCards().get(i));
					}
				}
				Board.players.remove(player);
			}
		}
		//player wins
	}
}
import java.util.ArrayList;
import java.util.List;

public class Guess {

	private Player player;
	private boolean won = false;
	private Player eliminatedPlayer;

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
				playerNum = (playerNum % Board.players.size()) + 1;
				int start = player.getNum();
				while (playerNum != start) {
					ArrayList<Card> cards = players.get(playerNum-1).getCards();
					for (Card c : cards) {
						if (c.equals(card)) {
							discoveredCard = c;
							break;
						}
					}
					playerNum = (playerNum % Board.players.size()) + 1;
					if (discoveredCard != null) {
						break;
					}
				}
				if (discoveredCard != null) {
					break;
				}
			}
		}
		else{
			System.out.println("Must be in the room to suggest it");
		}
		if (discoveredCard != null) {
			for (Player p : players) {
				p.addToHand(discoveredCard);
			}
		} else {
			System.out.println("No player had any of the suggested cards");
		}
		System.out.println("Discovered card was: " + discoveredCard.getName());
	}

	/**
	 * Check to see if the Accusation is equal to the answer, if it is then the
	 * player who made the accusation wins. Otherwise they are eliminated from
	 * the game and their cards are delegated out to the remaining players.
	 */
	private void Accusation(List<Card> guess) {
		boolean entered = false;
		for (Card card : guess) {
			if(!Board.answer.contains(card)){
				entered = true;
				int playerNum = player.getNum();
				playerNum = (playerNum % Board.players.size()) + 1;
				int start = player.getNum();
				while (true) {
					if(player.getCards().isEmpty()){
						break;
					}
					if(Board.players.get(playerNum-1)!=player){
						Board.players.get(playerNum-1).addToHand(player.getCards().get(0));
						player.getCards().remove(0);
					}
					playerNum = (playerNum % Board.players.size()) + 1;
					if(playerNum == start){
						playerNum = (playerNum % Board.players.size()) + 1;
					}
				}
				eliminatedPlayer = player;
				
			}
		}
		if(entered == false && !guess.contains(null)){
			this.won = true;
			System.out.println(this.won);
		}
		
	}
	
	public boolean hasWon(){
		return won;
	}
	
	public Player getEliminatedPlayer(){
		return eliminatedPlayer;
	}
}
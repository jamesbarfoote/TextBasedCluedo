import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class Guess {
<<<<<<< HEAD
	
	private Player player;
	
	public Guess(boolean suggestion, List<Card> guess, Player player) {
		this.player = player;
		if(suggestion){
			Suggestion(guess);
		}
		else{
			Accusation(guess);
		}
	}
	
	/**
	 * Check to see if player is in room suggested.
	 * Check to see if any of the players have the card, if they do then
	 * add the discovered card to the list of cards in every players hand if they don't already have it.
	 * Otherwise do nothing.
	 */
	private void Suggestion(List<Card> guess){	//Need to check players in a clockwise direction from the current player. Currently it always starts at the same player.
		Room room = null;
		Card discoveredCard = null;
		List<Player> players = Board.players;
		for(Card card : guess){
			if(card instanceof Room){
				room = (Room) card;
			}
		}
		if(player.getLocation().equals(room.getLocation())){
			for(Card card : guess){
				for(Player p : players){	//this needs to be fixed.
					ArrayList<Card> cards = p.getCards();
					for(Card c : cards){
						if(c.equals(card)){
							discoveredCard = c;
							break;
						}
					}
					if(discoveredCard!=null){
						break;
					}
				}
				if(discoveredCard!=null){
					break;
				}
			}
		}
		if(discoveredCard!=null){
			for(Player p : players){
				ArrayList<Card> cards = p.getCards();
				cards.add(discoveredCard);
				p.setCards(cards);
			}
		}
		else{
			System.out.println("No player had any of the suggested cards");
		}
	}
	
	/**
	 * Check to see if the Accusation is equal to the answer,
	 * if it is then the player who made the accusation wins.
	 * Otherwise ...
	 */
	private void Accusation(List<Card> guess){	//What happens after a player is eliminated?
		
	}
}
=======
private ArrayList<Card> cards = new ArrayList<Card>();

	public Guess(Boolean type, ArrayList<Card> c)
	{
		this.cards = c;
		if(type)
		{
			Guess();
		}
		else
		{
			Answer();
		}
	}
	
	public void Guess()
	{
		//Iterate over the players in order
		//Check if a player has one of the guessed cards
		//If they do then return it and print it
		//Then end turn
	}
	
	public void Answer()
	{
		//Check each of the cards the player guessed against the answer cards
		//If correct then play p wins. Answer is printed
		//Else they are eliminated and their turn ends
	}
}
>>>>>>> origin/master

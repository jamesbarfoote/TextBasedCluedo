
import java.util.ArrayList;

public class Guess {
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

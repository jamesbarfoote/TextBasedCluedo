
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Player {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Location lp;
	private int roll;
	private Map<Room, Integer> roomDistances = new HashMap<Room, Integer>();
	
	public Player (Card c, Location l)
	{
		this.cards.add(c);
		this.lp = l;
	}
	
	
	public void rollDice()
	{
		Random rand = new Random();
		roll = rand.nextInt(6);
		System.out.println(roll);
	}
	
	public void updateLocation(int x, int y)
	{
		//Update X and Y value of where they are
		//Get the dice roll
		//
	}
	
	//Calculate the distance to all the rooms
	public void calculateDistance(Room r)
	{
		
	}


	public ArrayList<Card> getCards() {
		return cards;
	}


	public int getRoll() {
		return roll;
	}


	public Map<Room, Integer> getRoomDist() {
		return roomDistances;
	}

}


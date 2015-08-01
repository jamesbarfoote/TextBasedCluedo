import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board {

	public static ArrayList<Card> answer;
	public static ArrayList<Player> players;
	private int width, height;
	private ArrayList<String> weapons = new ArrayList<>(Arrays.asList("Candlestick", "Dagger", "Revolver", "Rope", "Lead Pipe", "Spanner"));
	private ArrayList<String> rooms = new ArrayList<>(Arrays.asList("Kitchen", "Ballroom", "Conservatory", "Billiard Room", "Library", "Study", "Hall", "Lounge", "Dining Room"));
	private ArrayList<String> characters = new ArrayList<>(Arrays.asList("Miss Scarlett", "Colonel Mustard", "Mrs. White", "The Reverend Green", "Mrs. Peacock", "Professor Plum"));

	
	public Board(int width, int height, int numP) {
		this.answer = genAns();
		this.players = genPlayers(numP);
		this.width = width;
		this.height = height;
		
		//create weapon array
		//create character array
		//create room array
	}
	
	public ArrayList<Player> genPlayers(int numPlayers)
	{
		ArrayList<Player> players = new ArrayList<Player>();
		Random rand = new Random();
		int r1 = rand.nextInt(6);
		//For each player
		//Give w, r, r until there is only 1 item left in each array
		return players;
	}
	
	//Deligate cards method
	
	public ArrayList<Card> genAns()
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		Room r = new Room(rooms.get(0), null);
		rooms.remove(0);
		
		Weapon w = new Weapon(weapons.get(0));
		weapons.remove(0);
		
		Character c = new Character(characters.get(0));
		characters.remove(0);
		
		cards.add(r);
		cards.add(w);
		cards.add(c);
		
		return cards;
	}
}
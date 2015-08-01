import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board {

	public static ArrayList<Card> answer;
	public static ArrayList<Player> players;
	private int width, height;
	private ArrayList<String> weaponNames = new ArrayList<>(Arrays.asList("Candlestick", "Dagger", "Revolver", "Rope", "Lead Pipe", "Spanner"));
	private ArrayList<String> characterNames = new ArrayList<>(Arrays.asList("Miss Scarlett", "Colonel Mustard","Mrs. White", "The Reverend Green", "Mrs. Peacock", "Professor Plum"));
	private ArrayList<String> roomNames = new ArrayList<>(Arrays.asList("Kitchen", "Ballroom", "Conservatory","Billiard Room", "Library", "Study", "Hall", "Lounge", "Dining Room"));

	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private ArrayList<Character> characters = new ArrayList<Character>();
	private ArrayList<Room> rooms = new ArrayList<Room>();

	public Board(int width, int height, int numP) {
		this.answer = genAns();
		this.players = genPlayers(numP);
		this.width = width;
		this.height = height;
	}

	/**
	 * Create the cards from the names provided in the Board class.
	 * @param cards
	 */
	private void createCards(ArrayList<String> cards){
		for(String card : cards){
			if(cards == weaponNames || cards == characterNames){
				
			}
			if(cards == roomNames){

			}
		}
	}

	/**
	 * Create the players and delegate cards to their hand
	 * until only 1 element is left in each of the cards arrays.
	 * @param numPlayers
	 * @return
	 */
	private ArrayList<Player> genPlayers(int numPlayers) {
		ArrayList<Player> players = new ArrayList<Player>();
		Random rand = new Random();
		int weaponNum = rand.nextInt(weapons.size());
		int characterNum = rand.nextInt(characters.size());
		int RoomNum = rand.nextInt(rooms.size());

		// For each player
		// Give w, r, character until there is only 1 item left in each array
		return players;
	}


	private ArrayList<Card> genAns() {
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

	public ArrayList<Player> getPlayers()
	{
		return players;
	}
}
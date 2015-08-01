import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board {

	public static ArrayList<Card> answer;
	public static ArrayList<Player> players = new ArrayList<Player>();
	private int width, height;
	private ArrayList<String> weaponNames = new ArrayList<>(Arrays.asList("Candlestick", "Dagger", "Revolver", "Rope", "Lead Pipe", "Spanner"));
	private ArrayList<String> characterNames = new ArrayList<>(Arrays.asList("Miss Scarlett", "Colonel Mustard","Mrs. White", "The Reverend Green", "Mrs. Peacock", "Professor Plum"));
	private ArrayList<String> roomNames = new ArrayList<>(Arrays.asList("Kitchen", "Ballroom", "Conservatory","Billiard Room", "Library", "Study", "Hall", "Lounge", "Dining Room"));

	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private ArrayList<Character> characters = new ArrayList<Character>();
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private ArrayList<Card> allCards = new ArrayList<Card>();

	public Board(int width, int height, int numP) {
		createCards();
		this.answer = genAns();
		genPlayers(numP);
		this.width = width;
		this.height = height;
	}

	/**
	 * Create the cards from the names provided in the Board class.
	 * @param cards
	 */
	private void createCards(){		//Need to decide on locations for all the rooms.
		for(String weapon : weaponNames){
			weapons.add(new Weapon(weapon));
		}
		for(String character : characterNames){
			characters.add(new Character(character));
		}
		for(String room : roomNames){
			if(room.equals("Kitchen")){
				rooms.add(new Room(room, null));
			}
			if(room.equals("Ballroom")){
				rooms.add(new Room(room, null));
			}
			if(room.equals("Conservatory")){
				rooms.add(new Room(room, null));
			}
			if(room.equals("Billiard Room")){
				rooms.add(new Room(room, null));
			}
			if(room.equals("Library")){
				rooms.add(new Room(room, null));
			}
			if(room.equals("Study")){
				rooms.add(new Room(room, null));
			}
			if(room.equals("Hall")){
				rooms.add(new Room(room, null));
			}
			if(room.equals("Lounge")){
				rooms.add(new Room(room, null));
			}
			if(room.equals("Dining Room")){
				rooms.add(new Room(room, null));
			}
		}
		allCards.addAll(weapons);
		allCards.addAll(characters);
		allCards.addAll(rooms);
	}

	/**
	 * Generates a random answer.
	 * An Answer is 3 random cards, one Weapon, one Character and one Room.
	 * @return ArrayList<Card>
	 */
	private ArrayList<Card> genAns() {
		ArrayList<Card> answer = new ArrayList<Card>();
		Random rand = new Random();
		int weaponNum = rand.nextInt(weapons.size());
		int characterNum = rand.nextInt(characters.size());
		int roomNum = rand.nextInt(rooms.size());
		Weapon weapon = weapons.get(weaponNum);
		Character character = characters.get(characterNum);
		Room room = rooms.get(roomNum);
		answer.add(weapon);
		answer.add(character);
		answer.add(room);
		allCards.remove(weapon);
		allCards.remove(character);
		allCards.remove(room);
		return answer;
	}

	/**
	 * Create the players and delegates cards to their hand
	 * @param numPlayers
	 * @return
	 */
	private void genPlayers(int numPlayers) {
	}

	public ArrayList<Player> getPlayers()
	{
		return players;
	}
}
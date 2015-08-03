import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		for(Card c : allCards){
			System.out.println(c.getName());
		}
	}

	/**
	 * Create the cards from the names provided in the Board class.
	 * @param cards
	 */
	private void createCards(){
		for(String weapon : weaponNames){
			weapons.add(new Weapon(weapon));
		}
		for(String character : characterNames){
			characters.add(new Character(character));
		}
		for(String room : roomNames){
			if(room.equals("Kitchen")){
				rooms.add(new Room(room, new Location(6,4)));
			}
			if(room.equals("Ballroom")){
				rooms.add(new Room(room, new Location(13,4)));
			}
			if(room.equals("Conservatory")){
				rooms.add(new Room(room, new Location(20,4)));
			}
			if(room.equals("Billiard Room")){
				rooms.add(new Room(room, new Location(20,9)));
			}
			if(room.equals("Library")){
				rooms.add(new Room(room, new Location(20,14)));
			}
			if(room.equals("Study")){
				rooms.add(new Room(room, new Location(20,19)));
			}
			if(room.equals("Hall")){
				rooms.add(new Room(room, new Location(13,19)));
			}
			if(room.equals("Lounge")){
				rooms.add(new Room(room, new Location(6,19)));
			}
			if(room.equals("Dining Room")){
				rooms.add(new Room(room, new Location(6,11)));
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
	 * Creates the players and delegates cards to their hand
	 * @param numPlayers
	 * @return
	 */
	private void genPlayers(int numPlayers) {
		Random rand = new Random();
		int characterNum = rand.nextInt(characters.size());
		int count = 0;
		ArrayList<Integer> usedCharacters = new ArrayList<Integer>();
		while(count < numPlayers){
			usedCharacters.add(characterNum);
			if(characterNames.get(characterNum) == "Miss Scarlett"){
				players.add(new Player("Miss Scarlett", new Location(10,0), count));
			}
			if(characterNames.get(characterNum) == "Colonel Mustard"){
				players.add(new Player("Colonel Mustard", new Location(18,0), count));
			}
			if(characterNames.get(characterNum) == "Mrs. White"){
				players.add(new Player("Mrs. White", new Location(25,5), count));
			}
			if(characterNames.get(characterNum) == "The Reverend Green"){
				players.add(new Player("The Reverend Green", new Location(16,25), count));
			}
			if(characterNames.get(characterNum) == "Mrs. Peacock"){
				players.add(new Player("Mrs. Peacock", new Location(7,25), count));
			}
			if(characterNames.get(characterNum) == "Professor Plum"){
				players.add(new Player("Professor Plum", new Location(0,16), count));
			}
			count++;
			while(true){
				int newCharacterNum = rand.nextInt(characters.size());
				if(usedCharacters.contains(newCharacterNum) == false || count == 6){
					characterNum = newCharacterNum;
					break;
				}
			}
		}
		Collections.shuffle(allCards);
		int numCards = allCards.size();
		for(Player p: players)
		{
			
			int i = 0;
			int j = 0;
			while(i <(numCards/players.size() ) )
			{
				p.addToHand(allCards.get(i));
				i++;
			}
			while(j <(numCards/players.size()  ))
			{
				allCards.remove(0);
				j++;
			}
		}
	}

	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public ArrayList<String> getWeaponNames(){
		return weaponNames;
	}
	
	public ArrayList<String> getCharacterNames(){
		return characterNames;
	}
	
	public ArrayList<String> getRoomNames(){
		return roomNames;
	}
	
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	
	public ArrayList<Weapon> getWeapons(){
		return weapons;
	}
	
	public ArrayList<Character> getCharacters(){
		return characters;
	}
}

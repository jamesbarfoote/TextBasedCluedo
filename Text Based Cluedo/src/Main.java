import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Main {
	private static boolean finished = false;
	
	public static void playGame(Scanner scan)
	{
		System.out.println("Welcome to cluedo!");
		int h = 25;
		int w = 25;
		int numP = 0;
		
		//ask for how many players are playing
		
		numP = scan.nextInt();
		
		Board b = new Board(h, w, numP);
		
		ArrayList<Player> players = b.getPlayers();
		
		while(finished == false)
		{
			haveTurns(players, scan, b);
			System.out.println("There are " + players.size() + " players");
		//for each player
			
		}
	}
	
	public static void haveTurns(ArrayList<Player> players, Scanner scan, Board b)
	{
		for(Player p: players)
		{
			System.out.println(p.getNum());
			System.out.println(p.getLocation().getX());
			Room r = null;
			//calculate distances	
			p.calculateDistances(b);
			System.out.println("Calculated distances");
			Map<Room, Integer> rDist = p.getRoomDist();
			int i = 0;
			//look at room distances map and print out each entry
			ArrayList<Room> rooms = new ArrayList<Room>();
			System.out.println("rDist size = " + rDist.size());
			for(Entry<Room, Integer> e: rDist.entrySet())
			{
				Room cr = e.getKey();
				int dist = e.getValue();
				rooms.add(cr);
				System.out.println(i + " " + cr.getName() + " " + dist);
				i++;
			}
				
			//roll dice
			int diceNum = p.rollDice();
			System.out.println("You rolled a " + diceNum);
			
			//give option for movement (dont have to)
			System.out.println("Where do you want to move to?");
			int numChoice = scan.nextInt();
			
			//update location
			r = rooms.get(numChoice);
			p.updateLocation(r);
			scan.useDelimiter(System.getProperty("line.separator"));
			//make a guess option (suggestion, accusation OR nothing)
			System.out.println("What would you like to do?");
			System.out.println("1 - Suggestion");
			System.out.println("2 - Accusation");
			System.out.println("3 - Nothing");
			int option = scan.nextInt();
		    if(option == 1 || option == 2)
		    { 
		    	
		    	System.out.println("Please type the 3 cards that you are guessing on a new line");
		    	System.out.println("In this order: Room, Weapon, Character");
		    	//get cards from typed input on new line
		    	String roomName = scan.next();
		    	int index = b.getRoomNames().indexOf(roomName);
		    	Room g = b.getRooms().get(index);
		    	
		    	int indexW = b.getWeaponNames().indexOf(scan.next());
		    	Weapon gw = b.getWeapons().get(indexW);
		    	
		    	String characterN = scan.next();
		    	int indexC = b.getCharacterNames().indexOf(characterN);
		    	Character gc = b.getCharacters().get(indexC);
		    	
		    	ArrayList<Card> guessHand = new ArrayList<Card>();
		    	guessHand.add(gw);
		    	guessHand.add(g);
		    	guessHand.add(gc);
		    	
		    	//create a guess hand
		    	boolean opt = false;
		    	if(option == 1)
		    	{
		    		opt = true;
		    	}
		    	
				Guess n = new Guess(opt, guessHand, p);
				ArrayList<Player> play = b.getPlayers();
				players = play;
				if (n.hasWon()) { finished = true;}
		    	
		    }
				
				
				
			//end turn 
		}
		
	}
		
	public static void main(String [ ] args)
	{
		Scanner scan = new Scanner(System.in);
		playGame(scan);
	}

}
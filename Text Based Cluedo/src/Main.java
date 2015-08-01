import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void playGame(Scanner scan)
	{
		System.out.println("Welcome to cluedo!");
		int h = 25;
		int w = 25;
		int numP = 0;
		boolean finished = false;
		//ask for how many players are playing
		System.out.println("How many players are there?");
		numP = scan.nextInt();
		System.out.println(numP);
		Board b = new Board(h, w, numP);
		ArrayList<Player> players = b.getPlayers();
		System.out.println("Got players");
		while(!finished)
		{
			//System.out.println("There are " + players.size() + " players");
		//for each player
			for(Player p: players)
			{
				Room r = null;
				//calculate distances	
				p.calculateDistances();
				System.out.println("Calculated distances");
				Map<Room, Integer> rDist = p.getRoomDist();
				int i = 0;
				//look at room distances map and print out each entry
				ArrayList<Room> rooms = new ArrayList<Room>();
				for(Entry<Room, Integer> e: rDist.entrySet())
				{
					Room cr = e.getKey();
					int dist = e.getValue();
					rooms.add(cr);
					System.out.println(i + " " + cr + " " + dist);
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
			    	Room g = new Room(scan.next(), null);
			    	Weapon gw = new Weapon(scan.next());
			    	Character gc = new Character(scan.next());
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
					if (n.hasWon()) { finished = true;}
			    	
			    }
					
					
					
				//end turn 
			}
		}
	}
	
	
		
	public static void main(String [ ] args)
	{
		Scanner scan = new Scanner(System.in);
		playGame(scan);
	}

}
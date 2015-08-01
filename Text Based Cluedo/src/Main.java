import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void playGame(Scanner scan)
	{
		int h = 25;
		int w = 25;
		int numP = 0;
		Boolean finished = false;
		//ask for how many players are playing
		
		numP = scan.nextInt();
		
		Board b = new Board(h, w, numP);
		ArrayList<Player> players = b.getPlayers();
		
		while(!finished)
		{
			
		//for each player
			for(Player p: players)
			{
				Room r = null;
				//calculate distances	
				p.calculateDistances();
				Map<Room, Integer> rDist = p.getRoomDist();
				int i = 0;
				//look at room distances map and print out each entry
				for(Entry<Room, Integer> e: rDist.entrySet())
				{
					Room cr = e.getKey();
					int dist = e.getValue();
					System.out.println(i + " " + cr + " " + dist);
					i++;
				}
					
				//roll dice
				int diceNum = p.rollDice();
				System.out.println("You rolled a " + diceNum);
				
				//give option for movement (dont have to)
				System.out.println("Where do you want to move to?");
				
				//update location
				//r = index chosen
				
				p.updateLocation(r);
				//make a guess option (suggestion, accusation OR nothing)
				//if(input == 1 || 2){ 1 = suggestion 2 = accusation, 3 = nothing
					
					//get cards from typed input on new line
					//create a guess hand
					//Guess n = new Guess(suggestion OR accusation bool, cards to guess, player);
					//if guess.Won == true { finished = true}
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
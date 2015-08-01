import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	public static void playGame()
	{
		int h = 25;
		int w = 25;
		int numP = 0;
		Boolean finished = false;
				
		Board b = new Board(h, w, numP);
		ArrayList<Player> players = b.getPlayers();
		
		while(!finished)
		{
		//for each player
			for(Player p: players)
			{
				Room r;
				//calculate distances	
				p.calculateDistances();
				//display distances
					//look at room distances map and print out each entry
					
				//roll dice
				p.rollDice();
				//give option for movement (dont have to)
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
		playGame();
	}

}
import java.util.ArrayList;
import java.util.Random;

public class Board {

	public ArrayList<Card> answer;
	public static ArrayList<Player> players;
	private int width, height;
	
	public Board(int width, int height, int numP) {
		this.answer = genAns();
		this.players = genPlayers(numP);
		this.width = width;
		this.height = height;
	}
	
	public ArrayList<Player> genPlayers(int numPlayers)
	{
		ArrayList<Player> players = new ArrayList<Player>();
		Random rand = new Random();
		int r1 = rand.nextInt(6);
		
		return players;
	}
	
	public ArrayList<Card> genAns()
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		
		return cards;
	}
}
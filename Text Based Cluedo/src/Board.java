import java.util.ArrayList;

public class Board {

	public ArrayList<Card> answer;
	public static ArrayList<Player> players;
	private int width, height;
	
	public Board(ArrayList<Card> answer, ArrayList<Player> players, int width, int height) {
		this.answer = answer;
		this.players = players;
		this.width = width;
		this.height = height;
	}
}
import java.util.ArrayList;

public class Main {
	
	public static void playGame()
	{
		int h = 25;
		int w = 25;
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<Card> answer = new ArrayList<Card>();
		Board b = new Board(answer, players, h, w);
	}
		
	public static void main(String [ ] args)
	{
		playGame();
	}

}
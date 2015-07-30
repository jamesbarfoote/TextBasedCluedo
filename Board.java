import java.util.List;

public class Board {

	public List<Card> answer;
	public static List<Player> players;
	private int width, height;
	
	public Board(List<Card> answer, List<Player> players, int width, int height) {
		this.answer = answer;
		this.players = players;
		this.width = width;
		this.height = height;
	}
}

public class Location {
	private Player player;
	private int x = 0;
	private int y = 0;

	public Location(Player p, int x, int y) {
		this.player = p;
		this.x = x;
		this.y = y;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Location l){
		if(l.getX() == this.getX() && l.getY() == this.getY()){
			return true;
		}
		return false;
	}
}
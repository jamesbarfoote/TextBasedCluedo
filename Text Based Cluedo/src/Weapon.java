
public class Weapon extends Card{

	private String[] weapons = {"Candlestick", "Dagger", "Revolver", "Rope", "Lead Pipe", "Spanner"};
	String name;
	
	public Weapon(String name){//The name for a weapon
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

public class Weapon extends Card{

	private String[] weapons = {"Candlestick", "Dagger", "Revolver", "Rope", "Lead Pipe", "Spanner"};
	String name;
	
	public Weapon(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
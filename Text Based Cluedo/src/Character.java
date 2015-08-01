
public class Character extends Card{

	private String[] characters = {"Miss Scarlett", "Colonel Mustard", "Mrs. White", "The Reverend Green", "Mrs. Peacock", "Professor Plum"};
	String name;
	
	public Character(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
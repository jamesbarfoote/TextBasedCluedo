
public abstract class Card {
	
	public boolean equals(Card card){
		if(card.getName().equals(this.getName())){
			return true;
		}
		return false;
	}

	private String getName() {
		if(this instanceof Room){
			Room room = (Room) this;
			return room.getName();
		}
		else if(this instanceof Weapon){
			Weapon weapon = (Weapon) this;
			return weapon.getName();
		}
		else if(this instanceof Character){
			Character character = (Character) this;
			return character.getName();
		}
		System.out.println("Returned name is null");
		return null;
	}
}
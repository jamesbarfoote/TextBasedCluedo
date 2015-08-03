
public class Room extends Card{
	private String name;
	private Location location;
	
	public Room(String name, Location location){
		this.name = name;
		this.location = location;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public String getName(){
		return name;
	}
}
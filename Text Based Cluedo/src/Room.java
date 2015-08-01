
public class Room extends Card{
	private String name;
	private Location location;
	//For evey elem in array
	//if count = 0 then loc = 4,4
	
	//private int width, height;
	
	public Room(String name, Location location){
		System.out.println("Location for " + name + " is " + location);
		this.name = name;
		this.location = location;
		
		//this.width = width;
		//this.height = height;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * Calculates whether or not the given location in within the bounds of the room.
	 * 
	 * @param Location
	 * @return Boolean
	 */
//	public boolean contains(Location l){
//		return false;	
//	}
//
//	public int getWidth() {
//		return width;
//	}
//
//	public int getHeight() {
//		return height;
//	}
}
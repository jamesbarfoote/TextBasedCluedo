
public class Room {

	private String[] rooms = {"Kitchen", "Ballroom", "Conservatory", "Billiard Room", "Library", "Study", "Hall", "Lounge", "Dining Room"};
	private String name;
	private int width, height;
	
	public Room(String name, int width, int height){
		this.name = name;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Calculates whether or not the given location in within the bounds of the room.
	 * 
	 * @param Location
	 * @Return Boolean
	 */
	public boolean contains(Location l){
		
	}
}
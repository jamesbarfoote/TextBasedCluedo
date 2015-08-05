import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
	private ArrayList<Card> discoveredCards = new ArrayList<Card>();
	private ArrayList<Card> hand = new ArrayList<Card>();
	private int roll;
	private Map<Room, Integer> roomDistances = new HashMap<Room, Integer>();
	private String name;
	private Location location;
	private int playerNum;

	public Player (String name, Location location, int playerNum){
		this.name = name;
		this.location = location;
		this.playerNum = playerNum;	
	}

	public int rollDice(){
		roll = ((int) Math.ceil(Math.random()*11)) + 1;
		
		return (roll);
	}
	
	public void addToHand(Card c){
		discoveredCards.add(c);
		hand.add(c);
	}
	
	public void addToHand2(Card c){
		discoveredCards.add(c);
	}

	/**
	 * Given a room the player wants to go to, calculates the new location.
	 * @param r - Target Room.
	 */
	public void updateLocation(Room r) throws IllegalStateException{
		int stepsRemaining = roll;
		int stepsTaken = 0;
		int distance = roomDistances.get(r);
		Location roomLocation = r.getLocation();
		while(stepsRemaining > 0 && stepsTaken < distance){			
			if(roomLocation.getX() < location.getX()){
				this.location.setX(location.getX()-1);
				stepsRemaining += -1;
				stepsTaken += 1;
			}
			else if(roomLocation.getX() > location.getX()){
				this.location.setX(location.getX()+1);
				stepsRemaining += -1;
				stepsTaken += 1;
			}
			else if(roomLocation.getY() < location.getY()){
				this.location.setY(location.getY()-1);
				stepsRemaining += -1;
				stepsTaken += 1;
			}
			else if(roomLocation.getY() > location.getY()){
				this.location.setY(location.getY()+1);
				stepsRemaining += -1;
				stepsTaken += 1;
			}
			else{
				throw new IllegalStateException("Cannot move to desired location or already there");
			}
		}
		Location[] stairwellLocations = {new Location(0,0), new Location(24, 0), new Location(24, 24), new Location(0, 24)};
		if(this.location.equals(stairwellLocations[0])){
			this.location = stairwellLocations[2];
		}
		else if(this.location.equals(stairwellLocations[1])){
			this.location = stairwellLocations[3];
		}
		else if(this.location.equals(stairwellLocations[2])){
			this.location = stairwellLocations[0];
		}
		else if(this.location.equals(stairwellLocations[3])){
			this.location = stairwellLocations[1];
		}
	}

	/**
	 * calculates the distances from the current location to all of the rooms.
	 * @param b - The current board
	 */
	public void calculateDistances(Board b){
		for(Room r : b.getRooms()){
			Location roomLocation = r.getLocation();
			int distance = Math.abs(roomLocation.getX() - location.getX()) + Math.abs(roomLocation.getY() - location.getY());
			roomDistances.put(r, distance);
		}
		for(Room r : b.getStairwells()){
			Location stairLocation = r.getLocation();
			int distance = Math.abs(stairLocation.getX() - location.getX()) + Math.abs(stairLocation.getY() - location.getY());
			roomDistances.put(r, distance);
		}
	}
	
	public Location getLocation(){
		return location;
	}

	public ArrayList<Card> getDiscoveredCards(){
		return discoveredCards;
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}

	public int getRoll(){
		return roll;
	}

	public Map<Room, Integer> getRoomDist(){
		return roomDistances;
	}
	
	public int getNum(){
		return playerNum;
	}
	
	public String getName(){
		return name;
	}
}
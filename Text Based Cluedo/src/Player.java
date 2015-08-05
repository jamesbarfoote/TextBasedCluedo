import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
	private ArrayList<Card> discoveredCards = new ArrayList<Card>();	//Acts as the paper each player ticks weapons, characters and rooms off of.
	private ArrayList<Card> hand = new ArrayList<Card>();				//The starting hand
	private int roll;
	private Map<Room, Integer> roomDistances = new HashMap<Room, Integer>();	//The distances from current location to all the rooms and stairwells
	private String name;
	private Location location;
	private int playerNum;

	public Player (String name, Location location, int playerNum){
		this.name = name;
		this.location = location;
		this.playerNum = playerNum;	
	}

	/**
	 * Rolls the dice
	 * @return int of the number rolled
	 */
	public int rollDice(){
		roll = ((int) Math.ceil(Math.random()*11)) + 1; // generate a random number between 2 and 12 inclusive
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
	 * @return boolean specifying whether the move was successful
	 */
	public boolean updateLocation(Room r) throws IllegalStateException{
		int stepsRemaining = roll;
		int stepsTaken = 0;
		int distance = roomDistances.get(r);
		Location roomLocation = r.getLocation();
		while(stepsRemaining > 0 && stepsTaken < distance){		//Go left or right, then up or down towards the desired location
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
				throw new IllegalStateException("Cannot move to desired");
			}
		}
		Location[] stairwellLocations = {new Location(0,0), new Location(24, 0), new Location(24, 24), new Location(0, 24), 
										 new Location(20, 19), new Location(6, 19), new Location(6, 4), new Location(20, 4)};
		if(this.location.equals(stairwellLocations[0])){	//If you reach a stairwell, change your location to the room opposite you
			this.location = stairwellLocations[4];
			System.out.println("You are now in the study");
			return true;
		}
		else if(this.location.equals(stairwellLocations[1])){
			this.location = stairwellLocations[5];
			System.out.println("You are now in the lounge");
			return true;
		}
		else if(this.location.equals(stairwellLocations[2])){
			this.location = stairwellLocations[6];
			System.out.println("You are now in the kitchen");
			return true;
		}
		else if(this.location.equals(stairwellLocations[3])){
			this.location = stairwellLocations[7];
			System.out.println("You are now in the conservatory");
			return true;
		}
		
		if(r.getLocation().equals(this.getLocation())){
			System.out.println("You are now in the " + r.getName());
			return true;
		}
		return false;
	}

	/**
	 * Calculates the distances from the current location to all of the rooms and stairwells
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
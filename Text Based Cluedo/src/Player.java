import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Player {
	private ArrayList<Card> hand = new ArrayList<Card>();
	private Location location;
	private int roll;
	private Map<Room, Integer> roomDistances = new HashMap<Room, Integer>();
	private int playerNum;

	public Player (Location location, int playerNum){
		this.location = location;
		this.playerNum = playerNum;
	}


	public void rollDice(){
		Random rand = new Random();
		roll = rand.nextInt(6);
		System.out.println(roll);
	}
	
	public void addToHand(Card c){
		hand.add(c);
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
	}

	/**
	 * calculates the distances from the current location to all of the rooms.
	 */
	public void calculateDistances(){
		for(Room r : roomDistances.keySet()){
			Location roomLocation = r.getLocation();
			int distance = Math.abs(roomLocation.getX() - location.getX()) + Math.abs(roomLocation.getY() - location.getY());
			roomDistances.put(r, distance);
		}
	}
	
	public Location getLocation(){
		return location;
	}

	public ArrayList<Card> getCards(){
		return hand;
	}

	public int getRoll(){
		return roll;
	}

	public Map<Room, Integer> getRoomDist(){
		return roomDistances;
	}
	
	public int getNum()
	{
		return playerNum;
	}
}
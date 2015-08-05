import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	private static boolean finished = false;

	public static void createGame(Scanner scan) {
		System.out.println("Welcome to Cluedo!");

		// ask for how many players are playing
		System.out.println("How many players?  (2-6)");
		String numP = scan.next();
		int numPlayers = 0;
		
		numPlayers = isCorrectNumber(scan, 2, 6, numP);
		
		Board b = new Board(numPlayers);

		int playerNum = 0;

		playGame(scan, b, playerNum);
	}

	/**
	 * Loop through all the players while the game hasn't been won. If a player
	 * gets eliminated, break the loop then remove the player and start the loop
	 * again from where it left off.
	 * 
	 * @param players
	 * @param scan
	 * @param b
	 * @param playerNum
	 *            - the player before the current
	 */
	public static void playGame(Scanner scan, Board b, int playerNum) {

		playerNum = (playerNum % b.getPlayers().size()) + 1;
		Player currentPlayer = b.getPlayers().get(playerNum - 1);
		Player eliminatedPlayer = null;
		while (finished == false) {	
			System.out.println("--------------- Player " + playerNum + " ---------------------");
			System.out.println("");
			System.out.println("You are " + currentPlayer.getName());
			System.out.println();
			Room r = null;
			// calculate distances
			currentPlayer.calculateDistances(b);
			// System.out.println("Calculated distances");

			Map<Room, Integer> rDist = currentPlayer.getRoomDist();
			int i = 1;
			// look at room distances map and print out each entry
			ArrayList<Room> rooms = new ArrayList<Room>();
			// System.out.println("rDist size = " + rDist.size());
			System.out.println("");
			System.out.println("Type the number of the room you wish to move towards");
			for (Entry<Room, Integer> e : rDist.entrySet()) {
				Room cr = e.getKey();
				int dist = e.getValue();
				rooms.add(cr);

				System.out.printf("%2s. %22s - Distance = %-100s \n",  i, cr.getName(),dist);
				i++;
			}

			// roll dice
			int diceNum = currentPlayer.rollDice();
			System.out.println("");
			System.out.println("You rolled " + diceNum);

			// give option for movement (dont have to)
			System.out.println("Where do you want to move to?");
			String numC = scan.next();
			int numChoice = 0;
			
			numChoice = isCorrectNumber(scan, 1, 13, numC);

			// update location
			r = rooms.get(numChoice-1);
			currentPlayer.updateLocation(r);
			scan.useDelimiter(System.getProperty("line.separator"));
			// make a guess option (suggestion, accusation OR nothing)
			System.out.println("What would you like to do?");

			int distToRoom = rDist.get(r);
			if (distToRoom > diceNum) {
				System.out.println("1 - Accusation");
				System.out.println("2 - Nothing");
				String stringOption = scan.next();
				int option = 0;
				
				option = isCorrectNumber(scan, 1, 2, stringOption);

				if (option == 1) {

					System.out.println("Please type the 3 cards that you are guessing on a new line");
					System.out.println("In this order: Room, Weapon, Character");
					// get cards from typed input on new line
					
					ArrayList<Card> guessHand = createGuess(scan, b);//Create the guess hand
					while (guessHand == null) {
						guessHand = createGuess(scan, b);
					}
					boolean opt = false;//Accusation

					Guess guess = new Guess(opt, guessHand, currentPlayer);

					if (guess.getEliminatedPlayer() != null) {
						eliminatedPlayer = guess.getEliminatedPlayer(); //Set the player to be eliminated 
						System.out.println("You guessed wrong");
						System.out.println("You have been eliminated!");
						
						if(b.getPlayers().size() == 2)//If there is no one left in the game exit
						{
							System.out.println("");
							System.out.println("Game over! No one guessed correctly");
						}
						
						break;//Break out
					} else if (guess.hasWon()) {
						finished = true;
						System.out.println("Congratulations " + currentPlayer.getName() + " you have won!");
						return;
					}

				}

			} else {

				System.out.println("1 - Suggestion");
				System.out.println("2 - Accusation");
				System.out.println("3 - Nothing");
				String stringOption = scan.next();
				int option = 0;
				
				option = isCorrectNumber(scan, 1,  3, stringOption);
				if (option == 1 || option == 2) {

					// get cards from typed input on new line

					Guess guess = null;
					do{
						System.out.println("Please type the 3 cards that you are guessing on a new line");
						System.out.println("In this order: Room, Weapon, Character");
						
						ArrayList<Card> guessHand = createGuess(scan, b);
						while (guessHand == null) {
							guessHand = createGuess(scan, b);
						}

						// create a guess hand
						boolean opt = false;
						if (option == 1) {
							opt = true;
						}

						guess = new Guess(opt, guessHand, currentPlayer);
					}while(guess.getFailed() == true);

					if (guess.getEliminatedPlayer() != null) {
						eliminatedPlayer = guess.getEliminatedPlayer();
						System.out.println("You guessed wrong");
						System.out.println("You have been eliminated!");
						
						if(b.getPlayers().size() == 2)//If there is no one left in the game exit
						{
							System.out.println("Game over! No one guessed correctly");
						}
						
						break;
					} else if (guess.hasWon()) {
						finished = true;
						System.out.println("Congratulations " + currentPlayer.getName() + " you have won!");
						return;
					}

				}
			}
			playerNum = (playerNum % b.getPlayers().size()) + 1;
			currentPlayer = b.getPlayers().get(playerNum - 1);
		}

		playerNum = (playerNum % Board.players.size()) - 1;
		Board.players.remove(eliminatedPlayer);
		while (b.getPlayers().size() > 1) {
			playGame(scan, b, playerNum);
		}
	}

	private static ArrayList<Card> createGuess(Scanner scan, Board b) {
		String roomName = scan.next();
		int index = b.getRoomNames().indexOf(roomName);
		Room guessRoom = null;
		if (index != -1) {
			guessRoom = b.getRooms().get(index);
		} else {
			System.out.println("Room name was incorrect, please type the 3 cards again");
			return null;
		}

		int indexW = b.getWeaponNames().indexOf(scan.next());
		Weapon guessWeapon = null;
		if (indexW != -1) {
			guessWeapon = b.getWeapons().get(indexW);
		} else {
			System.out.println("Weapon name was incorrect, please type the 3 cards again");
			return null;
		}

		String characterN = scan.next();
		int indexC = b.getCharacterNames().indexOf(characterN);
		Character guessCharacter = null;
		if (indexC != -1) {
			guessCharacter = b.getCharacters().get(indexC);
		} else {
			System.out.println("Character name was incorrect, please type the 3 cards again");
			return null;
		}

		ArrayList<Card> guessHand = new ArrayList<Card>();
		guessHand.add(guessRoom);
		guessHand.add(guessWeapon);
		guessHand.add(guessCharacter);

		return guessHand;

	}
	
	private static boolean isInteger(String s) {
		  try { 
		      Integer.parseInt(s); 
		   } catch(NumberFormatException e) { 
		      return false; 
		   }
		   // only got here if we didn't return false
		   return true;
		}
	
	private static int isCorrectNumber(Scanner scan, int minNum, int maxNum, String numP){
		int numPlayers = 0;
		while(true){
			if(isInteger(numP)){
				numPlayers = Integer.parseInt(numP); 
				if((numPlayers >= minNum) && (numPlayers<=maxNum)){
					break;
				}
			}
			System.out.println("Input must be between " +  minNum + " and " + maxNum);
			numP = scan.next();
		}
		return numPlayers;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		createGame(scan);
	}

}
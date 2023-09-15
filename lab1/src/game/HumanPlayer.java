package game;

public class HumanPlayer extends Player {

	public HumanPlayer(String userId) {
		super(userId);
	}

	public int takePins(Board board) {
		// reduces noPins by 1 or 2

		int pinsToTake = UserInterface.askForInt("Human - how many pins do you want to take?:");
		//int pinsToTake = scanner.nextInt();
		
		//kan ändra till while loop

		if (pinsToTake == 1 || pinsToTake == 2) {
			board.takePins(pinsToTake);
					
		} else {
			UserInterface.printMessage("You can only take 1 or 2 pins. Try again...");
			takePins(board); // recursive until correct input
		}
		
		return pinsToTake;

	}
}

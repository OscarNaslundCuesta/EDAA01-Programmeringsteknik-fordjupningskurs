package game;

import java.util.Random;

public class SmartComputerPlayer extends Player {
	Random random = new Random();
	
	public SmartComputerPlayer(String userId) {
		super(userId);
	}

	public int takePins(Board board) {
		// complicated AI-strategy
		if (board.noPins % 3 == 1) {
			board.takePins(1);
			return 1;
		}
		
		else if (board.noPins % 3 == 2) {
			board.takePins(2);
			return 2;
			}
		
		else {
			// hope is lost
			int randomNum = random.nextInt(2) + 1;
			board.takePins(randomNum);
			return randomNum;
		}
	}
}

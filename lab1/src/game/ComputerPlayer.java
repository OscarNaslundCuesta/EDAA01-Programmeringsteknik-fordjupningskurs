package game;

import java.util.Random;

public class ComputerPlayer extends Player {
	Random random = new Random();
	
	public ComputerPlayer(String userId) {
		super(userId);
	}

	public int takePins(Board board) {
		int randomNum = random.nextInt(2) + 1;
		board.takePins(randomNum);
		return randomNum;
	}
}

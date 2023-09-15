package game;

import java.util.Random;

import javax.swing.JOptionPane;

public class TakePinsGame {
	
	public static String lastTaker;

	public static void main(String[] args) {
		
		Board board = new Board(); // Create a new board obj
		Player human = new HumanPlayer("HumanPlayer"); // Create new player obj
		//Player computer = new SmartComputerPlayer("ComputerPlayer"); // Create new computer obj
		Player computer = new SmartComputerPlayer("ComputerPlayer"); // Create new smart computer obj
		
		UserInterface.printMessage("A game is starting with " + board.initialPins +  " pins!");
		
		while (board.noPins > 0) {
			UserInterface.printMessage("Human took " + human.takePins(board) +  " pins.");
			UserInterface.printMessage("There are " + board.noPins +  " left.");
			
			if (board.noPins <= 0) {
				UserInterface.printMessage("Human wins!");
				return;
			}
			
			UserInterface.printMessage("Computer took " + computer.takePins(board) +  " pins.");

			if (board.noPins <= 0) {
				UserInterface.printMessage("Computer wins!");
				return;
			}
			
			UserInterface.printMessage("There are " + board.noPins +  " left.");
		}
		
	}

}

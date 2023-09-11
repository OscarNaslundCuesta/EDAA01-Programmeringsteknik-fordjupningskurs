package game;

import java.util.Random;

public class Board {
	Random random = new Random();

	public int noPins; // number of pins
	public int initialPins; // num of pins the game started with

	public Board() {
		// Initialize board with a random number of pins between 1 and 20.
		this.initialPins = random.nextInt(20) + 1;
		setUp(this.initialPins);
	}

	public void setUp(int initialPins) {
		// This method sets up the initial number of pins
		noPins = initialPins;
	}

	public void takePins(int pinsToTake) {
		// This method reduces the noPins by 1 or 2
		noPins -= pinsToTake;
	}

	public int getNoPins() {
		// This method returns the current number of pins.
		return noPins;
	}
}

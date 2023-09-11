package game;

import javax.swing.JOptionPane;

public class UserInterface {
	/** Visar en dialogruta med texten msg. */
	public static void printMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	/**
	 * Visar en dialogruta med texten msg och och läser in ett positivt heltal. Om
	 * användaren skriver något som inte kan tolkas som ett positivt heltal ska -1
	 * returneras. Om användaren klickar på "Avbryt" ska -2 returneras.
	 */

	public static int askForInt(String msg) {

		String input = JOptionPane.showInputDialog("Enter a number:");

		if (input == null) {
            return -2;
        }

        try {
            int number = Integer.parseInt(input);
            if (number == 1 || number == 2) {
                return number; // return user input 1 or 2
            }
        } catch (NumberFormatException e) {
            // not an int
        }

        return -1; // non positive ints or inavlid inputs
    }
	}

	


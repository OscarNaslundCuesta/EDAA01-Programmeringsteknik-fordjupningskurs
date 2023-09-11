package game;

import java.util.Scanner;


public abstract class Player {
	
    private String userId;


	protected Player(String str) {
		userId = str;
        //System.out.println("Your userId was set to: " + this.userId);
	}
	
//	protected String generateUserId() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What is your name?: ");
//        String inputUserId = scanner.next();
//        scanner.close();
//        return inputUserId;
//    }
	
	public String getUserId() {
    	//System.out.println("getUserId() returning userId = " + this.userId);
        return this.userId;
    }
	
	public abstract int takePins(Board board);

}



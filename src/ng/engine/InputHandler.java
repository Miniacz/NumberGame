package ng.engine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

	static int userNumberInput = 0;

	public int getUserNumberInput() {
		return userNumberInput;
	}

	private void setUserNumberInput(int userNumberInput) {
		InputHandler.userNumberInput = userNumberInput;
	}
	
	public void collectUserInput() {
		
		//correct input switch
		boolean correctInput = false;
		
			while(!correctInput) {
				try {
					Scanner inputScanner = new Scanner(System.in);
					this.setUserNumberInput(inputScanner.nextInt());
					correctInput = true;
				} catch (InputMismatchException e) {
					System.out.println("Use valid numbers - from 0 to 9. Other characters are not permitted.");
				}
			}
			
	}
}

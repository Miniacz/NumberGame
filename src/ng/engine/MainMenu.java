package ng.engine;

import java.io.IOException;

public class MainMenu {

	static boolean runMainMenu = true;
	static boolean runGUI = true;
	static byte cursor = 1;

	String indicator = "[<]";
	
	KeyboardListener keyListener = new KeyboardListener();
	ListHandler listManager = new ListHandler();
	InputHandler inputManager = new InputHandler();

	public void initializeMainMenu() throws IOException, InterruptedException {
		
		// key listener for MainMenu
		keyListener.listenMainMenu();
		
		while(runMainMenu) {
			
			// print menu
			for (int i = 1; i == 1; i++) {
				this.printMainMenu(cursor);
			}
			
			// screen refresh for variable change
			Thread.sleep(50);
			
			// screen clearing
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			
		}
		
		// exit by confirm with enter
		if (cursor == 2 && runMainMenu == false) {
			System.exit(0); 
		} else if (cursor == 1 && runMainMenu == false) {
			this.initializeGameMenu();
		}
		
		
	}
	
	public void printMainMenu(int option) {
		
		switch (option) {
		
		case 1:
			System.out.println("=== NUMBER GAME === \n");
			System.out.println("Use [up] & [down] arrow keys to navigate. \nConfirm with [enter], terminate program with [escape] key.\n");
			System.out.printf("1. Start Game %5s", indicator + "\n");
			System.out.println("2. Exit ");
			break;
			
		case 2:
			System.out.println("=== NUMBER GAME === \n");
			System.out.println("Use [up] & [down] arrow keys to navigate. \nConfirm with [enter], terminate program with [escape] key.\n");
			System.out.println("1. Start Game ");
			System.out.printf("2. Exit %11s", indicator + "\n");
			break;
		}
	}

	public void initializeGameMenu() throws IOException, InterruptedException {
		
		keyListener.listenGameMenu();
		
		// screen clearing
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				
		System.out.println("How long list would You like to sort? Enter a number below 20, using digitals and confirm with [enter] key.");
		
		// get user input
		inputManager.collectUserInput();
		
		// create list of desired length
		ListHandler.fillRefList(inputManager.getUserNumberInput());
		
		// screen clearing
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
		this.printGameInterface();

	}
	
	public void printGameInterface() throws IOException, InterruptedException {
		
		while (runGUI) {
			// screen clearing
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			
			System.out.println("=== NUMBER GAME === \n");
			System.out.println("Use [left] & [right] arrow keys to navigate the cursor (dot). \nIncrement number's place by 1 with [up] & [down] arrow keys. \nTerminate program with [escape] key.\n");
			
			System.out.println("\n\nReference list:\n");
			listManager.printList();
			System.out.println("\n\nUser list:\n");
			listManager.printUserList();
			
			if (listManager.compareLists()) {
				System.out.println("\n\nLists are equal!");
			} else {
				System.out.println("\n\nLists are not equal!");
				System.out.println("\nEquality points:" + listManager.equalityPoints);
			}
				
			// screen refresh for variable change
			Thread.sleep(50);
		}
		
		
	}
}

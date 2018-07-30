import java.io.IOException;
import ng.engine.*;

public class NumberGameMain {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// for Clearing console
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

		MainMenu menuInstance = new MainMenu();
		menuInstance.initializeMainMenu();
		
	}

}

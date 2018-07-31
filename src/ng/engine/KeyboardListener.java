package ng.engine;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class KeyboardListener {

	public void listenMainMenu() {
		// start listening object
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);
		
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override public void keyPressed(GlobalKeyEvent event) {
				
					switch (event.getVirtualKeyCode()) {
						case GlobalKeyEvent.VK_UP: 		MainMenu.cursor = 1;
							break;
														
						case GlobalKeyEvent.VK_DOWN:	MainMenu.cursor = 2;			
							break;
							
						case GlobalKeyEvent.VK_RETURN:	MainMenu.runMainMenu = false;
							break;
							
						case GlobalKeyEvent.VK_ESCAPE:	System.exit(0);
							break;
					}
				
			}
		});
	}
	
	public void listenGameMenu() {
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);
		
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override public void keyPressed(GlobalKeyEvent event) {
				
					switch (event.getVirtualKeyCode()) {
						case GlobalKeyEvent.VK_UP: 
								
								if (MainMenu.listIndicator == ListHandler.userList.size()-1) {
									MainMenu.listValueContainer = MainMenu.listIndicator;
									MainMenu.listValueBackupContainer = 0;
								} else {
									MainMenu.listValueContainer = ListHandler.userList.get(MainMenu.listIndicator);
									MainMenu.listValueBackupContainer = ListHandler.userList.get(MainMenu.listIndicator+1);
									ListHandler.userList.set(MainMenu.listIndicator+1, MainMenu.listValueContainer);
									ListHandler.userList.set(MainMenu.listIndicator, MainMenu.listValueBackupContainer);
									MainMenu.listIndicator+=1;
								}
								
							break;
														
						case GlobalKeyEvent.VK_DOWN:
									
							if (MainMenu.listIndicator == 0) {
								MainMenu.listValueContainer = MainMenu.listIndicator;
								MainMenu.listValueBackupContainer = 0;
							} else {
								MainMenu.listValueContainer = ListHandler.userList.get(MainMenu.listIndicator);
								MainMenu.listValueBackupContainer = ListHandler.userList.get(MainMenu.listIndicator-1);
								ListHandler.userList.set(MainMenu.listIndicator-1, MainMenu.listValueContainer);
								ListHandler.userList.set(MainMenu.listIndicator, MainMenu.listValueBackupContainer);
								MainMenu.listIndicator-=1;
							}
							
							break;
							
						case GlobalKeyEvent.VK_LEFT:	
							
								if (MainMenu.listIndicator == 0) {
									MainMenu.listIndicator = 0;
								} else {
									MainMenu.listIndicator-=1;
								}
														
							break;
							
						case GlobalKeyEvent.VK_RIGHT:
							
								if (MainMenu.listIndicator == ListHandler.userList.size()-1) {
									MainMenu.listIndicator = ListHandler.userList.size()-1;
								} else {
									MainMenu.listIndicator+=1;
								}
							
							break;
							
						case GlobalKeyEvent.VK_ESCAPE:	System.exit(0);

							break;
					}
				
			}
		});
	}
}

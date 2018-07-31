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
								
								if (ListHandler.listIndicator == ListHandler.userList.size()-1) {
									ListHandler.listValueContainer = ListHandler.listIndicator;
									ListHandler.listValueBackupContainer = 0;
								} else {
									ListHandler.listValueContainer = ListHandler.userList.get(ListHandler.listIndicator);
									ListHandler.listValueBackupContainer = ListHandler.userList.get(ListHandler.listIndicator+1);
									ListHandler.userList.set(ListHandler.listIndicator+1, ListHandler.listValueContainer);
									ListHandler.userList.set(ListHandler.listIndicator, ListHandler.listValueBackupContainer);
									ListHandler.listIndicator+=1;
								}
								
							break;
														
						case GlobalKeyEvent.VK_DOWN:
									
							if (ListHandler.listIndicator == 0) {
								ListHandler.listValueContainer = ListHandler.listIndicator;
								ListHandler.listValueBackupContainer = 0;
							} else {
								ListHandler.listValueContainer = ListHandler.userList.get(ListHandler.listIndicator);
								ListHandler.listValueBackupContainer = ListHandler.userList.get(ListHandler.listIndicator-1);
								ListHandler.userList.set(ListHandler.listIndicator-1, ListHandler.listValueContainer);
								ListHandler.userList.set(ListHandler.listIndicator, ListHandler.listValueBackupContainer);
								ListHandler.listIndicator-=1;
							}
							
							break;
							
						case GlobalKeyEvent.VK_LEFT:	
							
								if (ListHandler.listIndicator == 0) {
									ListHandler.listIndicator = 0;
								} else {
									ListHandler.listIndicator-=1;
								}
														
							break;
							
						case GlobalKeyEvent.VK_RIGHT:
							
								if (ListHandler.listIndicator == ListHandler.userList.size()-1) {
									ListHandler.listIndicator = ListHandler.userList.size()-1;
								} else {
									ListHandler.listIndicator+=1;
								}
							
							break;
							
						case GlobalKeyEvent.VK_ESCAPE:	System.exit(0);

							break;
					}
				
			}
		});
	}
}

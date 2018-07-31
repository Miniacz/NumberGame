package ng.engine;

import java.util.LinkedList;
import java.util.Collections;

public class ListHandler {
	
	static LinkedList<Integer> refList = new LinkedList<Integer>();
	static LinkedList<Integer> userList = new LinkedList<Integer>();
	int equalityPoints = 0;
	
	public ListHandler() {
		ListHandler.fillRefList(100);
	}
	
	static void fillRefList(int length) {
		
		// to clear any previous content
		
		refList.clear(); 
		userList.clear(); 
		
		for(int i = 0; i < length; i++) {
			refList.add(i,i);
			userList.add(i,i);
		}
		
		Collections.shuffle(userList); // shuffle the user list ONCE
		
	}
   
	public void printList() {
		
		for(int i = 0; i < refList.size(); i++) {
			System.out.print(refList.get(i) + " ");
		}
	}
	
	
	public void printUserList() {
		
		for(int i = 0; i < userList.size(); i++) {
			if (MainMenu.listIndicator == i) {
				System.out.print(userList.get(i) + ". ");
			} else {
				System.out.print(userList.get(i) + " ");
			}
			
		}
		
//		System.out.println("\n\n" + "MainMenu.listIndicator:"+ MainMenu.listIndicator);
//		System.out.println("\n" + "MainMenu.listValueContainer:" + MainMenu.listValueContainer);
//		System.out.println("\n" + "MainMenu.listValueBackupContainer:" + MainMenu.listValueBackupContainer);
	}
	
	public boolean compareLists() {
		boolean listsAreEqual = false;
		equalityPoints = 0;

		// search for equal elements in both lists
		for (int i = 0; i < refList.size(); i++) {
			if (userList.get(i).equals(refList.get(i))) {
				equalityPoints+=1;
			} else {
				equalityPoints-=1;
			}
		}
		
		// check if both lists are equal
		if (equalityPoints == refList.size()) {
			listsAreEqual = true;
		}
		
		return listsAreEqual;
	}
	
}

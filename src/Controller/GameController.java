package Controller;

import View.MainFrame;
import Model.FighterStatus;
import Model.ActionPanel;
import Model.BodyPart;

public class GameController {
	
	private String[] enumOne;
	
	private String[] enumTwo;
	
	
	public void handleAction(BodyPart, Fighter) {
		enumOne = BodyPart + Fighter;
	}
	
	public void swap() {
		
	}
	
	
	public String[] getEnumOne() {
		return enumOne;
	}

	public void setEnumOne(String[] enumOne) {
		this.enumOne = enumOne;
	}

	public String[] getEnumTwo() {
		return enumTwo;
	}


	public void setEnumTwo(String[] enumTwo) {
		this.enumTwo = enumTwo;
	}

	


}

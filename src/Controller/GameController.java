package Controller;

import View.MainFrame;
import Model.FighterStatus;
import Model.ActionPanel;
import Model.BodyPart;
import Model.Fighter;

public class GameController {
	
	private String[] enumListOne;
	
	private String[] enumListTwo;
	
	private boolean checkEnum = true;
	
	
	public void handleAction(BodyPart, Fighter) {
		if (checkEnum = true) {
			enumListOne = BodyPart + Fighter;
			checkEnum = false;
		}
		else {
			enumListTwo = BodyPart + Fighter;
			checkEnum = true;
			attack(enumListOne, enumListTwo);
			analyzeHP();
			if (FighterStatus.isDeadLeft = true){
//				showVictoryPopUpRight;
			}
			else if (FighterStatus.isDeadRight = true){
//				showVictoryPopUpLeft;			
			}
			else {
				swap();
			};
		}
	} 
	
	public void swapButtons() {
		
	}
	
	public void analyzeHP() {
		if (String.equals(enumOne[1], Fighter.LEFT)){
	        JProgressBar.left = FighterStatus.healthLeft;
	        }
	     else {
	        JProgressBar.right = FighterStatus.healthRight;
	     }
		
	}
	
	
	public String[] getEnumListOne() {
		return enumListOne;
	}

	public void setEnumOne(String[] enumListOne) {
		this.enumListOne = enumListOne;
	}

	public String[] getEnumTwo() {
		return enumListTwo;
	}


	public void setEnumTwo(String[] enumListTwo) {
		this.enumListTwo = enumListTwo;
	}

	


}

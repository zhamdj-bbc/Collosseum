package Controller;

import View.MainFrame;
import View.MainFrame.State;
import Model.Battle;
import Model.EnumBodyPart;
import Model.EnumFighter;
import Model.Fighter;

public class GameController {

	private Fighter leftFighter;
	private Fighter rightFighter;
	private Battle battle;
	private MainFrame mainFrame;

	public GameController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		leftFighter = new Fighter();
		rightFighter = new Fighter();
	}

	public void startBattle(EnumFighter firstFighter) {
		
		EnumFighter opponent;
		if (firstFighter == EnumFighter.LEFT)
		{
			opponent = EnumFighter.RIGHT;
		}
		else
		{
			opponent = EnumFighter.LEFT;
		}
		
		battle = new Battle(opponent);
	}

	public void setAttack(EnumBodyPart bodyPart) {
		battle.setAttackBodyPart(bodyPart);
	}

	public void setDefense(EnumBodyPart bodyPart) {
		battle.setDefenseBodyPart(bodyPart);
	}

	public void handleBattle() {
		if (!battle.isReadyForRumble()) {
			throw new RuntimeException("Battle is not ready for attack");
		}
		if (battle.getOpponent() == EnumFighter.LEFT) {
			leftFighter.getAttacked(battle);
		} else {
			rightFighter.getAttacked(battle);
		}
	}

	public EnumFighter getCurrentFighter() {
		if (battle.getOpponent() == EnumFighter.LEFT) {
			return EnumFighter.RIGHT;
		} else {
			return EnumFighter.LEFT;
		}
	}
	
	public int getHealthFromLeftFighter() {
		return leftFighter.getHealth();
	}
	
	public int getHealthFromRightFighter() {
		return rightFighter.getHealth();
	}
}

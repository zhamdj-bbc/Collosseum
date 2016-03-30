package Model;

public class Battle {

	private EnumBodyPart attackBodyPart;
	private EnumBodyPart defenseBodyPart;
	private EnumFighter opponent;

	public Battle(EnumFighter opponent) {
		this.opponent = opponent;
	}

	public void setAttackBodyPart(EnumBodyPart attackBodyPart) {
		this.attackBodyPart = attackBodyPart;
	}

	public void setDefenseBodyPart(EnumBodyPart defenseBodyPart) {
		this.defenseBodyPart = defenseBodyPart;
	}

	public boolean isFullDamage() {
		return !(attackBodyPart == defenseBodyPart);
	}

	public boolean isReadyForRumble() {
		return attackBodyPart != null && defenseBodyPart != null;
	}

	public EnumFighter getOpponent() {
		return this.opponent;
	}
}

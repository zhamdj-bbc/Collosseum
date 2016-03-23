package Model;

import Controller.GameController;

public class FighterStatus{
	
	private String name1 = "Gian";
	private String name2 = "Jamil";
	private String name3 = "Giamil";
	
	private int healthLeft = 30;
	private int healthRight = 30;
	
	private int crit = 5;
	private int hit = 1;
	
	private boolean isDeadLeft = false;
	private boolean isDeadRight = false;
	
	
	public void attack() {
		if (String.equals(enumListOne[0], enumListTwo[0])){
			lessDamage();
		}
		else {
			fullDamage();
		}
    }
	
	public void fullDamage() {
		if (String.equals(enumOne[1], Fighter.LEFT)){
			healthRight -= crit;
	        if(healthRight <= 0) {
	            isDeadRight = true;
	        }
	     else {
	         healthLeft -= crit;
	         if(healthLeft <= 0) {
		            isDeadLeft = true;
	        }	
		}
    }
	
	public void lessDamage() {
		if (String.equals(enumOne[1], Fighter.LEFT)){
			healthRight -= hit;
	        if(healthRight <= 0) {
	            isDeadRight = true;
	        }
	     else {
	         healthLeft -= hit;
	         if(healthLeft <= 0) {
		            isDeadLeft = true;
	        }	
		}
    }

	public int getCrit() {
		return crit;
	}

	public void setCrit(int crit) {
		this.crit = crit;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	

	public int getHealthLeft() {
		return healthLeft;
	}

	public void setHealthLeft(int healthLeft) {
		this.healthLeft = healthLeft;
	}

	public int getHealthRight() {
		return healthRight;
	}

	public void setHealthRight(int healthRight) {
		this.healthRight = healthRight;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	
	
	
	
}

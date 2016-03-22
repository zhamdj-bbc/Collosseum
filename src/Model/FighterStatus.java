package Model;

public class FighterStatus {
	
	private String name;
	private int health = 30;
	private int crit = 5;
	private int hit = 1;
	private String image;
	private boolean isDead = false;
	
	
	
	public void attack(FighterStatus one) {
//       if( one.defend(true) ) {
//    	   one.lessDamage(hit);
//       }
//       else {
//    	   one.fullDamage(crit);
//       }
    }
	
	public void defend(FighterStatus one){
		// if Attack BodyPart = Defend BodyPart
		// return true;
	}
	
	public void fullDamage(int strenght) {
        if(health - crit <= 0) {
            isDead = true;
        }
        else {
            health -= crit;
        }
    }
	
	public void lessDamage(int strenght) {
        if(health - hit <= 0) {
            isDead = true;
        }
        else {
            health -= hit;
        }
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	
	
	
	
}

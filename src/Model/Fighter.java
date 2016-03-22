package Model;

public class Fighter {
	
	private String name;
	private int health = 30;
	private int crit = 5;
	private int hit = 1;
	private String image;
	private boolean isDead = false;
	
	
	
	public void attack(Fighter one) {
       if( one.defend(true) ) {
    	   one.lessDamage(hit);
       }
       else {
    	   one.fullDamage(crit);
       }
    }
	
	public void defend(Fighter one){
		// Defend button = Attack Button
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
	
	
	
}

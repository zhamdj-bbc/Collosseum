package Model;

public class Fighter {
		
	private int health = 50;
	private int normalPunch = 5;
	private int weakPunch = 1;
	
	public void getAttacked(Battle battle) {
		if (battle.isFullDamage()){
			health -= normalPunch;
		}
		else {
			health -= weakPunch;
		}
    }
	
	public boolean isDead()
	{
		return health <= 0;
	}

	public int getHealth() {
		return health;
	}
}

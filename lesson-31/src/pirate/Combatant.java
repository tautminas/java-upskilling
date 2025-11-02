package pirate;

import java.util.*;

public abstract sealed class Combatant implements Player permits Pirate, Islander, Soldier {
	protected final String name;
	protected Weapon currentWeapon = Weapon.KNIFE;
	protected final Map<String, Object> gameData = new HashMap<>();
	protected int health = 10;
	protected int score = 0;
	protected int level = 1;
	protected Set<String> townsVisited = new HashSet<>();

	protected Combatant(String name) {
		this.name = name;
	}

	protected Combatant(String name, Map<String, Object> initialData) {
		this.name = name;
		if (initialData != null) this.gameData.putAll(initialData);
	}

	public String name() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public void levelUp() {
		level++;
		System.out.println(name + " leveled up to " + level + "!");
	}

	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}

	public void setCurrentWeapon(Weapon weapon) {
		this.currentWeapon = weapon;
	}

	public void visitTown(String town) {
		townsVisited.add(town);
		System.out.println(name + " visited " + town + "!");
	}

	public int getHealth() {
		return health;
	}

	public void adjustHealth(int delta) {
		health += delta;
		System.out.println(name + " health adjusted by " + delta + ". Now: " + health);
	}

	public void addScore(int points) {
		score += points;
		System.out.println(name + " gained " + points + " points. Score: " + score);
	}

	public boolean useWeapon(Combatant target) {
		Random rnd = new Random();
		double hitChance = 0.7;
		boolean hit = rnd.nextDouble() < hitChance;
		if (hit) {
			int damage = currentWeapon.getHitPoints();
			target.adjustHealth(-damage);
			System.out.println(name + " hit " + target.name + " with " + currentWeapon + " for " + damage + " damage.");
		} else {
			System.out.println(name + " missed " + target.name + " with " + currentWeapon + ".");
		}
		return hit;
	}

	public Map<String, Object> getGameData() {
		return gameData;
	}
}

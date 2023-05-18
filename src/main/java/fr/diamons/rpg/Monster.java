package fr.diamons.rpg;

public class Monster {
    private final String name;
    private final int maxHealth;
    private int health;
    private final int attack;
    private final int level;

    public Monster(String name, int health, int attack, int level) {
        this.name = name;
        this.maxHealth = health;
        this.health = health;
        this.attack = attack;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    public void addDamage(int damage) {
        this.health -= damage;

        System.out.println("\nYou dealt " + damage + " damage!");
        System.out.println("The monster has " + this.health + "/" + this.maxHealth + " health left.");
    }

    public int getLevel() {
        return this.level;
    }
}

package fr.diamons.rpg;

public class Entity {
    public final String name;

    public final int maxHealth;

    public int health;

    public final int attack;

    public final int level;

    public Entity(String name, int health, int attack, int level) {
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
        System.out.println("\n" + this.name + " took " + damage + " damage!");
        System.out.println(this.name + " has " + this.health + "/" + this.maxHealth + " health left.");
    }

    public int getLevel() {
        return this.level;
    }

    public void addToHealth(int value) {
        this.health += value;
    }

    public void dealDamage(Entity entity) {
        entity.addDamage(this.attack);
    }
}

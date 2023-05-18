package fr.diamons.rpg;

public class Food extends Item {
    private final int health;

    public Food(String name, int health) {
        super(name);
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }
}

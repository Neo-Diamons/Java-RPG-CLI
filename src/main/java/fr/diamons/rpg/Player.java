package fr.diamons.rpg;

public class Player {
    private final String name;
    private final int maxHealth;
    private int health;
    private int attack;
    private int level;
    private final Inventory inventory = new Inventory();

    public Player(String name, int maxHealth, int attack, int level) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getLevel() {
        return this.level;
    }

    public void addToHealth(int value) {
        this.health += value;
    }

    public void addToLevel(int value) {
        this.level += value;
        this.attack = (int)Math.log(Math.abs(value)) * 10;
    }

    public void addToInventory(Item item) {
        this.inventory.addItem(item);
    }

    public void displayStats() {
        System.out.println("\n/----------[ Stats: " + this.name + " ]----------\\\n" +
                "Health:\t" + this.health + "/" + this.maxHealth + "\n" +
                "Attack:\t" + this.attack + "\n" +
                "Level:\t" + this.level);

        System.out.print("\nPress enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }
}

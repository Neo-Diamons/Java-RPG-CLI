package fr.diamons.rpg;

import java.util.Random;

public class Player extends Entity {
    private final Inventory inventory;

    public Player(String name, int health, int attack, int level) {
        super(name, health, attack, level);
        this.inventory = new Inventory();
    }

    public void Heal() {
        Random random = new Random();
        int min = (int)(this.maxHealth * 0.20);
        int max = (int)(this.maxHealth * 0.25);
        int value = random.nextInt(max - min + 1) + min;
        this.health += value;

        System.out.println("\n" + this.name +  " healed " + value + " health!");
        System.out.println(this.name + " has " + this.health + "/" + this.maxHealth + " health left.");
    }

    public void addItem(Item item) {
        this.inventory.addItem(item);
    }

    public void displayInventory() {
        this.inventory.displayItems();
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

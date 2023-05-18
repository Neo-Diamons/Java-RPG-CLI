package fr.diamons.rpg;

import java.util.Random;

public class Player extends Entity {
    private final Inventory inventory;
    private int xp;

    public Player(String name, int health, int attack, int level) {
        super(name, health, attack, level);
        this.inventory = new Inventory();
        this.xp = 0;
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

    public void levelUp() {
        this.maxHealth += 10;
        this.health = this.maxHealth;
        this.attack += 2;
        this.level += 1;
        System.out.println("\n" + this.name + " leveled up!");
        System.out.println(this.name + " is now level " + this.level + "!");
    }

    public void addXp(int xp) {
        this.xp += xp;
        System.out.println("\n" + this.name + " earned " + xp + " xp!");
        System.out.println(this.name + " has " + this.xp + "/" + this.level * 100 + " xp.");
        if (this.xp >= Math.log10(this.level) * 100) {
            this.xp -= Math.log10(this.level) * 100;
            this.levelUp();
        }
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

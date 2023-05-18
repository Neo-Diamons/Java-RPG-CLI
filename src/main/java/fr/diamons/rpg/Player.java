package fr.diamons.rpg;

public class Player extends Entity {
    private final Inventory inventory;

    public Player(String name, int health, int attack, int level) {
        super(name, health, attack, level);
        this.inventory = new Inventory();
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

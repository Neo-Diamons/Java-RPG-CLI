package fr.diamons.rpg.entity;

import fr.diamons.rpg.item.Item;

public class Inventory {
    private final Item[] items = new Item[10];

    public void addItem(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = item;
                return;
            }
        }
    }

    public int countItems(String name) {
        int count = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    public Item useItem(String name) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(name)) {
                Item item = this.items[i];
                this.items[i] = null;
                return item;
            }
        }
        return null;
    }

    public void displayItems() {
        int nbItems = 1;
        System.out.println("\n/----------[ Inventory ]----------\\");
        for (Item item : this.items) {
            if (item != null) {
                System.out.println(nbItems + ". " + item.getName());
                nbItems++;
            }
        }
        if (nbItems == 0) {
            System.out.println("\033[3mEmpty\033[0m");
        }

        System.out.print("\nPress enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }
}

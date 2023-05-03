package fr.diamons.rpg;

public class Inventory {
    private final Item[] items = new Item[10];

    public void addItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
    }

    public void displayItems() {
        int nbItems = 0;
        System.out.println("\n/----------[ Inventory ]----------\\");
        for (Item item : items) {
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

package fr.diamons.rpg.place;

import fr.diamons.rpg.Choice;
import fr.diamons.rpg.entity.Player;

public class Town extends Place {
    public Town(String name) {
        super(name);

        this.addChoice(new Choice("Forge"));
        this.addChoice(new Choice("Inn"));
        this.addChoice(new Choice("Inventory"));
        this.addChoice(new Choice("Stats"));
        this.addChoice(new Choice("Move"));
        this.addChoice(new Choice("Quit"));
    }

    private void useForge(Player player) {
        if (player.countItems("Iron") < 3) {
            System.out.println("\nYou don't have enough iron to forge a sword");
            return;
        }

        for (int i = 0; i < 3; i++) {
            player.useItem("Iron");
        }
        player.addAttack(2);
    }

    private void useInn(Player player) {
        player.fullHeal();

        System.out.println("\n" + player.getName() + " healed to full health!");
    }

    @Override
    public Place chooseChoice(Player player) {
        while (true) {
            switch (super.chooseChoice("Current place").getName()) {
                case "Forge":
                    this.useForge(player); break;
                case "Inn":
                    this.useInn(player); break;
                case "Inventory":
                    player.displayInventory(); break;
                case "Stats":
                    player.displayStats(); break;
                case "Move":
                    return this.getPath().chooseDestination();
                case "Quit":
                    return null;
            }
        }
    }
}

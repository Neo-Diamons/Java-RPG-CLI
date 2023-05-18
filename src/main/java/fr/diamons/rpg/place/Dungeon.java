package fr.diamons.rpg.place;

import fr.diamons.rpg.Choice;
import fr.diamons.rpg.Fight;
import fr.diamons.rpg.entity.Monster;
import fr.diamons.rpg.entity.Player;

public class Dungeon extends Place {
    private final Fight fight;

    public Dungeon(String name, Monster[] monsters) {
        super(name);
        this.fight = new Fight(monsters);

        this.addChoice(new Choice("Fight"));
        this.addChoice(new Choice("Inventory"));
        this.addChoice(new Choice("Stats"));
        this.addChoice(new Choice("Move"));
        this.addChoice(new Choice("Quit"));
    }

    @Override
    public Place chooseChoice(Player player) {
        while (true) {
            switch (super.chooseChoice("Current place").getName()) {
                case "Fight":
                    this.fight.start(player); break;
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

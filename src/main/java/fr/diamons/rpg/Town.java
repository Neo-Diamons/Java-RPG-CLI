package fr.diamons.rpg;

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

    @Override
    public Place chooseChoice(Player player) {
        while (true) {
            switch (super.chooseChoice("Current place").getName()) {
                case "Forge":
                    break;
                case "Inn":
                    break;
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

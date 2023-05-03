package fr.diamons.rpg;

public class Place extends Choice {
    private final Path path;

    public Place(String name) {
        super(name);
        this.path = new Path(this);

        this.addChoice(new Choice("Fight"));
        this.addChoice(new Choice("Inventory"));
        this.addChoice(new Choice("Stats"));
        this.addChoice(new Choice("Move"));
        this.addChoice(new Choice("Quit"));
    }

    public void addDestination(Place destination) {
        this.path.addDestination(destination.path);
    }

    public Place chooseChoice(Player player) {
        while (true) {
            switch (super.chooseChoice("Current place").getName()) {
                case "Fight":
                    System.out.println("\033[33mNot implemented yet\033[0m"); break;
                case "Inventory":
                    player.displayInventory(); break;
                case "Stats":
                    player.displayStats(); break;
                case "Move":
                    return path.chooseDestination();
                case "Quit":
                    return null;
            }
        }
    }
}

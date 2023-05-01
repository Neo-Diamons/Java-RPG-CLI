package fr.diamons.rpg;

public class Place extends Choice {
    private final Path path;

    public Place(String name) {
        super(name);
        this.path = new Path(this);
    }

    public void addDestination(Place destination) {
        this.path.addDestination(destination.path);
    }

    public Place chooseDestination() {
        return path.chooseDestination();
    }
}

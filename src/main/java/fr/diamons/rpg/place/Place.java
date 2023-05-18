package fr.diamons.rpg.place;

import fr.diamons.rpg.Choice;

public abstract class Place extends Choice implements PlaceAction {
    private final Path path;

    public Place(String name) {
        super(name);
        this.path = new Path(this);
    }

    public Path getPath() {
        return this.path;
    }

    public void addDestination(Place destination) {
        this.path.addDestination(destination.getPath());
    }
}

package fr.diamons.rpg;

public class Path extends Choice {
    private final Place parent;

    public Path(Place parent) {
        super(parent.getName());
        this.parent = parent;
    }

    public void addDestination(Path destination) {
        if (isInside(destination.getName()) != null) {
            return;
        }

        super.addChoice(destination);
        destination.addChoice(this);
    }

    public Place chooseDestination() {
        return ((Path) super.chooseChoice("Current place")).parent;
    }
}

package rpg.example;

public class Place extends Choice {
    public Place(String name) {
        super(name);
    }

    public void addDestination(Place destination) {
        if (isInside(destination.getName()) != null) {
                System.out.println("\033[31m" + destination.getName() + " already exists\033[0m");
                return;
            }
        super.addChoice(destination);
        destination.addChoice(this);
    }

    public Place chooseDestination() {
        return (Place) super.chooseChoice("destination");
    }
}

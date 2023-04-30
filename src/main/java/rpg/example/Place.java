package rpg.example;

public class Place {
    private final String name;
    private Place[] destinations;

    public Place(String name) {
        this.name = name;
        this.destinations = new Place[0];
    }

    private void displayDestinations() {
        System.out.println("\n/----------[ Current place: " + this.name + " ]----------\\");
        for (int i = 0; i < this.destinations.length; i++) {
            System.out.println((i + 1) + ". " + this.destinations[i].name);
        }
        System.out.println();
    }

    private Place isInside(String search) {
        for (Place destination : this.destinations) {
            if (destination.name.equalsIgnoreCase(search)) {
                return destination;
            }
        }
        return null;
    }

    public Place chooseDestination() {
        while (true) {
            displayDestinations();
            System.out.print("Enter your choice: ");
            String choice = new java.util.Scanner(System.in).nextLine();
            Place destination = isInside(choice);
            if (destination != null) {
                System.out.println("You chose " + destination.name);
                return destination;
            } else {
                System.out.println("\033[31mInvalid choice\033[0m");
            }
        }
    }

    public void addDestination(Place destination) {
        if (isInside(destination.name) != null)
            return;

        Place[] newDestinations = new Place[this.destinations.length + 1];
        System.arraycopy(this.destinations, 0, newDestinations, 0, this.destinations.length);
        newDestinations[this.destinations.length] = destination;
        this.destinations = newDestinations;
        destination.addDestination(this);
    }
}

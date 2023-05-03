package fr.diamons.rpg;

public class Main {
    public static void main(String[] args) {
        Place currentPlace = new Place("Forest");

        currentPlace.addDestination(new Place("Cave"));
        currentPlace.addDestination(new Place("River"));
        currentPlace.addDestination(new Place("Mountain"));

        Player player = new Player("Player", 100, 10, 1);

        while (currentPlace != null) {
            currentPlace = currentPlace.chooseChoice(player);
        }
    }
}

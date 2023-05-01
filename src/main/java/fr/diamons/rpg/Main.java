package fr.diamons.rpg;

public class Main {
    public static void main(String[] args) {
        Place currentPlace = new Place("Forest");

        currentPlace.addDestination(new Place("Cave"));
        currentPlace.addDestination(new Place("River"));
        currentPlace.addDestination(new Place("Mountain"));

        while (true) {
            currentPlace = currentPlace.chooseChoice();
        }
    }
}

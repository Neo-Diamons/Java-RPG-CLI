package fr.diamons.rpg;

import fr.diamons.rpg.entity.Monster;
import fr.diamons.rpg.entity.Player;
import fr.diamons.rpg.place.Dungeon;
import fr.diamons.rpg.place.Place;
import fr.diamons.rpg.place.Town;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Player", 100, 10, 1);
        Place currentPlace = new Town("Town");

        currentPlace.addDestination(new Dungeon("Forest", new Monster[] {
                new Monster("Slime", 50, 5, 1),
                new Monster("Goblin", 100, 10, 1)}));
        currentPlace.addDestination(new Dungeon("Cave", new Monster[] {
                new Monster("Orc", 150, 15, 2),
                new Monster("Troll", 200, 20, 3)}));
        currentPlace.addDestination(new Dungeon("River", new Monster[] {
                new Monster("Dragon", 250, 25, 4),
                new Monster("Demon", 300, 30, 5)}));
        currentPlace.addDestination(new Dungeon("Mountain", new Monster[] {
                new Monster("Giant", 350, 35, 6),
                new Monster("God", 400, 40, 7)
        }));

        while (currentPlace != null) {
            currentPlace = currentPlace.chooseChoice(player);
        }
    }
}

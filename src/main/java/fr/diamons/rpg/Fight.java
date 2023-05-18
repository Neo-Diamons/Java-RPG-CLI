package fr.diamons.rpg;

import fr.diamons.rpg.entity.Monster;
import fr.diamons.rpg.entity.Player;
import fr.diamons.rpg.item.Food;
import fr.diamons.rpg.item.Item;

public class Fight extends Choice {
    private final Monster[] monsters;

    public Fight(Monster[] monsters) {
        super("Fight");
        this.monsters = monsters;

        this.addChoice(new Choice("Attack"));
        this.addChoice(new Choice("Heal"));
        this.addChoice(new Choice("Run"));
    }

    public boolean isRunning(Player player, Monster monster) {
        int diffLevel = monster.getLevel() - player.getLevel();

        if (diffLevel < 0) {
            return true;
        }
        return new java.util.Random().nextDouble() * 100 < 100 - Math.exp(Math.pow(diffLevel, 0.525));
    }

    public void dropItem(Player player) {
        if (new java.util.Random().nextInt(100) < 50) {
            System.out.println("\nYou didn't get any item.");
            return;
        }

        Item item;
        if (new java.util.Random().nextInt(100) < 25) {
            item = new Item("Metal");
        } else {
            item = new Food("Apple", 10);
        }
        player.addItem(item);
        System.out.println("\nYou got a " + item.getName() + " !");
    }

    public void start(Player player) {
        Monster monster = this.monsters[new java.util.Random().nextInt(this.monsters.length)];

        System.out.println("\n/----------[ Fight ]----------\\");
        System.out.println("You are fighting a " + monster.getName() + " (Level " + monster.getLevel() + ")");

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            switch (super.chooseChoice("Your turn").getName()) {
                case "Attack":
                    player.dealDamage(monster); break;
                case "Heal":
                    player.Heal(); break;
                case "Run":
                    if (isRunning(player, monster)) {
                        System.out.println("\nYou ran away from the fight !");
                        return;
                    }
                    System.out.println("\nYou failed to run away from the fight !");
                    break;
            }

            if (monster.getHealth() > 0) {
                System.out.println("\n/----------[ Monster turn ]----------\\");
                monster.dealDamage(player);
            }
        }

        if (player.getHealth() > 0) {
            System.out.println("\nYou won the fight !");
            player.addXp(monster.getLevel() * 25);
            dropItem(player);
        } else if (player.getHealth() <= 0) {
            System.out.println("\nYou lost the fight !");
        }

        System.out.print("\nPress enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }
}

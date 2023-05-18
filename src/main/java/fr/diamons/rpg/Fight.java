package fr.diamons.rpg;

import java.util.Random;

public class Fight {
    private final Player player;
    private final Monster monster;

    public Fight(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void start() {
        System.out.println("\n/----------[ Fight ]----------\\");
        System.out.println("You are fighting a " + monster.getName() + " (Level " + monster.getLevel() + ")");

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            System.out.println("\n/----------[ Your turn ]----------\\");
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.println("3. Run");

            int choice = new java.util.Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    monster.addDamage(player.getAttack());
                    break;
                case 2:
//                    playerHeal();
                    break;
                case 3:
//                    playerRun();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            if (monster.getHealth() > 0) {
                System.out.println("\n/----------[ Monster turn ]----------\\");
                player.addDamage(monster.getAttack());
            }
        }

        if (player.getHealth() > 0) {
            System.out.println("\nYou won the fight !");
            System.out.println("You earned " + monster.getLevel() * 10 + " XP");
//            player.addXp(monster.getLevel() * 10);
        } else if (player.getHealth() <= 0) {
            System.out.println("\nYou lost the fight !");
        }

        System.out.print("\nPress enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }
}

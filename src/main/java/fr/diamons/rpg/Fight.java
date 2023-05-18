package fr.diamons.rpg;

import java.util.Random;
import java.util.Scanner;

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

            {
                boolean isValid = false;

                while (!isValid) {
                    String choice = new java.util.Scanner(System.in).nextLine();

                    if (!choice.matches("[0-9]")) {
                        continue;
                    }

                    int value = Integer.parseInt(choice);
                    switch (value) {
                        case 1:
                            isValid = true;
                            monster.addDamage(player.getAttack());
                            break;
                        case 2:
                            isValid = true;
//                    playerHeal();
                            break;
                        case 3:
                            isValid = true;
//                    playerRun();
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
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

package fr.diamons.rpg;


public class Fight extends Choice {
    private final Player player;
    private final Monster monster;

    public Fight(Player player, Monster monster) {
        super("Fight");
        this.player = player;
        this.monster = monster;

        this.addChoice(new Choice("Attack"));
        this.addChoice(new Choice("Heal"));
        this.addChoice(new Choice("Run"));
    }

    public void start() {
        System.out.println("\n/----------[ Fight ]----------\\");
        System.out.println("You are fighting a " + monster.getName() + " (Level " + monster.getLevel() + ")");

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            {
                switch (super.chooseChoice("Your turn").getName()) {
                    case "Fight":
                        monster.addDamage(player.getAttack()); break;
                    case "Heal":
                        break; // TODO: heal
                    case "Run":
                        break; // TODO: run
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
            // TODO: add xp
        } else if (player.getHealth() <= 0) {
            System.out.println("\nYou lost the fight !");
        }

        System.out.print("\nPress enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }
}

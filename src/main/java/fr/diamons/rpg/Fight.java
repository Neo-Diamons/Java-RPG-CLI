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

    public boolean isRunning() {
        int diffLevel = this.monster.getLevel() - this.player.getLevel();

        if (diffLevel < 0) {
            return true;
        }

        double chance = 100 - Math.exp(Math.pow(diffLevel, 0.525));
        double random = new java.util.Random().nextDouble() * 100;
        return random < chance;
    }

    public void start() {
        System.out.println("\n/----------[ Fight ]----------\\");
        System.out.println("You are fighting a " + monster.getName() + " (Level " + monster.getLevel() + ")");


        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            switch (super.chooseChoice("Your turn").getName()) {
                case "Fight":
                    player.dealDamage(monster); break;
                case "Heal":
                    player.Heal(); break;
                case "Run":
                    if (isRunning()) {
                        System.out.println("\nYou ran away from the fight !");
                        return;
                    } else {
                        System.out.println("\nYou failed to run away from the fight !");
                    }
                    break;
            }

            if (monster.getHealth() > 0) {
                System.out.println("\n/----------[ Monster turn ]----------\\");
                monster.dealDamage(player);
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

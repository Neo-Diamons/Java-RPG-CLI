package fr.diamons.rpg;


public class Fight extends Choice {
    private final Player player;
    private final Monster[] monsters;

    public Fight(Player player) {
        super("Fight");
        this.player = player;
        this.monsters = new Monster[] {
                new Monster("Slime", 50, 5, 1),
//                new Monster("Goblin", 100, 10, 1),
//                new Monster("Orc", 150, 15, 2),
//                new Monster("Troll", 200, 20, 3),
//                new Monster("Dragon", 250, 25, 4),
//                new Monster("Demon", 300, 30, 5)
        };

        this.addChoice(new Choice("Attack"));
        this.addChoice(new Choice("Heal"));
        this.addChoice(new Choice("Run"));
    }

    public boolean isRunning(Monster monster) {
        int diffLevel = monster.getLevel() - this.player.getLevel();

        if (diffLevel < 0) {
            return true;
        }

        double chance = 100 - Math.exp(Math.pow(diffLevel, 0.525));
        double random = new java.util.Random().nextDouble() * 100;
        return random < chance;
    }

    public void dropItem() {
        int random = new java.util.Random().nextInt(100);

        if (random < 50) {
            System.out.println("\nYou didn't get any item.");
            return;
        }

        Item item = new Food("Apple", 10);
        this.player.addItem(item);
        System.out.println("\nYou got a " + item.getName() + " !");
    }

    public void start() {
        Monster monster = monsters[new java.util.Random().nextInt(monsters.length)];

        System.out.println("\n/----------[ Fight ]----------\\");
        System.out.println("You are fighting a " + monster.getName() + " (Level " + monster.getLevel() + ")");

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            switch (super.chooseChoice("Your turn").getName()) {
                case "Attack":
                    player.dealDamage(monster); break;
                case "Heal":
                    player.Heal(); break;
                case "Run":
                    if (isRunning(monster)) {
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
            dropItem();
        } else if (player.getHealth() <= 0) {
            System.out.println("\nYou lost the fight !");
        }

        System.out.print("\nPress enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }
}

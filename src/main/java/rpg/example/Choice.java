package rpg.example;

public class Choice {
    private final String name;
    private Choice[] choices;

    public Choice(String name) {
        this.name = name;
        this.choices = new Choice[0];
    }

    public String getName() {
        return this.name;
    }

    public void addChoice(Choice choice) {
        Choice[] newChoices = new Choice[this.choices.length + 1];
        System.arraycopy(this.choices, 0, newChoices, 0, this.choices.length);
        newChoices[this.choices.length] = choice;
        this.choices = newChoices;
    }

    private void displayChoices(String name) {
        System.out.println("\n/----------[ Current " + name + ": " + this.name + " ]----------\\");
        for (int i = 0; i < this.choices.length; i++) {
            System.out.println((i + 1) + ". " + this.choices[i].name);
        }
        System.out.println();
    }

    Choice isInside(String search) {
        for (Choice choice : this.choices) {
            if (choice.name.equalsIgnoreCase(search)) {
                return choice;
            }
        }
        return null;
    }

    public Choice chooseChoice(String name) {
        while (true) {
            displayChoices(name);
            System.out.print("Enter your choice: ");
            String choice = new java.util.Scanner(System.in).nextLine();
            Choice destination = isInside(choice);
            if (destination != null) {
                System.out.println("You chose " + destination.name);
                return destination;
            } else {
                System.out.println("\033[31mInvalid choice\033[0m");
            }
        }
    }
}

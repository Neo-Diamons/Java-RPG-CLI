package fr.diamons.rpg;

import java.util.LinkedList;

public class Choice {
    private final String name;
    private final LinkedList<Choice> choices;

    public Choice(String name) {
        this.name = name;
        this.choices = new LinkedList<Choice>();
    }

    public String getName() {
        return this.name;
    }

    public void addChoice(Choice choice) {
        this.choices.add(choice);
    }

    private void displayChoices(String msg) {
        int i = 1;
        System.out.println("\n/----------[ " + msg + ": " + this.name + " ]----------\\");
        for (Choice choice : this.choices) {
            System.out.println(i + ". " + choice.name);
            i++;
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

    public Choice chooseChoice(String msg) {
        while (true) {
            displayChoices(msg);
            System.out.print("Enter your choice: ");
            String choice = new java.util.Scanner(System.in).nextLine();

            if (choice.matches("[0-9]")) {
                int value = Integer.parseInt(choice);
                if (value > 0 && value <= this.choices.size()) {
                    return this.choices.get(value - 1);
                }
            }

            Choice destination = isInside(choice);
            if (destination != null) {
                return destination;
            }
            System.out.println("\033[31mInvalid choice\033[0m");
        }
    }
}

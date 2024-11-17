package pattern.command.impl;

import animal.abstr.Animal;
import ctrl.AnimalController;
import pattern.command.iface.Command;

public class TallestCommand implements Command {

    private final AnimalController animalController;

    public TallestCommand(AnimalController animalController) {
        this.animalController = animalController;
    }

    @Override
    public void executeCommand() {
        Animal a = animalController.getTallest();

        System.out.printf("The tallest animal is %s (%s) and it measure %sm%n%n", a.getName(),
                a.getClass().getSimpleName(), a.getHeight());
    }
}

package pattern.command.impl;

import animal.abstr.Animal;
import ctrl.AnimalController;
import pattern.command.iface.Command;

public class LowestCommand implements Command {

    private final AnimalController animalController;

    public LowestCommand(AnimalController animalController) {
        this.animalController = animalController;
    }

    @Override
    public void executeCommand() {
        Animal a = animalController.getLowest();

        System.out.printf("The lowest animal is %s (%s) and it measure %sm%n%n", a.getName(),
                a.getClass().getSimpleName(), a.getHeight());
    }
}

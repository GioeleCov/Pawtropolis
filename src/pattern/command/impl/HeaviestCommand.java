package pattern.command.impl;

import animal.abstr.Animal;
import ctrl.AnimalController;
import pattern.command.iface.Command;

public class HeaviestCommand implements Command {

    private final AnimalController animalController;

    public HeaviestCommand(AnimalController animalController) {
        this.animalController = animalController;
    }

    @Override
    public void executeCommand() {
        Animal a = animalController.getHeaviest();

        System.out.printf("The heaviest animal is %s (%s) and it weighs %skg%n%n", a.getName(),
                a.getClass().getSimpleName(), a.getWeight());
    }
}

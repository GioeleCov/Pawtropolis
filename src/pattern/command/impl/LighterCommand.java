package pattern.command.impl;

import animal.abstr.Animal;
import ctrl.AnimalController;
import pattern.command.iface.Command;

public class LighterCommand implements Command {

    private final AnimalController animalController;

    public LighterCommand(AnimalController animalController) {
        this.animalController = animalController;
    }

    @Override
    public void executeCommand() {
        Animal a = animalController.getLighter();

        System.out.printf("The lighter animal is %s (%s) and it weighs %skg%n%n", a.getName(),
                a.getClass().getSimpleName(), a.getWeight());
    }
}

package pattern.command.impl;

import ctrl.AnimalController;
import pattern.command.iface.Command;

public class PrintAnimalsCommand implements Command {

    private final AnimalController animalController;

    public PrintAnimalsCommand(AnimalController animalController) {
        this.animalController = animalController;
    }

    @Override
    public void executeCommand() {
        System.out.println("Animal list:");
        animalController.printAllAnimals();
        System.out.println();
    }
}

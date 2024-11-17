package pattern.command.impl;

import animal.abstr.AnimalWithWings;
import ctrl.AnimalController;
import pattern.command.iface.Command;

public class LongestWingspanCommand implements Command {

    private final AnimalController animalController;

    public LongestWingspanCommand(AnimalController animalController) {
        this.animalController = animalController;
    }

    @Override
    public void executeCommand() {
        AnimalWithWings aW = animalController.getLongestWingspan();

        System.out.printf("The animal with longest wingspan is %s (%s) and it measure %sm%n%n", aW.getName(),
                aW.getClass().getSimpleName(), aW.getWingspan());
    }
}

package pattern.command.impl;

import animal.abstr.Animal;
import animal.abstr.AnimalWithTail;
import ctrl.AnimalController;
import pattern.command.iface.Command;

public class LongestTailCommand implements Command {

    private final AnimalController animalController;

    public LongestTailCommand(AnimalController animalController) {
        this.animalController = animalController;
    }

    @Override
    public void executeCommand() {
        AnimalWithTail aT = animalController.getLongestTails();

        System.out.printf("The animal with longest tail is %s (%s) and it measure %sm%n%n", aT.getName(),
                aT.getClass().getSimpleName(), aT.getTailLength());
    }
}

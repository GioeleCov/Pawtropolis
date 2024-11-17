import animal.entity.Eagle;
import animal.entity.Lion;
import animal.entity.Tiger;
import ctrl.AnimalController;
import ctrl.ShellController;
import pattern.factory.AnimalFactory;

public class Main {
    public static void main(String[] args) {
        AnimalFactory animalFactory = AnimalFactory.getInstance();
        AnimalController animalController = AnimalController.getInstance();
        ShellController shellController = ShellController.getInstance(animalController);

        animalFactory.createAnimal(Lion.class, 2, animalController);
        animalFactory.createAnimal(Tiger.class, 2, animalController);
        animalFactory.createAnimal(Eagle.class, 2, animalController);

        shellController.handleShellLoop();
    }
}
package ctrl;

import animal.abstr.Animal;
import animal.abstr.AnimalWithTail;
import animal.abstr.AnimalWithWings;

import java.util.*;

public class AnimalController {

    private static AnimalController instance = null;
    private final Map<Class<? extends Animal>, List<Animal>> animalMap;

    private AnimalController() {
        this.animalMap = new HashMap<>();
    }

    public static AnimalController getInstance() {
        if (instance == null) {
            instance = new AnimalController();
        }

        return instance;
    }

    public void addAnimal(Animal animal) {
        animalMap.computeIfAbsent(Animal.class, k -> new ArrayList<>()).add(animal);
    }

    @SuppressWarnings("unchecked")
    private <T extends Animal> List<T> getAnimals(Class<T> animalClass) {
        if (animalMap.get(animalClass) != null) {
            return (List<T>) animalMap.get(animalClass);
        }

        return animalMap.values().stream()
                .flatMap(Collection::stream)
                .filter(animalClass::isInstance)
                .map(animalClass::cast)
                .toList();
    }

    public Animal getHeaviest() {
        return getAnimals(Animal.class).stream()
                .max(Comparator.comparing(Animal::getWeight))
                .orElse(null);
    }

    public Animal getLighter() {
        return getAnimals(Animal.class).stream()
                .min(Comparator.comparing(Animal::getWeight))
                .orElse(null);
    }

    public Animal getTallest() {
        return getAnimals(Animal.class).stream()
                .max(Comparator.comparing(Animal::getHeight))
                .orElse(null);
    }

    public Animal getLowest() {
        return getAnimals(Animal.class).stream()
                .min(Comparator.comparing(Animal::getHeight))
                .orElse(null);
    }

    public AnimalWithTail getLongestTails() {
        return getAnimals(AnimalWithTail.class).stream()
                .max(Comparator.comparing(AnimalWithTail::getTailLength))
                .orElse(null);
    }

    public AnimalWithWings getLongestWingspan() {
        return getAnimals(AnimalWithWings.class).stream()
                .max(Comparator.comparing(AnimalWithWings::getWingspan))
                .orElse(null);
    }

    public void printAllAnimals() {
        List<Animal> animals = getAnimals(Animal.class);

        for (Animal a : animals) {
            System.out.println(a);
        }
    }
}

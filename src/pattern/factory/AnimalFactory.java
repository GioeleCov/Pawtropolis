package pattern.factory;

import animal.abstr.Animal;
import animal.entity.Eagle;
import animal.entity.Lion;
import animal.entity.Tiger;
import ctrl.AnimalController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class AnimalFactory {

    private static AnimalFactory instance = null;
    private final Random random;
    private final Map<Class<? extends Animal>, Supplier<? extends Animal>> supplierMap;

    private AnimalFactory() {
        this.random = new Random();
        this.supplierMap = new HashMap<>();
        this.supplierMap.put(Lion.class, this::getLion);
        this.supplierMap.put(Tiger.class, this::getTiger);
        this.supplierMap.put(Eagle.class, this::getEagle);
    }

    public static AnimalFactory getInstance() {
        if (instance == null) {
            instance = new AnimalFactory();
        }

        return instance;
    }

    private final String[] names = {
            "Alice", "Bob", "Charlie", "David", "Emma",
            "Fiona", "George", "Hannah", "Isaac", "Julia",
            "Kevin", "Lily", "Michael", "Nina", "Oliver",
            "Paula", "Quinn", "Rachel", "Steven", "Tina"
    };

    private final String[] favoriteFoods = {
            "Apple", "Banana", "Carrot", "Bread", "Cheese",
            "Chicken", "Eggs", "Fish", "Milk", "Rice",
            "Pasta", "Tomato", "Potato", "Onion", "Garlic",
            "Spinach", "Orange", "Yogurt", "Butter", "Cucumber"
    };

    private LocalDate getEntryDate() {
        int year = random.nextInt(2023, 2026);
        int month = random.nextInt(1, 13);
        int day = (month == 2) ? 28 : random.nextInt(1, 31);

        return LocalDate.of(year, month, day);
    }

    private Lion getLion() {
        String name = names[random.nextInt(names.length)];
        String favoriteFood = favoriteFoods[random.nextInt(favoriteFoods.length)];
        int age = random.nextInt(5, 21);
        LocalDate entryDate = getEntryDate();
        double weight = random.nextDouble(120, 230);
        weight = (double) Math.round(weight * 100) / 100;
        double height = random.nextDouble(0.5, 1.3);
        height = (double) Math.round(height * 100) / 100;
        double tailLength = random.nextDouble(0.5, 1.3);
        tailLength = (double) Math.round(tailLength * 100) / 100;

        return new Lion(name, favoriteFood, age, entryDate, weight, height, tailLength);
    }

    private Tiger getTiger() {
        String name = names[random.nextInt(names.length)];
        String favoriteFood = favoriteFoods[random.nextInt(favoriteFoods.length)];
        int age = random.nextInt(5, 21);
        LocalDate entryDate = getEntryDate();
        double weight = random.nextDouble(120, 230);
        weight = (double) Math.round(weight * 100) / 100;
        double height = random.nextDouble(0.5, 1.3);
        height = (double) Math.round(height * 100) / 100;
        double tailLength = random.nextDouble(0.5, 1.3);
        tailLength = (double) Math.round(tailLength * 100) / 100;

        return new Tiger(name, favoriteFood, age, entryDate, weight, height, tailLength);
    }

    private Eagle getEagle() {
        String name = names[random.nextInt(names.length)];
        String favoriteFood = favoriteFoods[random.nextInt(favoriteFoods.length)];
        int age = random.nextInt(5, 21);
        LocalDate entryDate = getEntryDate();
        double weight = random.nextDouble(5, 16);
        weight = (double) Math.round(weight * 100) / 100;
        double height = random.nextDouble(0.5, 1.3);
        height = (double) Math.round(height * 100) / 100;
        double wingspan = random.nextDouble(0.5, 1.3);
        wingspan = (double) Math.round(wingspan * 100) / 100;

        return new Eagle(name, favoriteFood, age, entryDate, weight, height, wingspan);
    }

    private boolean isAnimalClassPresent(Class<? extends Animal> animalClass) {
        if (animalClass == null) {
            System.out.println("Animal class not found");
            return false;
        }

        return true;
    }

    private boolean isSupplierPresent(Class<? extends Animal> animalClass) {
        if (supplierMap.get(animalClass) == null) {
            System.out.println("Supplier not found for the animal class: " + animalClass);
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public <T extends Animal> T createAnimal(Class<T> animalClass, int n, AnimalController animalController) {
        T animal = null;

        if (isAnimalClassPresent(animalClass) && isSupplierPresent(animalClass)) {
            Supplier<T> animalCreator = (Supplier<T>) supplierMap.get(animalClass);

            for (int i = 0; i <= n; i++) {
                animal = animalCreator.get();
                animalController.addAnimal(animal);
            }
        }

        return animal;
    }
}

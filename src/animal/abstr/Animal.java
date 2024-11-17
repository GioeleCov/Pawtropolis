package animal.abstr;

import java.time.LocalDate;

public abstract class Animal {

    private final String name;
    private final String favoriteFood;
    private final int age;
    private final LocalDate entryDate;
    private final double weight;
    private final double height;

    public Animal(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.age = age;
        this.entryDate = entryDate;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.format("type: %s%n" +
                "name: %s%n" +
                "favorite food: %s%n" +
                "age: %s%n" +
                "entry date: %s%n" +
                "weight: %s%n" +
                "height: %s%n",
                this.getClass().getSimpleName(), this.getName(), this.getFavoriteFood(), this.getAge(),
                this.getEntryDate(), this.getWeight(), this.getHeight());
    }
}

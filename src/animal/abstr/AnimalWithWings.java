package animal.abstr;

import java.time.LocalDate;

public abstract class AnimalWithWings extends Animal{

    private final double wingspan;

    public AnimalWithWings(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height,
            double wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    @Override
    public String toString() {
        return super.toString() + "wingspan: " + this.getWingspan() + "\n";
    }
}

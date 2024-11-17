package animal.abstr;

import java.time.LocalDate;

public abstract class AnimalWithTail extends Animal{

    private final double tailLength;

    public AnimalWithTail(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height,
            double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }

    public double getTailLength() {
        return tailLength;
    }

    @Override
    public String toString() {
        return super.toString() + "tail length: " + this.getTailLength() + "\n";
    }
}

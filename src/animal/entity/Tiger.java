package animal.entity;

import animal.abstr.AnimalWithTail;

import java.time.LocalDate;

public class Tiger extends AnimalWithTail {

    public Tiger(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height,
            double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height, tailLength);
    }
}

package animal.entity;

import animal.abstr.AnimalWithWings;

import java.time.LocalDate;

public class Eagle extends AnimalWithWings {

    public Eagle(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height,
            double wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height, wingspan);
    }
}

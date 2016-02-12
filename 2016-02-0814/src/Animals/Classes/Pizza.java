package Animals.Classes;

import Animals.Interfaces.Food;

/**
 * Created by Юра on 12.02.2016.
 */
public class Pizza extends FoodClass {
    public Pizza() {
        String status = "Пицца готова";
        vegetables = false;
        containsMilk = false;
    }

    public String toString() {
        return "Пицца";
    }
}

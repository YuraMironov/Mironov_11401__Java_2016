package Animals.Classes;

import Animals.Interfaces.Food;

/**
 * Created by Юра on 12.02.2016.
 */
public class Milk extends FoodClass {
    public Milk() {
        String status = "Молоко готово";
        vegetables = false;
        containsMilk = true;
    }

    public String toString() {
        return "Молоко";
    }
}

package Homework1.Task007.Classes;

import org.springframework.stereotype.Component;

/**
 * Created by Юра on 12.02.2016.
 */
@Component
public class Milk extends FoodClass {
    public Milk() {
        status = "Молоко готово";
        vegetables = false;
        containsMilk = true;
    }

    public String toString() {
        return "Молоко";
    }
}

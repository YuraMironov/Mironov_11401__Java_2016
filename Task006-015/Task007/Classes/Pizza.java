package Homework1.Task007.Classes;

import org.springframework.stereotype.Component;

/**
 * Created by Юра on 12.02.2016.
 */
@Component
public class Pizza extends FoodClass {
    public Pizza() {
        status = "Пицца готова";
        vegetables = false;
        containsMilk = false;
    }

    public String toString() {
        return "Пицца";
    }
}

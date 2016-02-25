package Homework1.Task004.Classes;

/**
 * Created by Юра on 12.02.2016.
 */
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

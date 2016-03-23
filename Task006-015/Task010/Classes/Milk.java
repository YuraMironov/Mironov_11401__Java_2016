package Homework1.Task010.Classes;

/**
 * Created by Юра on 12.02.2016.
 */
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

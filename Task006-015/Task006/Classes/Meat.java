package Homework1.Task006.Classes;


/**
 * Created by Юра on 12.02.2016.
 */
public class Meat extends FoodClass {
    public Meat() {
        status="Мясо готово";
        vegetables=false;
        containsMilk=false;
    }

    public String toString() {
        return "Мясо";
    }
}

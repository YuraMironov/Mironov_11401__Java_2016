package Homework1.Task007.Classes;


import org.springframework.stereotype.Component;

/**
 * Created by Юра on 12.02.2016.
 */
@Component
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

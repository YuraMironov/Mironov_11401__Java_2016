package Animals.Classes;

import Animals.Interfaces.Food;

/**
 * Created by Юра on 12.02.2016.
 */
public class FoodClass implements Food {
    String status;
    boolean vegetables;
    boolean containsMilk;
    @Override
    public void getStatus() {
        System.out.println(status);
    }

    @Override
    public boolean isVegetables() {
        System.out.println(vegetables);
        return vegetables;
    }

    @Override
    public boolean isContainsMilk() {
        System.out.println(containsMilk);
        return containsMilk;
    }
}

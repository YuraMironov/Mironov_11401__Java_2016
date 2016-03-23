package Homework1.Task007.Classes;


import Homework1.Task007.Interfaces.Food;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodClass foodClass = (FoodClass) o;

        if (containsMilk != foodClass.containsMilk) return false;
        if (vegetables != foodClass.vegetables) return false;
        if (status != null ? !status.equals(foodClass.status) : foodClass.status != null) return false;

        return true;
    }
}

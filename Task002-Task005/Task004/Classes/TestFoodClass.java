package Homework1.Task004.Classes;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestFoodClass {
    private static FoodClass fc;
    @BeforeClass
    public static void beforeClass(){
        fc = new Milk();
    }
    @Test
    public void constructorSavedStatusFood(){
        Assert.assertEquals("Молоко готово", fc.status);
    }
    @Test
     public void constructorSavedVegetablesFood(){
        Assert.assertEquals(false, fc.vegetables);
    }
    @Test
     public void constructorSavedContainsMilkInFood(){
        Assert.assertEquals(true, fc.containsMilk);
    }
}

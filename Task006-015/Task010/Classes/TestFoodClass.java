package Homework1.Task010.Classes;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestFoodClass {
    private static FoodClass fc;
    static ApplicationContext ac;
    @BeforeClass
    public static void beforeClass(){
        ac = new ClassPathXmlApplicationContext("spring-context.xml");
        fc = ac.getBean("milk", Milk.class);
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

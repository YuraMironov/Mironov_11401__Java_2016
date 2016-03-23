package Homework1.Task010.Classes;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestAnimalClass {
    private static AnimalClass ac;
    static ApplicationContext apC;
    @BeforeClass
    public static void beforeClass(){
        ac = apC.getBean("dog", Dog.class);
    }
    @Test
    public void constructorSavedAgeOfAnimal(){
        Assert.assertEquals(100, ac.getAge());
    }
    @Test
    public void constructorSavedHeightOfAnimal(){
        Assert.assertEquals(200, ac.getHeight());
    }
    @Test
    public void constructorSavedWeightOfAnimal(){
        Assert.assertEquals(300, ac.getWeight());
    }
    @Test
    public void methodIsAngryShouldCorrectWorked(){
        org.junit.Assert.assertEquals(false, ac.isAngry());
    }
    @Test
    public void methodIsBigShouldCorrectWorked(){
        org.junit.Assert.assertEquals(true, ac.isBig());
    }
    @Test
    public void methodIsFatShouldCorrectWorked(){
        org.junit.Assert.assertEquals(true, ac.isFat());
    }
    @Test
    public void methodIsOldShouldCorrectWorked(){
        org.junit.Assert.assertEquals(true, ac.isOld());
    }
    @Test
    public void methodGetLikeFoodShouldCorrectWorked(){
        org.junit.Assert.assertEquals(new Meat(), ac.getLikeFood());
    }
}

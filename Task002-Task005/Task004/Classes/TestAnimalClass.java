package Homework1.Task004.Classes;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestAnimalClass {
    private static AnimalClass ac;
    @BeforeClass
    public static void beforeClass(){
        ac = mock(Dog.class);
        when(ac.getAge()).thenReturn(100);
        when(ac.getHeight()).thenReturn(200);
        when(ac.getWeight()).thenReturn(300);
        when(ac.isAngry()).thenReturn(false);
        when(ac.isBig()).thenReturn(true);
        when(ac.isFat()).thenReturn(true);
        when(ac.isOld()).thenReturn(true);
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

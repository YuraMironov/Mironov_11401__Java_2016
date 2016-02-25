package Homework1.Task005;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestMyClass {
    @Test
    public void constructorCorrectWorkedAndSaveParams(){
        MyClass myClass = new MyClass(0,0);
        Assert.assertTrue(myClass.getX() == 0 && myClass.getY() == 0);
    }
    @Test
    public void comparatorCorrectWorked(){
        MyClass mc = new MyClass(0,0);
        MyClass mc2 = new MyClass(0,0);
        Assert.assertEquals(mc, mc2);
    }
}

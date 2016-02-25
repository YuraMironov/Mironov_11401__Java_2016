package Homework1.Task005;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestTarget {
    @Test
    public void constructorCorrectWorkedAndSaveParams(){
        Target target = new Target(1,0);
        Assert.assertTrue(target.getI() == 1 && target.getJ() == 0);
    }
    @Test
    public void comparatorCorrectWorked(){
        Target mc = new Target(1,2);
        Target mc2 = new Target(1,2);
        Assert.assertEquals(mc, mc2);
    }
}

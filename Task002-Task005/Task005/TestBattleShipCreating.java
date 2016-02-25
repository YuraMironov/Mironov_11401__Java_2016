package Homework1.Task005;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestBattleShipCreating {
    private static BattleShipCreating btc;
    @BeforeClass
    public static void beforeClass(){
        btc = new BattleShipCreating("MyTitle");
    }
    @Test
    public void constructorCorrectSaveTitleWindow(){
        Assert.assertEquals("MyTitle", btc.getTitle());
    }
    @Test
    public void methodViewPossibilityCorrectWorked(){
        btc.shipValue = 3;
        btc.viewPossibility(true);
        btc.viewPossibility(false);
        Assert.assertEquals(true, btc.field[0][8].isEnabled());
    }
    @Test
    public void methodAroundViewCorrectWorkedWhenAroundIsEmpty(){
        btc.enemyField = SourseForTest.getMatrix();
        btc.shipValue = 3;
        Assert.assertEquals(true, btc.aroundView(6 + 1 , 6 + 1)); //6 line, 6 column
    }
    @Test
    public void methodAroundViewCorrectWorkedWhenAroundNotIsEmpty(){
        btc.enemyField = SourseForTest.getMatrix();
        btc.shipValue = 3;
        Assert.assertEquals(true, btc.aroundView(2 + 1 , 6 + 1)); // 2 line, 6 column
    }
    @Test
    public void methodGetEnemyFieldCorrectWorked(){
        Assert.assertArrayEquals(SourseForTest.getMatrix(), btc.getEnemyField()); // 2 line, 6 column
    }
    @Test
    public void methodStatusCorrectWorked(){
        btc.n1 = 0;
        btc.n2 = 1;
        btc.n3 = 1;
        btc.n4 = 0;
        Assert.assertEquals(2, btc.status());
    }

}

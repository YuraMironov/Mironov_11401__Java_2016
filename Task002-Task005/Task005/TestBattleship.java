package Homework1.Task005;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static Homework1.Task005.SourseForTest.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestBattleship {
    private static Battleship bt;
    @BeforeClass
    public static void beforeClass(){
        try {
            bt = new Battleship(mock(ObjectOutputStream.class), getMatrix(), getInverseMatrix());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void constructorShouldBeCorrectWorkedAndSaveParams(){
        Assert.assertArrayEquals(getMatrix(), getIntMatrix(bt.field));
    }
    @Test
    public void methodHasKiledCorectWorked(){
        bt.field2[0][0].setText("H");
        bt.field2[0][1].setText("H");
        bt.field2[0][2].setText("H");
        bt.field2[0][3].setText("H");
        bt.statusesShipes();
        Assert.assertEquals("X", bt.field2[0][3].getText());
    }
}

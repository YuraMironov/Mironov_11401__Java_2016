package Homework1.Task005;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestBattleShipeSourses {
    @Test
    public void correctChangeJButtonStyle(){
        JButton jb = new JButton();
        Color color = mock(Color.class);
        BattleShipeSourses.changeJButtonStyle(jb, "AnyString", color, 20);
        Assert.assertTrue("AnyString".equals(jb.getText())&& jb.getBackground().equals(color) && jb.getFont().getSize() == 20);
    }
}

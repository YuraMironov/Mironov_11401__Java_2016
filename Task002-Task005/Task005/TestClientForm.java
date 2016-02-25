package Homework1.Task005;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.UnknownHostException;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestClientForm {
    private static ClientForm cf;
    @BeforeClass
    public static void beforeClass(){
        try {
            cf = new ClientForm();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void methodSendDataCorrectWorkedWithCorrectData(){
        cf.tf.setText("192.168.0.12");
        cf.tf2.setText("Yura");
        cf.sendData();
        Assert.assertEquals(true, cf.flag);
    }
    @Test
    public void methodSendDataCorrectWorkedWithNotCorrectData(){
        cf.tf.setText("192.1680508.12");
        cf.tf2.setText("Yura");
        cf.sendData();
        Assert.assertEquals(false, cf.flag);
    }
}

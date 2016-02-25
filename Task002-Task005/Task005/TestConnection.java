package Homework1.Task005;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 25.02.2016.
 */
public class TestConnection {
    private static boolean flag;
    private static Server server;
    private static Socket socket1;
    private static Socket socket2;
    private static Connection connection;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;
    @BeforeClass
    public static void beforeClass(){
        ois = mock(ObjectInputStream.class);
        oos = mock(ObjectOutputStream.class);
        server = mock(Server.class);
        socket1 = mock(Socket.class);
        socket2 = mock(Socket.class);
        connection = new Connection(server, socket1, socket2 );
    }
    @Before
    public void before(){
        flag = true;
    }
    @Test
    public void constructorCorrectWork(){
        flag = server.equals(connection.server);
        flag &= socket1.equals(connection.socket);
        flag &= socket2.equals(connection.socket2);
        Assert.assertTrue(flag);
    }
    @Test
    public void methodReadFirstDataCorrectWork(){
        try {
            when(ois.readObject()).thenReturn("AnyString", SourseForTest.getInverseMatrix());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection.readFirstData(ois, 1);
        flag &= connection.name1.equals("AnyString");
        flag &= connection.shipesField[0][9] == 4;
        Assert.assertTrue(flag);
    }
    @Test
    public void methodWriteFirstDataCorrectWork(){
        boolean f = true;
        int[][] a = SourseForTest.getMatrix();
        String nameEnemy = "AnyEnemy";
        Assert.assertTrue(connection.writeFirstData(oos, f,a,nameEnemy));
    }
    @Test
    public void methodStapCorrectWork(){
        connection.shipesField2 = SourseForTest.getInverseMatrix();
        ObjectOutputStream oos2 = mock(ObjectOutputStream.class);
        Target target = mock(Target.class);
        when(target.getI()).thenReturn(1);
        when(target.getJ()).thenReturn(0);
        try {
            when(ois.readObject()).thenReturn(target);
            Assert.assertTrue(!connection.stap(ois, oos, oos2, 1));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

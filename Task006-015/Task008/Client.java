package Homework1.Task008;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by ��� on 19.11.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        /// Connecting with server and entering data by a player
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        String host;
        ClientForm cf = ac.getBean("clientForm", ClientForm.class);
        String myName;
        while (cf.host.equals("") || cf.name.equals("")) {
            Thread.sleep(50);
        }
        host = cf.host;
        myName = cf.name;
        cf.dispose();
        new Waiting();

        ///open socket streams
        Socket s = ac.getBean("socket", Socket.class);

        ObjectOutputStream oos = ac.getBean("oos", ObjectOutputStream.class);
        ObjectInputStream ois = ac.getBean("ios", ObjectInputStream.class);

        /// To connect with server and fieldCreating

        BattleShipCreating bsc = ac.getBean("battleShipCreating", BattleShipCreating.class);
        int st = bsc.status();
        while (st != 0) {
            st = bsc.status();
            Thread.sleep(50);
        }
        int[][] myField = bsc.getMyField();
        bsc.dispose();
        new Waiting();
        /// send username and other data to a server and read from the server name of second player
        oos.writeObject(myName);
        oos.writeObject(myField);
        boolean flag = (boolean) ois.readObject();
        int[][] youField = (int[][]) ois.readObject();

        String myTitle = (String) ois.readObject();
        Battleship battleship = new Battleship(oos, myField, youField);
        battleship.setTitle(myTitle);
        battleship.setVisible(true);

        boolean endGame = false;
        int k = 0;
        while (!endGame) {
            battleship.enableAction(flag);
            if (!flag) {
                JOptionPane.showMessageDialog(null, "Wait, 2 player is thinking");
                endGame = (boolean) ois.readObject();
                Target tFM = (Target) ois.readObject();
                while (myField[tFM.getI()][tFM.getJ()] != 0 & !endGame) {
                    int i = tFM.getI();
                    int j = tFM.getJ();
                    k += myField[i][j];
                    BattleShipeSourses.changeJButtonStyle(battleship.field[i][j], "X", Color.red);
                    if (k == 50) {
                        battleship.dispose();
                        JOptionPane.showMessageDialog(null, "You lose");
                        return;
                    }
                    endGame = (boolean) ois.readObject();
                    tFM = (Target) ois.readObject();
                }
                int i = tFM.getI();
                int j = tFM.getJ();
                k += myField[i][j];
                if (k == 50) {
                    battleship.dispose();
                    JOptionPane.showMessageDialog(null, "You lose");
                    return;
                }
                BattleShipeSourses.changeJButtonStyle(battleship.field[tFM.getI()][tFM.getJ()], "", Color.orange);

            } else {
                JOptionPane.showMessageDialog(null, "Ready?");
            }
            flag = (boolean) ois.readObject();
            endGame = (boolean) ois.readObject();
        }

    }
}

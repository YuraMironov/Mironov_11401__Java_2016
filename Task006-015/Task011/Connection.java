package Homework1.Task011;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by ��� on 19.11.2015.
 */
public class Connection implements Runnable {
    Socket socket;
    Socket socket2;
    Thread thread;
    Server server;
    int[][] shipesField = new int[10][10];
    boolean flag = true;
    int[][] shipesField2 = new int[10][10];
    boolean flag2 = false;
    String name1;
    String name2;
    int k1;
    int k2;

    public Connection(Server server, Socket socket, Socket socket2) {
        k1 = 0;
        k2 = 0;
        this.socket = socket;
        this.socket2 = socket2;
        this.server = server;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois2 = new ObjectInputStream(socket2.getInputStream());
            ObjectOutputStream oos2 = new ObjectOutputStream(socket2.getOutputStream());

            readFirstData(ois,1);
            readFirstData(ois2, 2);
            writeFirstData(oos, flag, shipesField2, name2);
            writeFirstData(oos2, flag2, shipesField, name1);


            boolean endGame = false;
            while (!endGame) {
                if (flag) {
                    endGame = stap(ois, oos, oos2, 1);
                } else {
                    endGame = stap(ois2, oos2, oos, 2);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean readFirstData(ObjectInputStream ois, int num){
        try {
            String name = (String) ois.readObject();
            name = "You are playing against " + name;
            int[][] field = (int[][]) ois.readObject();
            if (num == 1) {
                name1 = name;
                shipesField = field;
            }else{
                name2 = name;
                shipesField2 = field;
            }
            return true;
        } catch (IOException | ClassNotFoundException e) {
           return false;
        }
    }
    public boolean writeFirstData(ObjectOutputStream oos,boolean flag, int[][] enemyField, String enemyName){
        try {
            oos.writeObject(flag);
            oos.writeObject(enemyField);
            oos.writeObject(enemyName);
            return true;
        } catch (IOException e) {
           return false;
        }
    }
    public boolean stap(ObjectInputStream ois, ObjectOutputStream oos, ObjectOutputStream oos2,int num)
                                                                            throws IOException, ClassNotFoundException {
        Target target = (Target) ois.readObject();
        boolean endGame = false;
        int[][] field;
        if (num == 1){
            field = shipesField2;
        }else {
            field = shipesField;
        }
        while (field[target.getI()][target.getJ()] != 0) {
            int c = field[target.getI()][target.getJ()];
            if (num == 1){
                k1 += c;
                if (k1 == 50) {
                    endGame = true;
                }
            }else{
                k2 += c;
                if (k2 == 50) {
                    endGame = true;
                }
            }
            oos2.writeObject(endGame);
            oos2.writeObject(target);
            target = (Target) ois.readObject();
        }
        oos2.writeObject(endGame);
        oos2.writeObject(target);
        flag = !flag;
        flag2 = !flag2;
        if (num == 1){
            oos.writeObject(flag);
            oos2.writeObject(flag2);
        }else{
            oos.writeObject(flag2);
            oos2.writeObject(flag);
        }
        oos.writeObject(endGame);
        oos2.writeObject(endGame);
        return endGame;
    }
}

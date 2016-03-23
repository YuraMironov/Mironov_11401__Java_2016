package Homework1.Task008;

import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by ��� on 19.11.2015.
 */
public class Server extends  NimbusJFrame {

    final int PORT = 1234;
    ArrayList<Connection> connections;

    public Server() throws IOException {
        setTitle("Server");
        setVisible(true);
        setBounds(50, 50, 400, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextField host = new JTextField("Server IP for connnect: " + (InetAddress.getLocalHost() + "").split("/")[1]);
        host.setVisible(true);
        host.setBounds(10,10,300,30);
        add(host);
        setLayout(new GroupLayout(getContentPane()));
        connections = new ArrayList<>();
        go();

    }

    public void go() throws IOException {
        ServerSocket s1 = new ServerSocket(PORT);
        while (true) {
            Socket client = s1.accept();
            Socket client2 = s1.accept();
            System.out.println("Room inicialisate");
            connections.add(new Connection(this, client, client2));
        }
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}

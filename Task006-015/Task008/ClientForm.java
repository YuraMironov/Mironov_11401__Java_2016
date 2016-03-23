package Homework1.Task008;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ��� on 16.12.2015.
 */
public class ClientForm extends NimbusJFrame {
    public boolean flag = false;

    public String host = "";
    public String name = "";
    public JTextField tf;
    public JTextField tf2;
    public JLabel label;
    public JLabel label2;

    public String getHost() {
        return host;
    }

    public String getName() {
        return name;
    }
    public ClientForm() throws UnknownHostException {
        setTitle("Enter IPServer");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(50, 50, 300, 180);

        tf = new JTextField();
        tf.setBounds(100,10, 160,30);
        tf.setVisible(true);
        tf.setText((InetAddress.getLocalHost() + "").split("/")[1]);
        label = new JLabel("ServerIp");
        label.setVisible(true);
        label.setBounds(10,10,100,30);

        tf2 = new JTextField();
        tf2.setBounds(100,50, 160,30);
        tf2.setVisible(true);

        label2 = new JLabel("YouName");
        label2.setVisible(true);
        label2.setBounds(10,50,100,30);

        JButton jb = new JButton("Connect");
        jb.setBounds(105,90, 90,30);
        jb.setVisible(true);


        add(jb);
        add(tf);
        add(tf2);
        add(label);
        add(label2);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendData();
            }
        });
        setLayout(new GroupLayout(getContentPane()));
        update(getGraphics());
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    sendData();
                    e.consume();
                }
            }
        };
        jb.addKeyListener(keyAdapter);
        tf.addKeyListener(keyAdapter);
        tf2.addKeyListener(keyAdapter);
    }
    public void sendData(){
        flag = tf.getText().matches("[0-9]{0,3}(.[0-9]{0,3}){3}");
        flag &= tf2.getText().matches(".{1,}");
        if(flag){
            host = tf.getText();
            name = tf2.getText();
        }else{
            JOptionPane.showMessageDialog(null, "Please, enter the correct data");
        }
    }

}

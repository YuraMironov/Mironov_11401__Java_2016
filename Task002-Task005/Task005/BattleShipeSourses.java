package Homework1.Task005;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * Created by ��� on 25.12.2015.
 */
public class BattleShipeSourses {
    public static void changeJButtonStyle(JButton jb, String value, Color background, int size){
        jb.setFocusable(false);
        jb.removeMouseListener(new MouseAdapter() {});
        jb.setText(value);
        jb.setFont(new Font("Segoe Print", Font.ITALIC, size));
        jb.setBackground(background);
        jb.update(jb.getGraphics());
    }
    public static void changeJButtonStyle(JButton jb, String value, Color background){
        changeJButtonStyle(jb, value, background, 30);
    }
    public static void createFirstCulomns(NimbusJFrame frame, boolean createOrGame, int buttonSize){
        int k = createOrGame ? 118 : 107;


        for (int i = 97; i < k; i++) {
            if (i != 107) {
                JButton jb = new JButton();
                jb.setText((i < k ? (char) i : (char) (i - 11)) + "");
                jb.setBounds((i + 1 - 97) * buttonSize, 0, buttonSize, buttonSize);
                jb.setBackground(Color.LIGHT_GRAY);
                frame.add(jb);
            }
        }
        for (int i = 0; i < 10; i++) {
            JButton jb = new JButton();
            jb.setText("" + (1 + i));
            jb.setBounds(0, (i + 1) * buttonSize, buttonSize, buttonSize);
            jb.setBackground(Color.LIGHT_GRAY);
            frame.add(jb);
        }
    }
}

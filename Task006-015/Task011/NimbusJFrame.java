package Homework1.Task011;

import javax.swing.*;

/**
 * Created by ��� on 23.12.2015.
 */
public class NimbusJFrame extends JFrame {
    public NimbusJFrame(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
        }
    }
}

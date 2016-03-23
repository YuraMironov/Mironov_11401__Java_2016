package Homework1.Task008;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
* Created by Юра on 19.11.2015.
*/
public class Battleship extends NimbusJFrame {
    int buttonSize = 50;
    JButton[][] field = new JButton[10][10];
    JButton[][] field2 = new JButton[10][10];
    boolean flag;
    int winner = 0;
    public Battleship(ObjectOutputStream oos, int[][] field, int[][] field2) throws IOException {

        setVisible(true);
        setBounds(50, 50, buttonSize * 22 + 20, buttonSize * 11 + buttonSize);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GroupLayout(getContentPane()));

        BattleShipeSourses.createFirstCulomns(this, true, buttonSize);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton jb = new JButton();
                jb.setBounds((j + 1) * buttonSize, (i + 1) * buttonSize, buttonSize, buttonSize);
                add(jb);
                this.field[i][j] = jb;
                if (field[i][j] != 0) {
                    BattleShipeSourses.changeJButtonStyle(jb, "X", Color.DARK_GRAY);
                }else{
                    jb.setBackground(Color.WHITE);
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton jb = new JButton();
                jb.setBounds(j * buttonSize + 12 * buttonSize, (i + 1) * buttonSize, buttonSize, buttonSize);
                jb.setName(field2[i][j] + "");
                jb.setBackground(Color.WHITE);
                jb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (flag && jb.getText().equals("")) {
                            String str  = jb.getName().equals("0") ? "0" : "H";
                            boolean b = str.equals("0");
                            BattleShipeSourses.changeJButtonStyle(jb, str, b ? null : Color.GRAY, b ? 12 : 20);
                            int i = (jb.getY()) / buttonSize;
                            int j = (jb.getX() + buttonSize) / buttonSize - 12 + 96;
                            Target target = new Target();
                            target.setI(i);
                            target.setJ(j);
                            jb.setEnabled(false);
                            try {
                                oos.writeObject(target);
                            } catch (IOException e1) {
                            }
                            statusesShipes();
                            jb.update(jb.getGraphics());
                        }
                    }
                });
                add(jb);
                this.field2[i][j] = jb;
            }
        }
        update(getGraphics());
    }

    public void enableAction(boolean flag) {
        this.flag = flag;
    }

    public void statusesShipes() {
        for (int k = 0; k < 10; k++) {
            for (int l = 0; l < 10; l++) {
                if (field2[k][l].getText().equals("H")) {
                    hasKiled(k, l, Integer.parseInt(field2[k][l].getName()), 0, new ArrayList<>());
                }
            }
        }
    }

    public void hasKiled(int i, int j, int maxSch, int napr, ArrayList<JButton> list) {
        if (maxSch != list.size()) {
            list.add(field2[i][j]);
            if (napr == 0) {
                boolean right = j < 9 && field2[i][j + 1].getText().equals("H");
                boolean down = i < 9 && field2[i + 1][j].getText().equals("H");
                if (right & !down) {
                    hasKiled(i, j + 1, maxSch, 3, list);
                } else {
                    if (!right & down) {
                        hasKiled(i + 1, j, maxSch, 6, list);
                    }else{
                        try{
                            hasKiled(-1,-1,maxSch, 0, list);
                        }catch (ArrayIndexOutOfBoundsException ignored){}
                    }
                }
            }
            if (napr == 3){
                hasKiled(i, j + 1, maxSch, 3, list);
            }
            if(napr == 6){
                hasKiled(i + 1, j, maxSch, 6, list);
            }
        } else {
            boolean b = true;
            for (JButton jb : list) {
                b &= jb.getText().equals("H");
            }
            if (b) {
                for (JButton jb : list) {
                    int x = (jb.getY()) / buttonSize - 1;
                    int y = (jb.getX() + buttonSize) / buttonSize - 12 - 1;
                    for (int k = -1 ; k < 2; k++){
                        if (x + k > -1 && x + k < 10){
                            for (int l = -1; l < 2; l ++){
                                if (y + l > -1 && y + l < 10){
                                    JButton button = field2[x + k][y + l];
                                    if (button.getText().equals("")) {
                                        button.setText(button.getName());
                                        button.setEnabled(false);
                                        BattleShipeSourses.changeJButtonStyle(button, button.getText(), null, 12 );
                                    }
                                }
                            }
                        }
                    }
                    BattleShipeSourses.changeJButtonStyle(jb, "X", Color.DARK_GRAY);
                    jb.setEnabled(true);
                    jb.update(jb.getGraphics());
                    winner += 1;
                }
            }
            if (winner==20){
                this.dispose();
                JOptionPane.showMessageDialog(null, "You win");
            }
        }
    }

}

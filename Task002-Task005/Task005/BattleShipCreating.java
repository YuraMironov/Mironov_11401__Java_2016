package Homework1.Task005;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by ��� on 26.11.2015.
 */
public class BattleShipCreating extends NimbusJFrame {
    int buttonSize = 50;
    JButton[][] field = new JButton[10][10];
    int [][] enemyField = new int[10][10];
    boolean directionVertical = false;     // if vertical then true else gorizontal
    int shipValue = 0;
    int n1 = 4;
    int n2 = 3;
    int n3 = 2;
    int n4 = 1;

    public BattleShipCreating(String title) {
        setTitle("Field of shipes by " + title);
        setBounds(50, 50, buttonSize * 11 + 20, buttonSize * 11 + 2 * buttonSize);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GroupLayout(getContentPane()));

        BattleShipeSourses.createFirstCulomns(this, false, buttonSize);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton jb = new JButton();
                jb.setBackground(Color.WHITE);
                jb.setBounds((j + 1) * buttonSize, (i + 1) * buttonSize, buttonSize, buttonSize);
                jb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        boolean f = false;
                        switch (shipValue) {
                            case (0):
                                f = false;
                                break;
                            case (1):
                                f = n1 != 0;
                                break;
                            case (2):
                                f = n2 != 0;
                                break;
                            case (3):
                                f = n3 != 0;
                                break;
                            case (4):
                                f = n4 != 0;
                                break;
                        }
                        if (f) {
                            viewPossibility(false);
                            int x = (jb.getY() + buttonSize) / buttonSize - 1;
                            int y = (jb.getX() + buttonSize) / buttonSize - 1;
                            if (!aroundView(x, y)) {
                                JOptionPane.showMessageDialog(null, "Change dislacation your ship");
                                viewPossibility(true);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Please, choose the ship");
                        }
                    }
                });
                field[i][j] = jb;
                add(jb);
            }
        }
        JButton jb = new JButton("Horizontal");
        jb.setBounds(70, 550, 150, 30);
        JButton jb2 = jb;
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewPossibility(false);
                directionVertical = !directionVertical;
                viewPossibility(true);
                if (jb2.getText().equals("Horizontal")) {
                    jb2.setText("Vertical");
                    ;
                } else {
                    jb2.setText("Horizontal");
                    ;
                }
            }
        });
        jb.setBackground(Color.darkGray);
        jb.setForeground(Color.white);
        add(jb);
        jb = new JButton("XXXX");
        jb.setBounds(220, 550, 120, 30);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewPossibility(false);
                shipValue = 4;
                viewPossibility(true);
            }
        });
        jb.setBackground(Color.darkGray);
        jb.setForeground(Color.white);
        add(jb);
        jb = new JButton("XXX");
        jb.setBounds(340, 550, 90, 30);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewPossibility(false);
                shipValue = 3;
                viewPossibility(true);
            }
        });
        jb.setBackground(Color.darkGray);
        jb.setForeground(Color.white);
        add(jb);
        jb = new JButton("XX");
        jb.setBounds(430, 550, 60, 30);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewPossibility(false);
                shipValue = 2;
                viewPossibility(true);
            }
        });
        jb.setBackground(Color.darkGray);
        jb.setForeground(Color.white);
        add(jb);
        jb = new JButton("X");
        jb.setBounds(490, 550, 40, 30);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewPossibility(false);
                shipValue = 1;
                viewPossibility(true);
            }
        });
        jb.setBackground(Color.darkGray);
        jb.setForeground(Color.white);
        add(jb);
        setVisible(true);
    }

    public void viewPossibility(boolean f) {
        boolean g = shipValue <= 2 ? n2 == 0: shipValue == 3 ? n3 == 0 : n4 == 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (enemyField[i][j] == 0 && shipValue!= 0 && !g)
                if (directionVertical) {
                    if (i > 10 - shipValue) {
                        field[i][j].setEnabled(!f);
                    }
                } else {
                    if (j > 10 - shipValue) {
                        field[i][j].setEnabled(!f);
                    }
                }
            }
        }
    }

    public boolean aroundView(int x, int y) {
        x = x - 1;
        y = y - 1;
        int n = shipValue;
        ArrayList<MyClass> list = new ArrayList<>();//
        try {
            while (n > 0) {
                if (enemyField[x][y] == 0) {
                    MyClass myClass = new MyClass(x, y);//
                    list.add(myClass);
                    if (directionVertical) {
                        x++;
                    } else {
                        y++;
                    }
                    n--;
                } else {
                    viewPossibility(false);
                    return false;
                }
                if ((x == 10 || y > 10) & n != 0) {
                    viewPossibility(false);
                    return true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            viewPossibility(true);
            return false;
        }
        for (MyClass mC : list) {
            int xx = mC.getX();
            int yy = mC.getY();
            for (int i = -1; i < 2; i++) {
                if (xx + i > -1 && xx + i < 10) {
                    for (int j = -1; j < 2; j++) {
                        if (yy + j > -1 && yy + j < 10) {
                            if (!(i == 0 && j == 0)) {
                                int q = xx + i;
                                int w = yy + j;
                                if (!list.contains(new MyClass(q, w)) && enemyField[q][w] != 0) {
                                    viewPossibility(false);
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (MyClass mC : list) {
            int i = mC.getX();
            int j = mC.getY();
            enemyField[i][j] = shipValue;
            BattleShipeSourses.changeJButtonStyle(field[i][j], "X", Color.DARK_GRAY);
        }
        if (shipValue == 1) {
            n1--;

        }
        if (shipValue == 2) {
            n2--;
        }
        if (shipValue == 3) {
            n3--;
        }
        if (shipValue == 4) {
            n4--;
        }
        shipValue = 0;
        viewPossibility(false);
        return true; // true if empty
    }

    public int status() {
        return n1 + n2 + n3 + n4;
    }

    public int[][] getEnemyField() {
        return  enemyField;
    }
}
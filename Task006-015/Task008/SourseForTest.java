package Homework1.Task008;

import javax.swing.*;

/**
 * Created by Юра on 25.02.2016.
 */
public class SourseForTest {
    public final static int[][] b ={{4,4,4,4,0,3,3,3,0,1},
                {0,0,0,0,0,0,0,0,0,0},
                {3,3,3,0,2,2,0,2,2,0},
                {0,0,0,0,0,0,0,0,0,0},
                {2,2,0,1,0,1,0,1,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}};
    public static int[][] getMatrix(){
        int[][] a = new int[10][10];
        for (int i = 0; i <10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = b[i][j];
            }
        }
        return a;
    }
    public static int[][] getInverseMatrix(){
        int[][] a = new int[10][10];
        for (int i = 0; i <10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = b[i][9 - j];
            }
        }
        return a;
    }
    public static int[][] getIntMatrix(JButton[][] jm){
        int[][] a = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = Integer.parseInt(jm[i][j].getText());
            }
        }
        return a;
    }
}

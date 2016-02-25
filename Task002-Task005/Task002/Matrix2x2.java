package Homework1.Task002;
/**
 * Created by 123 on 17.11.2014.
 */
public class Matrix2x2 {
    private double [][] a = new double[2][2];
    public double getA(int i, int i2){
        return this.a[i][i2];
    }
    public Matrix2x2(){
        this(0);
    }
    public Matrix2x2(double k){
        this(k, k, k, k);
    }
    public Matrix2x2(double a [][]){
        this(a[0][0], a[0][1], a[1][0], a[1][1]);
    }
    public Matrix2x2(double a1, double a2, double a3, double a4){
        this.a[0][0] = a1;
        this.a[0][1] = a2;
        this.a[1][0] = a3;
        this.a[1][1] = a4;
    }
    public double det(){
        return (this.a[0][0] * this.a[1][1] - this.a[1][0] * this.a[0][1]);
    }
    public Matrix2x2 add(Matrix2x2 b){
        Matrix2x2 c = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                c.a[i][i2] = this.a[i][i2] + b.a[i][i2];
            }
        }
        return  c;
    }
    public void add2(Matrix2x2 b){
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                this.a[i][i2] = this.a[i][i2] + b.a[i][i2];
            }
        }
    }
    public Matrix2x2 sub( Matrix2x2 b){
        Matrix2x2 c = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                c.a[i][i2] = this.a[i][i2] - b.a[i][i2];
            }
        }
        return  c;
    }
    public void sub2(Matrix2x2 b){
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                this.a[i][i2] = this.a[i][i2] - b.a[i][i2];
            }
        }
    }
    public Matrix2x2 multNumber(double k){
        Matrix2x2 c = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                c.a[i][i2] = this.a[i][i2] * k;
            }
        }
        return  c;
    }
    public void multNumber2(double k){
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                this.a[i][i2] = this.a[i][i2] * k;
            }
        }
    }
    public Matrix2x2 mult(Matrix2x2 b){
        Matrix2x2 c = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                for (int i3 = 0; i3 <2; i3++){
                    c.a[i][i2] += this.a[i][i3]*b.a[i3][i2];
                }
            }
        }
        return  c;
    }
    public void mult2(Matrix2x2 b){
        for (int i = 0; i < 2; i++) {
            double k = 0;
            for (int i2 = 0; i2 < 2; i2++) {
                if (i2 == 0) {
                    k = this.a[i][i2];
                    this.a[i][i2]= this.a[i][0] * b.a[0][i2] + this.a[i][1] * b.a[1][i2];
                }
                if (i2 == 1){
                    this.a[i][i2] = k * b.a[0][i2] + this.a[i][1 ]* b.a[1][i2];
                }
            }
        }
    }
    public void transpon(){
        double k = this.a[1][0];
        this.a[1][0] = this.a[0][1];
        this.a[0][1] = k;
    }
    public Matrix2x2 inverseMatrix( ){
        Matrix2x2 c = new Matrix2x2();
        if (this.det() == 0) {
            System.out.println("Определитель = 0, обратной матрицы нет!!!!");
            return c;
        }
        for (int i = 0; i < 2; i++){
            for (int i2 = 0; i2 < 2; i2++){
                c.a[i][i2] = this.a[1 - i][1 - i2] * Math.pow(-1, i + i2);
            }
        }
        c.transpon();
        c.multNumber2(1.0 / this.det());
        return c;
    }
    public Matrix2x2 equivalentDiagonal(){
        Matrix2x2 c = new Matrix2x2();
        if (this.a[1][0] == 0 & this.a[0][1] == 0){
            c.a = this.a;
            return  c;
        }
        c.a[0][0] = this.a[0][0] - this.a[1][0] * this.a[0][1] / this.a[1][1];
        c.a[1][1] = this.a[1][1] - this.a[1][0] * this.a[0][1] / this.a[0][0];
        return  c;
    }
    public Vector2D multVector(Vector2D b){
        Vector2D v = new Vector2D();
        v.setX((this.a[0][0] * b.getX() + this.a[0][1])* b.getY());
        v.setY((this.a[1][0] * b.getX() + this.a[1][1])* b.getY());
        return v;
    }
    public boolean equals(Matrix2x2 matrix2x2){
        return this.getA(0,0)==matrix2x2.getA(0,0)&
                this.getA(0,1)==matrix2x2.getA(0,1)&
                this.getA(1,0)==matrix2x2.getA(1,0)&
                this.getA(1,1)==matrix2x2.getA(1,1);
    }
    public String toString(){
        return (a[0][0] + " " + a[0][1]+ "\n" + a[1][0] + " " + a[1][1]);
    }

}

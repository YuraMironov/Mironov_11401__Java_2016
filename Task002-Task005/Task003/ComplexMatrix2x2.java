package Homework1.Task003;


/**
 * Created by Yura Mironov
 * 11-401
 * 056
 */
public class ComplexMatrix2x2 {
    ComplexNumber[][] a = new ComplexNumber[2][2];
    public  ComplexMatrix2x2(){
        this(new ComplexNumber());
    }
    public  ComplexMatrix2x2(ComplexNumber k){
        for(int i = 0; i < 2; i++){
            for (int i2 = 0; i2 < 2; i2++){
                this.a[i][i2] = new ComplexNumber(k.getA(), k.getB());
            }
        }
    }
    public ComplexMatrix2x2(ComplexNumber k1, ComplexNumber k2, ComplexNumber k3, ComplexNumber k4){
        for(int i = 0; i < 2; i++){
            for (int i2 = 0; i2 < 2; i2++){
                this.a[i][i2] = new ComplexNumber();
                this.a[0][0] = k1;
                this.a[0][1] = k2;
                this.a[1][0] = k3;
                this.a[1][1] = k4;
            }
        }
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 b){
        ComplexMatrix2x2 c = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                c.a[i][i2] = this.a[i][i2].add(b.a[i][i2]);
            }
        }
        return  c;
    }
    public ComplexMatrix2x2 mult(ComplexMatrix2x2 b){
        ComplexMatrix2x2 c = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                for (int i3 = 0; i3 <2; i3++){
                    ComplexNumber sl = this.a[i][i3].mult(b.a[i3][i2]);
                    c.a[i][i2] = c.a[i][i2].add(sl);
                }
            }
        }
        return  c;
    }
    public ComplexNumber det(){
        ComplexNumber c;
        c = this.a[0][0].mult(this.a[1][1]).sub(this.a[0][1].mult(this.a[1][0]));
        return  c;
    }
    public ComplexVector2D multVector(ComplexVector2D b){
        ComplexVector2D v = new ComplexVector2D();
        v.setX((this.a[0][0].mult(b.getX())).add(this.a[0][1].mult(b.getY())));
        v.setY((this.a[1][0].mult(b.getX())).add(this.a[1][1].mult(b.getY())));
        return v;
    }
    public String toString(){
        return (a[0][0] + " " + a[0][1]+ "\n" + a[1][0] + " " + a[1][1]);
    }
    @Override
    public boolean equals(Object o) {
        ComplexMatrix2x2 cm = (ComplexMatrix2x2) o;
        return this.a[0][0].equals(cm.a[0][0])&this.a[0][1].equals(cm.a[0][1])&
                this.a[1][0].equals(cm.a[1][0])&this.a[1][1].equals(cm.a[1][1]);
    }


    public static void main(String[] args) {
        ComplexNumber c = new ComplexNumber(1, 4);
        ComplexMatrix2x2 a = new ComplexMatrix2x2(c);
        ComplexMatrix2x2 b = new ComplexMatrix2x2(c, c, c, c);
        ComplexMatrix2x2 e = a;
        System.out.println(e.add(b));
        e = a;
        System.out.println(e.mult(b));
        System.out.println(a.det());
        System.out.println(b.det());
        ComplexNumber x  = new ComplexNumber(1,4);
        ComplexNumber y  = new ComplexNumber(3,4);
        ComplexVector2D rv = new ComplexVector2D(x,y);
        System.out.println(a.multVector(rv));
        System.out.println(b.multVector(rv));
    }
}

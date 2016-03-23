package Homework1.Task009;

/**
 * Created by Yura Mironov
 * 11-401
 * 054
 */
public class ComplexVector2D {
    private ComplexNumber x;
    private ComplexNumber y;
    public ComplexNumber getX(){
        return x;
    }
    public ComplexNumber getY(){
        return y;
    }
    public void setX(ComplexNumber x){
        this.x = x;
    }
    public void setY(ComplexNumber y){
        this.y = y;
    }
    public ComplexVector2D(){
        this( new ComplexNumber(), new ComplexNumber());
    }
    public ComplexVector2D(ComplexNumber aa, ComplexNumber bb){
        this.x = aa;
        this.y = bb;
    }
    public ComplexVector2D add(ComplexVector2D v2){
        ComplexVector2D a = new ComplexVector2D();
        a.x = this.x.add(v2.x);
        a.y = this.y.add(v2.y);
        return a;
    }
    public String toString(){
        return ("{" + getX() + ", " + getY() + "}");
    }
    public ComplexNumber scalarProduct(ComplexVector2D v1){
        ComplexNumber c;
        ComplexNumber d;
        c = this.x.mult(v1.x);
        d = this.y.mult(v1.y);
        return (c.add(d));
    }
    @Override
    public boolean equals(Object o){
        ComplexVector2D aa = (ComplexVector2D) o;
        return  (this.getX().equals(aa.getX()) & this.getY().equals(aa.getY()));
    }
    public static void main(String[] args) {
        ComplexVector2D cv = new ComplexVector2D( new ComplexNumber(1, 4), new ComplexNumber(3, 4) );
        ComplexVector2D cv2 = cv;
        ComplexVector2D cv3 = cv;
        System.out.println(cv3.scalarProduct(cv2));
        System.out.println(cv.equals(cv2));
        System.out.println(cv.add(cv2));

    }
}

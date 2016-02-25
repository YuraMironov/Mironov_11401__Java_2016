package Homework1.Task003;

/**
 * Created by Yura Mironov
 * 11-401
 * ru.kpfu.itis.group401.Mironov.Task051
 */
public class ComplexNumber {
    private double a;
    private double b;
    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public ComplexNumber() {
        this(0, 0);
    }
    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public void setA(double aa) {
        this.a = aa;
    }
    public void setB(double aa) {
        this.b = aa;
    }
    public void add2(ComplexNumber bb) {
        this.a += bb.getA();
        this.b += bb.getB();
    }
    public ComplexNumber add(ComplexNumber bb) {
        ComplexNumber cn3 = new ComplexNumber(this.getA() + bb.getA(), this.getB() + bb.getB());
        return cn3;
    }
    public String toString() {
        String a = "";
        if (this.getA() == 0){
            if (this.getB() > 0)
                return (this.getB() + "*i") ;
            if (this.getB() == 0)
                return ("0");
            if (this.getB() == 1)
                return ("i");
            if (this.getB() == -1)
                return ("-i");
        }
        if (this.getB() > 0)
            a = "+";
        if (this.getB() == 0)
            return ("" + this.getA());
        if (this.getB() == 1)
            return (this.getA() + "+i");
        if (this.getB() == -1)
            return (this.getA() +"*-i");
        return (this.getA() + a + this.getB() + "*i");
    }
    @Override
    public boolean equals(Object o) {
        ComplexNumber bb = (ComplexNumber) o;
        return (this.getA() == bb.getA() & this.getB() == bb.getB());
    }
    public ComplexNumber div(ComplexNumber bb) {
        double a;
        double b;
        a = (this.getA() * bb.getA() + this.getB() * bb.getB()) / (bb.getA()*bb.getA() + bb.getB() * bb.getB());
        b = (this.getB() * bb.getA() - this.getA() * bb.getB()) / (bb.getA()*bb.getA() + bb.getB() * bb.getB());
        ComplexNumber cn3 = new ComplexNumber(a, b);
        return cn3;
    }
    public void div2(ComplexNumber bb) {
        double a = (this.getA() * bb.getA() + this.getB() * bb.getB()) / (bb.getA()*bb.getA() + bb.getB() * bb.getB());
        this.setB((this.getB() * bb.getA() - this.getA() * bb.getB()) / (bb.getA() * bb.getA() + bb.getB() * bb.getB()));
        this.setA(a);

    }
    public ComplexNumber mult(ComplexNumber bb) {
        double a = this.getA() * bb.getA() - this.getB() * bb.getB();
        double b = this.getA() * bb.getB() + this.getB() * bb.getA();
        ComplexNumber cn3 = new ComplexNumber(a, b);
        return cn3;
    }
    public void mult2(ComplexNumber bb) {
        double a = this.getA() * bb.getA() - this.getB() * bb.getB();
        this.setB(this.getA() * bb.getB() + this.getB() * bb.getA());
        this.setA(a);
    }
    public void sub2( ComplexNumber bb) {
        this.a -= bb.a;
        this.b -= bb.b;
    }
    public ComplexNumber sub( ComplexNumber bb) {
        ComplexNumber cn3 = new ComplexNumber(this.getA() - bb.getA(), this.getB() - bb.getB());
        return cn3;
    }
    public ComplexNumber multNumber(double k){
        ComplexNumber cc = new ComplexNumber();
        cc.setA(this.getA() * k);
        cc.setB(this.getB() * k);
        return  cc;
    }
    public void multNumber2(double k){
        this.setA(this.getA() * k);
        this.setB(this.getB() * k);
    }
    public double length() {
        return (Math.sqrt(this.getA() * this.getA() + this.getB() * this.getB()));
    }
    public double cos() {
        return this.getA() / this.length();
    }
    public double sin() {
        return this.getB() / this.length();
    }
    public double arg() {
        if (this.cos() == 1)
            return 0;
        if (this.sin() == 1)
            return 90;
        double a = (180 / 3.14 * Math.atan(this.getB() / this.getA()));
        return a;
    }
    public ComplexNumber pow(double n) {
        double c = this.arg() * n * 3.14 / 180;
        double a = (Math.pow(this.length(),n)) * Math.cos(c);
        double b = Math.pow(this.length(),n) * Math.sin(c);
        ComplexNumber cn3 = new ComplexNumber(a,b);
        return cn3;
    }
    public void pow2(double n) {
        double c = this.arg() * n*3.14/180;
        double a = Math.pow(this.length(),n) * Math.cos(c);
        this.setB(Math.pow(this.length(), n) * Math.sin(c));
        this.setA(a);
    }
}
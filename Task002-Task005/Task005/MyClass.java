package Homework1.Task005;

/**
 * Created by ��� on 26.11.2015.
 */
public class MyClass implements Comparable{
    private int  x;
    private int y;
    public MyClass(int x, int y){
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        return  this.getX() == ((MyClass)o).getX() && this.getY() == ((MyClass)o).getY() ? 0 : 1;
    }
    @Override
    public boolean equals(Object o){
        return this.getX() == ((MyClass)o).getX() && this.getY() == ((MyClass)o).getY();
    }
    public  String toString(){
        return getX() + " " + getY();
    }
}

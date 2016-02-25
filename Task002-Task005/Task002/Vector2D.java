package Homework1.Task002;

/**
 * Created by Юра on 24.02.2016.
 */
public class Vector2D {
    private double x;
    private double y;

    public Vector2D() {
    }

    public Vector2D(double x, double y) {

        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector2D vector2D = (Vector2D) o;

        if (Double.compare(vector2D.x, x) != 0) return false;
        if (Double.compare(vector2D.y, y) != 0) return false;

        return true;
    }

}

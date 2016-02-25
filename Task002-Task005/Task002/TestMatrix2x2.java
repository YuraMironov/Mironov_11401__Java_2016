package Homework1.Task002;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Юра on 24.02.2016.
 */
public class TestMatrix2x2 {
    private final double EPS = 1e-9;
    static Matrix2x2 simpleMatrix2x2;
    static Matrix2x2 notSimpleMatrix2x2;
    static Matrix2x2 identityMatrix2x2;
    Matrix2x2 m;

    @BeforeClass
    public static void beforeClass() {
        simpleMatrix2x2 = new Matrix2x2();
        notSimpleMatrix2x2 = new Matrix2x2(1, 2, 3, 4);
        identityMatrix2x2 = new Matrix2x2(1, 0, 0, 1);
    }
    @Test
    public void defaultMatrix2x2ShouldHaveZeroDeterminant() {
        Assert.assertEquals(0, simpleMatrix2x2.det(), EPS);
    }
    @Test
    public void firstParamOfConstructorShouldBeSavedInMatrix2x2() {
        Assert.assertEquals(1, notSimpleMatrix2x2.getA(0, 0), EPS);
    }
    @Test
    public void secondParamOfConstructorShouldBeSavedInMatrix2x2() {
        Assert.assertEquals(2, notSimpleMatrix2x2.getA(0, 1), EPS);
    }
    @Test
    public void thirdParamOfConstructorShouldBeSavedInMatrix2x2() {
        Assert.assertEquals(3, notSimpleMatrix2x2.getA(1, 0), EPS);
    }
    @Test
    public void fourthParamOfConstructorShouldBeSavedInMatrix2x2() {
        Assert.assertEquals(4, notSimpleMatrix2x2.getA(1, 1), EPS);
    }
    @Test
    public void sumMatrix2x2ShouldBeCorrect() {
        m = notSimpleMatrix2x2.add(identityMatrix2x2);
        Assert.assertTrue(m.equals(new Matrix2x2(2, 2, 3, 5)));
    }
    @Test
    public void sum2Matrix2x2ShouldBeCorrect() {
        notSimpleMatrix2x2.add2(identityMatrix2x2);
        Assert.assertTrue(notSimpleMatrix2x2.equals(new Matrix2x2(2, 2, 3, 5)));
    }
    @Test
    public void subMatrix2x2ShouldBeCorrect() {
        m = notSimpleMatrix2x2.sub(identityMatrix2x2);
        Assert.assertTrue(m.equals(new Matrix2x2(0, 2, 3, 3)));
    }
    @Test
    public void sub2Matrix2x2ShouldBeCorrect() {
        notSimpleMatrix2x2.sub2(identityMatrix2x2);
        Assert.assertTrue(notSimpleMatrix2x2.equals(new Matrix2x2(1, 2, 3, 4)));
    }
    @Test
    public void multMatrix2x2ShouldBeCorrect() {
        m = notSimpleMatrix2x2.mult(identityMatrix2x2);
        Assert.assertTrue(notSimpleMatrix2x2.equals(m));
    }
    @Test
    public void mult2Matrix2x2ShouldBeCorrect() {
        notSimpleMatrix2x2.mult2(identityMatrix2x2);
        Assert.assertTrue(notSimpleMatrix2x2.equals(new Matrix2x2(1, 2, 3, 4)));
    }
    @Test
    public void correctTranspMatrix2x2() {
        m = new Matrix2x2(1, 3, 2, 4);
        m.transpon();
        Assert.assertTrue(m.equals(notSimpleMatrix2x2));
    }
    @Test
    public void multNumberMatrix2x2ShouldBeCorrect() {
        Assert.assertTrue(notSimpleMatrix2x2.multNumber(2).equals(new Matrix2x2(2, 4, 6, 8)));
    }
    @Test
    public void multNumber2Matrix2x2ShouldBeCorrect() {
        m = new Matrix2x2(2, 4, 6, 8);
        m.multNumber2(0.5);
        Assert.assertTrue(m.equals(notSimpleMatrix2x2));
    }
    @Test
    public void inverseMatrixShouldBeCorrect() {
        m = notSimpleMatrix2x2.inverseMatrix();
        Assert.assertTrue(identityMatrix2x2.equals(notSimpleMatrix2x2.mult(m)));
    }
    @Test
    public void equivalentDiagonalMatrix2x2ShouldBeCorrect() {
        m = notSimpleMatrix2x2.equivalentDiagonal();
        Assert.assertTrue(m.equals(new Matrix2x2(1, 0, 0, -2)));
    }
    @Test
    public void multVectorMatrix2x2ShouldBeCorrect() {
        Vector2D v = notSimpleMatrix2x2.multVector(new Vector2D(1, 1));
        Assert.assertTrue(v.equals(new Vector2D(3, 7)));
    }
}

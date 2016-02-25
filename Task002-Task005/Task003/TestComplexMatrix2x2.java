package Homework1.Task003;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 24.02.2016.
 */
public class TestComplexMatrix2x2 {
    static ComplexMatrix2x2 simpleComplexMatrix2x2;
    static ComplexMatrix2x2 notSimpleComplexMatrix2x2;
    static ComplexNumber a;
    static ComplexNumber b;
    static ComplexNumber c;
    static ComplexNumber d;
    static ComplexNumber simpleComplexNumber;
    ComplexMatrix2x2 m;

    @BeforeClass
    public static void beforeClass() {
        simpleComplexNumber = mock(ComplexNumber.class);
        when(simpleComplexNumber.toString()).thenCallRealMethod();
        a = mock(ComplexNumber.class);
        when(a.getA()).thenReturn(1.0);
        when(a.getB()).thenReturn(1.0);
        when(a.toString()).thenCallRealMethod();
        when(a.multNumber(anyDouble())).thenCallRealMethod();
        when(a.add((ComplexNumber)anyObject())).thenCallRealMethod();
        b = mock(ComplexNumber.class);
        when(b.getA()).thenReturn(2.0);
        when(b.getB()).thenReturn(2.0);
        when(b.toString()).thenCallRealMethod();
        when(b.multNumber(anyDouble())).thenCallRealMethod();
        when(b.add((ComplexNumber)anyObject())).thenCallRealMethod();
        c = mock(ComplexNumber.class);
        when(c.getA()).thenReturn(3.0);
        when(c.getB()).thenReturn(3.0);
        when(c.toString()).thenCallRealMethod();
        when(c.multNumber(anyDouble())).thenCallRealMethod();
        when(c.add((ComplexNumber)anyObject())).thenCallRealMethod();
        d = mock(ComplexNumber.class);
        when(d.getA()).thenReturn(4.0);
        when(d.getB()).thenReturn(4.0);
        when(d.toString()).thenCallRealMethod();
        when(d.multNumber(anyDouble())).thenCallRealMethod();
        when(d.add((ComplexNumber) anyObject())).thenCallRealMethod();
        simpleComplexMatrix2x2 = new ComplexMatrix2x2();
        notSimpleComplexMatrix2x2 = new ComplexMatrix2x2(a, b, c, d);
    }



    @Test
    public void defaultComplexMatrix2x2ShouldHaveZeroDeterminant() {
        Assert.assertTrue(simpleComplexMatrix2x2.det().equals(simpleComplexNumber));
    }
    @Test
    public void firstParamOfConstructorShouldBeSavedInMatrix2x2() {
        Assert.assertEquals("1.0+i", notSimpleComplexMatrix2x2.a[0][0].toString());
    }
    @Test
    public void secondParamOfConstructorShouldBeSavedInMatrix2x2() {
        Assert.assertEquals("2.0+2.0*i", notSimpleComplexMatrix2x2.a[0][1].toString());
    }
    @Test
    public void thirdParamOfConstructorShouldBeSavedInMatrix2x2() {
        Assert.assertEquals("3.0+3.0*i", notSimpleComplexMatrix2x2.a[1][0].toString());
    }
    @Test
    public void fourthParamOfConstructorShouldBeSavedInMatrix2x2() {
        Assert.assertEquals("4.0+4.0*i", notSimpleComplexMatrix2x2.a[1][1].toString());
    }
    @Test
    public void sumComplexMatrix2x2ShouldBeCorrect(){
        Assert.assertEquals(new ComplexMatrix2x2(a.multNumber(2), b.multNumber(2), c.multNumber(2), d.multNumber(2)),
                notSimpleComplexMatrix2x2.add(notSimpleComplexMatrix2x2));
    }
    @Test
    public void multComplexMatrix2x2ShouldBeCorrect(){
        ComplexNumber x = mock(ComplexNumber.class);
        when(x.getA()).thenReturn(1.0);
        when(x.getB()).thenReturn(0.0);
        Assert.assertTrue(notSimpleComplexMatrix2x2.mult(
                new ComplexMatrix2x2(x, simpleComplexNumber, simpleComplexNumber, x)
        ).equals(notSimpleComplexMatrix2x2));
    }
    @Test
    public void multComplexVector2DShouldBeCorrect(){

        ComplexNumber x = mock(ComplexNumber.class);
        when(x.toString()).thenCallRealMethod();
        when(x.getA()).thenReturn(1.0);
        when(x.getB()).thenReturn(0.0);

        ComplexVector2D cv = mock(ComplexVector2D.class);
        when(cv.getX()).thenReturn(x);
        when(cv.getY()).thenReturn(x);
        when(cv.toString()).thenCallRealMethod();

        ComplexNumber y = mock(ComplexNumber.class);
        when(y.getA()).thenReturn(7.0);
        when(y.getB()).thenReturn(7.0);
        when(y.toString()).thenCallRealMethod();

        ComplexVector2D cvResult = mock(ComplexVector2D.class);
        when(cvResult.getX()).thenReturn(c);
        when(cvResult.getY()).thenReturn(y);
        when(cvResult.toString()).thenCallRealMethod();

        Assert.assertTrue(notSimpleComplexMatrix2x2.multVector(cv).equals(cvResult));
    }
}

package Homework1.Task009;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.mockito.Mockito.mock;

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
    static ApplicationContext ac;


    @BeforeClass
    public static void beforeClass() {
        ac = new ClassPathXmlApplicationContext("Homework1/Task009/spring-config.xml");
        simpleComplexNumber = ac.getBean("simpleComplexNumber", ComplexNumber.class);
        a = ac.getBean("a", ComplexNumber.class);
        b = ac.getBean("b", ComplexNumber.class);
        c = ac.getBean("c", ComplexNumber.class);
        d = ac.getBean("d", ComplexNumber.class);
        simpleComplexMatrix2x2 = ac.getBean("simpleComplexMatrix2x2", ComplexMatrix2x2.class);
        notSimpleComplexMatrix2x2 = ac.getBean("notSimpleComplexMatrix2x2", ComplexMatrix2x2.class);
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
        ComplexNumber x = ac.getBean("complexNumber10", ComplexNumber.class);
        Assert.assertTrue(notSimpleComplexMatrix2x2.mult(
                new ComplexMatrix2x2(x, simpleComplexNumber, simpleComplexNumber, x)
        ).equals(notSimpleComplexMatrix2x2));
    }
    @Test
    public void multComplexVector2DShouldBeCorrect(){

        ComplexVector2D cv = ac.getBean("complexVector2D", ComplexVector2D.class);


        ComplexVector2D cvResult = ac.getBean("resComplexVector2D", ComplexVector2D.class);

        Assert.assertTrue(notSimpleComplexMatrix2x2.multVector(cv).equals(cvResult));
    }
}

package be.pxl;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorSumTest {

    private Calculator calculator = new Calculator();

    @Test
    public void telTweeGetallenOp(){
        assertEquals("Som van 2 getallen", 5, calculator.sum(2,3));
    }

    @Test
    @Ignore
    public void telTweeAndereGetallenOp(){
        assertEquals("Som van 2 getallen", 6, calculator.sum(2,4));
    }

}

package be.pxl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatorMetDependenciesTest {

    private class MockCalc implements ScientificCalculator {
        @Override
        public double powerOfTwo(int a) {
            return 9;
        }
    }

    public Calculator calculator = new Calculator();

    @Before
    public void before(){
        calculator.setScientificCalculator(new MockCalc());
    }

    @Test
    public void pow(){
        assertEquals(9, calculator.powerOfTwo(3), 2);
    }

    public void failsIf1O(){
        assertFalse(calculator.powerOfTwo(3) == 9);
    }

}
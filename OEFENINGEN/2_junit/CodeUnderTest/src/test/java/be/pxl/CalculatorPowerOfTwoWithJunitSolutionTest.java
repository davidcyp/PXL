package be.pxl;

import org.junit.Test;

public class CalculatorPowerOfTwoWithJunitSolutionTest {

    private Calculator calculator;

    private class MockScientificCalculator implements ScientificCalculator{
        @Override
        public double powerOfTwo(int a) {
            return 0;
        }
    }

    @Test
    public void testCalculatorDelegatesToScientificCalculator(){
        MockScientificCalculator scientificCalculator = new MockScientificCalculator();
        calculator = new Calculator();
        calculator.setScientificCalculator(scientificCalculator);
        calculator.powerOfTwo(3);
    }
}

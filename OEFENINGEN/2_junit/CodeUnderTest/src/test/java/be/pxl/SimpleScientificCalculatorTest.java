package be.pxl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class SimpleScientificCalculatorTest {

    private SimpleScientificCalculator calculator = new SimpleScientificCalculator();



    @Test
    public void powerOf3Is9(){
         assertEquals(9, calculator.powerOfTwo(3));
    }

}
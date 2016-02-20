package be.pxl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorPowerOfTwoWithMockitoSolutionTest {

    /**
     * Maakt een mock versie aan, waarvan we het gedrag in onze test zelf naar de hand kunnen zetten
     */
    @Mock
    private ScientificCalculator scientificCalculator;

    /**
     * Maakt een Calculator object aan, en injecteert (dependency injection) een gemockte versie van ScientificCalculatr
     */
    @InjectMocks
    private Calculator calculator;

    @Test
    public void testCalculatorDelegatesToScientificCalculator(){
        calculator.powerOfTwo(3);

        /**
         * Verifieer of onze calculator achter de schermen wel de methode #powerOfTwo aanroept op de scientific calculator
         */
        Mockito.verify(scientificCalculator).powerOfTwo(3);
    }
}

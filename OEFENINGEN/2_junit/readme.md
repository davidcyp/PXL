# JUNIT
## Oefening 1: Schrijf je eerste test

  - Open project: CodeUnderTest
  - Bekijk de class Calculator
  - Ga naar de class CalculatorTest (kijk goed in welke folder die staat)
  - Start de test van uit je IDE of via de command line met het commando mvn clean test
  - De test faalt
  - Fix de code
  - Draai de test opnieuw, de test zou nu moeten slagen

## Oefening 2: 
 
 - Schrijf een test voor Calculator#minus

## Oefening 3:

  - Schrijf een test en gebruik een JUnit mock voor Calculator#powerOfTwo

## Oefening 4: 

  - Ga naar CalculatorPowerOfTwoWithMockitoSolutionTest
  - Voer de test uit (resultaat: geslaagd)
  - Vervang de '3' in lijn Mockito.verify(scientificCalculator).powerOfTwo(3); door een andere waarde, en voer de test opnieuw uit
  - De test faalt nu
  - Zet de waarde terug op 3
  - Verwijder de @Mock annotatie boven de scientificCalculator
  - Voer de test uit, ze zal nu falen omdat scientificCalculator nog niet geinstantieerd is (dit gebeurt automatisch door er de @Mock annotatie boven te plaatsen)
  
## Oefening 5:

- Ga naar be.pxl.les2.api_begrijpen
- Schrijf een test voor elke methode (en leer zo oa de api begrijpen, je kan nl. geen wagen starten zonder dat er brandstof in de wagen is)

## Oefening 6 : http://osherove.com/tdd-kata-1/

## EXTRA: zie https://app.pluralsight.com/library/courses/java-unit-testing-junit/exercise-files

package be.pxl;

public class Calculator {

    private ScientificCalculator scientificCalculator;

    public int sum(int a, int b){
        return 1 + a + b;
    }

    public int minus(int a, int b){
        return a - b;
    }

    public double powerOfTwo(int a){
       return scientificCalculator.powerOfTwo(a);
    }

    public void setScientificCalculator(ScientificCalculator scientificCalculator){
        this.scientificCalculator = scientificCalculator;
    }
}

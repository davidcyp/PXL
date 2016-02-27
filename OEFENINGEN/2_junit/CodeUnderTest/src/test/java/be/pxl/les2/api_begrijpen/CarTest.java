package be.pxl.les2.api_begrijpen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CarTest {

    private final static int INITIAL_FUEL_LEVEL = 10;

    private Car car;
    private Car carWithFuel;

    @Before
    public void before(){
        this.car = new Car();
        this.carWithFuel = new Car(INITIAL_FUEL_LEVEL);
    }

    @Test
    @Ignore
    public void startDeWagen(){
        car.startEngine();
        Assert.assertTrue(car.engineIsStarted());
    }        b

    @Test(expected = NotEnoughFuelException.class)
    @Ignore
    public void wagenKanNietStartenAlsErNietVoldoendeBrandstofInDeTankZit(){
        car.startEngine();
    }

    @Test
    public void wagenKanStartenAlsErBrandstofInDeTankZit(){
        carWithFuel.startEngine();
        Assert.assertTrue(carWithFuel.engineIsStarted());
    }

    @Test
    public void wagenKanRijdenAlsDeMotorGestartIs(){

    }

    @Test
    public void wagenKanNietRijdenAlsDeMotorUitStaat(){

    }


}

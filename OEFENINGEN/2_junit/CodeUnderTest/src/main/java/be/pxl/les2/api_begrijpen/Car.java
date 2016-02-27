package be.pxl.les2.api_begrijpen;

public class Car {

    private int fuelLevel = 0;
    private boolean engineStarted = false;
    private boolean driving = false;

    public Car(){

    }

    public Car(int fuelLevel){
        this.fuelLevel = fuelLevel;
    }

    public void startEngine(){
         if(fuelLevel < 1){
             throw new NotEnoughFuelException();
         }
        this.engineStarted = true;
    }

    public void stopEngine(){
        if(!driving){
            this.engineStarted = false;
        }
    }

    public void startDriving(){
        if(!engineStarted){
            throw new EngineNotStartedException();
        }
        this.driving = true;
    }

    public void stopDriving(){
        this.driving = false;
    }

    public boolean isDriving(){
        return this.driving;
    }

    public boolean engineIsStarted(){
        return this.engineStarted;
    }

    public void addFuel(int level){
        fuelLevel+=level;
    }

    public int getFuelLevel(){
        return fuelLevel;
    }

}

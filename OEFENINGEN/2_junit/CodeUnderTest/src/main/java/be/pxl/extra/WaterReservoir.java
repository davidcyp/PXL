package be.pxl.extra;

public class WaterReservoir {

    private int liters = 0;

    public void addWater(int liters){
        this.liters = this.liters + liters;
    }

    public boolean isEmpty(){
        return this.liters == 0;
    }

    public int verbruikWater(int verbruik){
        if(liters >= verbruik){
            liters = liters - verbruik;
            return verbruik;
        } else {
            int effectiefVerbruikt = verbruik - liters;
            liters = 0;
            return effectiefVerbruikt;
        }
    }
}

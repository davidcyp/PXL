package be.pxl.extra;

public class KoffieMachine {

    private WaterReservoir waterReservoir = new WaterReservoir();

    public int zetKoffie(int aantalLitersGewensteKoffie){
        return waterReservoir.verbruikWater(aantalLitersGewensteKoffie);
    }

    public void setWaterReservoir(WaterReservoir waterReservoir){
        this.waterReservoir = waterReservoir;
    }
}

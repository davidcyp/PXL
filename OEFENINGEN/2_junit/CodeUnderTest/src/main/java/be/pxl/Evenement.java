package be.pxl;

public class Evenement {

    private ToegangsControle toegangsControle;

    public boolean laatPersoonBinnen(Persoon persoon){
        if(toegangsControle.isMeerderjarig(persoon)){
            return true;
        }
        return false;
    }
}

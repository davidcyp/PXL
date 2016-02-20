package be.pxl;

public class Persoon implements Mens{

    private int leeftijd;

    public Persoon(int leeftijd){
        this.leeftijd = leeftijd;
    }

    @Override
    public int getLeeftijd(){
        return leeftijd;
    }
}

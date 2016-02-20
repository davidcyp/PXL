package be.pxl;

public class Deur {

    boolean open = false;
    boolean geblokkeerd = false;

    public void open(){
        open = true;
    }

    public boolean isGeblokkeerd(){
        return geblokkeerd;
    }

    public boolean isOpen(){
        return open;
    }

    public void blokkeer(String paswoord){
        if(paswoord != "geheim"){
            throw new KanDeurNietBlokkerenException();
        }
        geblokkeerd = true;
    }
}

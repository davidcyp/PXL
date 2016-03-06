package be.pxl.jdbc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Oefening1Test {

    private Oefening1 oefening1;

    @Before
    public void setup(){
        oefening1 = new Oefening1();
    }

    @Test
    public void maakConnectieEnVoegJeNaamToeAanDeLeerlingenTabel(){
        Assert.assertEquals(1, oefening1.maakConnectie());
    }
}

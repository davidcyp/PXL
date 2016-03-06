package be.pxl;

import org.junit.Assert;
import org.junit.Test;

public class RekenmachineTest {
    private Rekenmachine rekenmachine = new Rekenmachine();

    @Test
    public void tel2getallenOp(){
        Assert.assertEquals(rekenmachine.tel2getallenOp(1,3), 4);
    }

    @Test
    public void minus(){
        Assert.assertEquals(rekenmachine.minus(4,3), 1);
    }

}

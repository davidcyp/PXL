package be.pxl.jdbc;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Oefening2Test {

    private Oefening2 oefening2;

    @Before
    public void setup(){
        oefening2 = new Oefening2();
    }

    @Test
    public void maakConnectieEnVoegJeNaamToeAanDeLeerlingenTabel() throws Exception {
        Assertions.assertThat(oefening2.haalAlleTechoDeejaysOp())
                .contains("carl cox", "loco dice", "richie hawtin")
                .doesNotContain("dj jos", "angerfist");    }
}

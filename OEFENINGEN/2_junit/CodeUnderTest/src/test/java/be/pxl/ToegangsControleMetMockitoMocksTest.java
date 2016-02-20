package be.pxl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ToegangsControleMetMockitoMocksTest {

    @Mock
    private Persoon persoon;

    @InjectMocks
    private ToegangsControle toegangsControle;


    @Test
    public void meerderjarigPersoonMagBinnen() {
        Mockito.when(persoon.getLeeftijd()).thenReturn(19);
        Assert.assertTrue("meerderjarig persoon mag binnen", toegangsControle.isMeerderjarig(persoon));
    }

    @Test
    public void minderjarigPersoonWordtToegangGeweigerd() {
        Mockito.when(persoon.getLeeftijd()).thenReturn(16);
        Assert.assertFalse(toegangsControle.isMeerderjarig(persoon));
    }
}

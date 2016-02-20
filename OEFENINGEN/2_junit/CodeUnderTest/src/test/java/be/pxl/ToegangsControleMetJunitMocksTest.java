package be.pxl;

import be.pxl.junitmocks.MeerderjarigePersoonMock;
import be.pxl.junitmocks.MinderjarigePersoonMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

public class ToegangsControleMetJunitMocksTest {

    private MinderjarigePersoonMock minderjarige = new MinderjarigePersoonMock();
    private MeerderjarigePersoonMock meerderjarige = new MeerderjarigePersoonMock();

    private ToegangsControle toegangsControle = new ToegangsControle();

    @Test
    public void meerderjarigPersoonMagBinnen() {
        Assert.assertTrue("meerderjarig persoon mag binnen", toegangsControle.isMeerderjarig(meerderjarige));
    }

    @Test
    public void minderjarigPersoonWordtToegangGeweigerd() {
        Assert.assertFalse(toegangsControle.isMeerderjarig(minderjarige));
    }
}

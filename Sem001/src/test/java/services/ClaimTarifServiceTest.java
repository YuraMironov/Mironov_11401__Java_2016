package services;

import org.junit.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ru.kpfu.itis.Mironov.SE.entities.ClaimTarif;
import ru.kpfu.itis.Mironov.SE.repositories.ClaimsTarifRepository;
import ru.kpfu.itis.Mironov.SE.services.ClaimTarifService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyByte;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 14.05.2016.
 */
public class ClaimTarifServiceTest {
    private static List<ClaimTarif> claimsTarif;
    private static ClaimTarifService claimTarifService;
    private static ClaimTarif tempClaimTarif;
    @BeforeClass
    public static void before(){
        claimsTarif = new ArrayList<ClaimTarif>();
        claimTarifService = new ClaimTarifService();
        claimTarifService.claimsTarifRepository = mock(ClaimsTarifRepository.class);
        for (int i = 0; i < 3; i++) {
            ClaimTarif ct = mock(ClaimTarif.class);
            when(ct.getId()).thenReturn(i);
            claimsTarif.add(ct);
        }
        when(claimTarifService.claimsTarifRepository.findAll()).thenReturn(claimsTarif);
    }
    @Before
    public void beforeMethod(){
        claimsTarif = claimTarifService.getAll();
    }
    @Test
    public void methodGetAllShouldBeCorrectWork(){
        Assert.assertEquals(claimsTarif.size(), claimTarifService.claimsTarifRepository.findAll().size());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void methodDeleteShouldBeCorrectWork(){
        tempClaimTarif = claimTarifService.getAll().get(2);
        claimTarifService.getAll().remove(2);
        Assert.assertNotEquals(claimTarifService.getAll().get(2), tempClaimTarif);
    }
    @Test
    public void methodAddShouldBeCorrectWork(){
        claimsTarif.add(mock(ClaimTarif.class));
        when(claimTarifService.addEntity(any(ClaimTarif.class))).thenReturn(claimsTarif.set(2, tempClaimTarif));
        claimTarifService.addEntity(tempClaimTarif);
        Assert.assertEquals(claimTarifService.getAll().get(2), tempClaimTarif);
    }

}

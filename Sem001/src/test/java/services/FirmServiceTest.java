package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Mironov.SE.entities.Firm;
import ru.kpfu.itis.Mironov.SE.repositories.FirmsRepository;
import ru.kpfu.itis.Mironov.SE.services.FirmService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 14.05.2016.
 */
public class FirmServiceTest {
    private static List<Firm> firms;
    private static FirmService firmService;
    private static Firm tempFirm;

    @BeforeClass
    public static void before() {
        firms = new ArrayList<>();
        firmService = new FirmService();
        for (int i = 0; i < 12; i++) {
            Firm firm = mock(Firm.class);
            when(firm.getIdFirm()).thenReturn(new Long(i));
            firms.add(firm);
        }
        firmService.firmsRepository = mock(FirmsRepository.class);
        when(firmService.firmsRepository.findAll()).thenReturn(firms);
        when(firmService.firmsRepository.findByIdFirm(5L)).thenReturn(firms.get(5));

    }

    @Before
    public void beforeMethods() {
        firms = firmService.getAll();
    }

    @Test
    public void methodGetAllShouldBeCorrectWork() {
        Assert.assertEquals(firmService.getAll(), firms);
    }

    @Test
    public void methodGet10NewsByPageNumberShouldBeCorrectWork() {
        Assert.assertEquals(firmService.get10NewsByPageNumber(2), firms.subList(10, firms.size()));
    }
    @Test
    public void methodFindByIdFirmShouldBeCorrectWork(){
        Assert.assertEquals(firmService.getById(5L), firms.get(5));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void methodDeleteShouldBeCorrectWork(){
        tempFirm = firmService.getAll().get(11);
        firmService.getAll().remove(11);
        Assert.assertNotEquals(firmService.getAll().get(11), tempFirm);
    }
    @Test
    public void methodAddShouldBeCorrectWork(){
        firms.add(mock(Firm.class));
        when(firmService.addEntity(any(Firm.class))).thenReturn(firms.set(11, tempFirm));
        firmService.addEntity(tempFirm);
        Assert.assertEquals(firmService.getAll().get(11), tempFirm);
    }
}

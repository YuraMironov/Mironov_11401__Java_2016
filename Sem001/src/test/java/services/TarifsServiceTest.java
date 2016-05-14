package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;
import ru.kpfu.itis.Mironov.SE.repositories.TarifsRepository;
import ru.kpfu.itis.Mironov.SE.services.TarifsService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 14.05.2016.
 */
public class TarifsServiceTest {
    private static List<Tarif> tarifs;
    private static TarifsService tarifsService;
    private static Tarif tempTarif;
    @BeforeClass
    public static void before() {
        tarifs = new ArrayList<>();
        tarifsService = new TarifsService();
        for (int i = 0; i < 12; i++) {
            Tarif tarif = mock(Tarif.class);
            when(tarif.getIdTarif()).thenReturn(new Long(i));
            tarifs.add(tarif);
        }
        tarifsService.tarifsRepository = mock(TarifsRepository.class);
        when(tarifsService.tarifsRepository.findAll()).thenReturn(tarifs);
        when(tarifsService.tarifsRepository.findByIdTarif(5)).thenReturn(tarifs.get(5));
        when(tarifsService.tarifsRepository.findByIdTarif(11)).thenReturn(tarifs.get(11));

    }

    @Before
    public void beforeMethods() {
        tarifs = tarifsService.getAll();
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void methodDeleteShouldBeCorrectWork(){
        tempTarif = tarifsService.getAll().get(11);
        tarifsService.getAll().remove(11);
        Assert.assertNotEquals(tarifsService.getAll().get(11), tempTarif);
    }
    @Test
    public void methodAddShouldBeCorrectWork(){
        tarifs.add(mock(Tarif.class));
        when(tarifsService.addEntity(any(Tarif.class))).thenReturn(tarifs.set(11, tempTarif));
        tarifsService.addEntity(tempTarif);
        Assert.assertEquals(tarifsService.getAll().get(11), tempTarif);
    }

    @Test
    public void methodGetAllShouldBeCorrectWork() {
        Assert.assertEquals(tarifsService.getAll(), tarifs);
    }

    @Test
    public void methodGet10NewsByPageNumberShouldBeCorrectWork() {
        Assert.assertEquals(tarifsService.get10NewsByPageNumber(2), tarifs.subList(10, tarifs.size()));
    }
    @Test
    public void methodFindByIdTarifShouldBeCorrectWork(){
        Assert.assertEquals(tarifsService.getById(5L), tarifs.get(5));
    }
    @Test
    public void methodCheckedChangesShouldBeCorrectWork(){
        tempTarif = tarifsService.getAll().get(11);
        tarifsService.getAll().remove(11);

        when(tempTarif.getIdTarif()).thenReturn(100L);

        tarifs.add(mock(Tarif.class));
        when(tarifsService.addEntity(any(Tarif.class))).thenReturn(tarifs.set(11, tempTarif));
        tarifsService.checkedChanges(tempTarif);
        Assert.assertEquals(tarifsService.getById(11).getIdTarif(), new Long(100));
    }
}

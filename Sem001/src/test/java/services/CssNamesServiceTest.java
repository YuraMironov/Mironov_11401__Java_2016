package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Mironov.SE.entities.ClaimTarif;
import ru.kpfu.itis.Mironov.SE.entities.CssNames;
import ru.kpfu.itis.Mironov.SE.repositories.CssNamesRepository;
import ru.kpfu.itis.Mironov.SE.services.CssNamesService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 14.05.2016.
 */
public class CssNamesServiceTest {
    private static List<CssNames> cssesName;
    private static CssNamesService cssNamesService;
    private static CssNames tempCssName;
    @BeforeClass
    public static void before(){
        cssesName = new ArrayList<CssNames>();
        cssNamesService = new CssNamesService();
        cssNamesService.cssNamesRepository= mock(CssNamesRepository.class);
        for (int i = 0; i < 8; i++) {
            CssNames css = mock(CssNames.class);
            when(css.getIdCss()).thenReturn(i);
            cssesName.add(css);
        }
        when(cssNamesService.cssNamesRepository.findAll()).thenReturn(cssesName);
    }
    @Before
    public  void beforeMethods() {
        cssesName = cssNamesService.getAll();
    }

    @Test
    public void methodGetAllReturnsAllElements() {
        Assert.assertEquals(cssNamesService.getAll().size(), cssesName.size());
    }

    @Test
    public void methodGetAllReturnsAllSortedElements() {
        Assert.assertEquals(new Long(cssesName.get(3).getIdCss() + 1), new Long(cssesName.get(4).getIdCss()));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void methodDeleteShouldBeCorrectWork(){
        tempCssName = cssNamesService.getAll().get(7);
        cssNamesService.getAll().remove(7);
        Assert.assertNotEquals(cssNamesService.getAll().get(7), tempCssName);
    }
    @Test
    public void methodAddShouldBeCorrectWork(){
        cssesName.add(mock(CssNames.class));
        when(cssNamesService.addEntity(any(CssNames.class))).thenReturn(cssesName.set(2, tempCssName));
        cssNamesService.addEntity(tempCssName);
        Assert.assertEquals(cssNamesService.getAll().get(7), tempCssName);
    }
}

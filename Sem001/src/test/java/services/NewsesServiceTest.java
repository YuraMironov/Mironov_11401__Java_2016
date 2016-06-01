package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Mironov.SE.entities.Firm;
import ru.kpfu.itis.Mironov.SE.entities.News;
import ru.kpfu.itis.Mironov.SE.repositories.FirmsRepository;
import ru.kpfu.itis.Mironov.SE.repositories.NewsesRepository;
import ru.kpfu.itis.Mironov.SE.services.FirmService;
import ru.kpfu.itis.Mironov.SE.services.NewsesService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 14.05.2016.
 */
public class NewsesServiceTest {
    private static List<News> newses;
    private static NewsesService newsesService;
    private static News tempNews;
    @BeforeClass
    public static void before() {
        newses = new ArrayList<>();
        newsesService = new NewsesService();
        for (int i = 0; i < 12; i++) {
            News news = mock(News.class);
            when(news.getIdNews()).thenReturn(new Long(i));
            newses.add(news);
        }
        newsesService.newsesRepository = mock(NewsesRepository.class);
        when(newsesService.newsesRepository.findAll()).thenReturn(newses);
        when(newsesService.newsesRepository.findByIdNews(5L)).thenReturn(newses.get(5));

    }

    @Before
    public void beforeMethods() {
        newses = newsesService.getAll();
    }

    @Test
    public void methodGetAllShouldBeCorrectWork() {
        Assert.assertEquals(newsesService.getAll(), newses);
    }

    @Test
    public void methodGet10NewsByPageNumberShouldBeCorrectWork() {
        Assert.assertEquals(newsesService.get10NewsByPageNumber(2), newses.subList(10, newses.size()));
    }
    @Test
    public void methodFindByIdFirmShouldBeCorrectWork(){
        Assert.assertEquals(newsesService.getById(5L), newses.get(5));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void methodDeleteShouldBeCorrectWork(){
        tempNews = newsesService.getAll().get(11);
        newsesService.getAll().remove(11);
        Assert.assertNotEquals(newsesService.getAll().get(11), tempNews);
    }
    @Test
    public void methodAddShouldBeCorrectWork(){
        newses.add(mock(News.class));
        when(newsesService.addEntity(any(News.class))).thenReturn(newses.set(11, tempNews));
        newsesService.addEntity(tempNews);
        Assert.assertEquals(newsesService.getAll().get(11), tempNews);
    }

}

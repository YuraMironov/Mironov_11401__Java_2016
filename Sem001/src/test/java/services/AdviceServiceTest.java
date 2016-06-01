package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Mironov.SE.entities.Advice;
import ru.kpfu.itis.Mironov.SE.repositories.AdviceRepository;
import ru.kpfu.itis.Mironov.SE.services.AdviceService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 14.05.2016.
 */
public class AdviceServiceTest {
    private static List<Advice> advices;
    private static AdviceService adviceService;
    private static Advice tempAdvice;

    @BeforeClass
    public static void before() {
        advices = new ArrayList<Advice>();
        adviceService = new AdviceService();
        adviceService.adviceRepository = mock(AdviceRepository.class);
        for (int i = 0; i < 8; i++) {
            Advice advice = mock(Advice.class);
            when(advice.getId()).thenReturn(new Long(i));
            when(advice.getAdvname()).thenReturn("name" + i);
            advices.add(advice);
        }
        when(adviceService.adviceRepository.findAll()).thenReturn(advices);
        when(adviceService.adviceRepository.findByAdvname("name3")).thenReturn(advices.get(3));
        when(adviceService.adviceRepository.findById(2L)).thenReturn(advices.get(2));


    }

    @Before
    public  void beforeMethods() {
        advices = adviceService.getAll();
    }

    @Test
    public void methodGetAllReturnsAllElements() {
        Assert.assertEquals(adviceService.getAll().size(), advices.size());
    }

    @Test
    public void methodGetAllReturnsAllSortedElements() {
        Assert.assertEquals(new Long(advices.get(3).getId() + 1), advices.get(4).getId());
    }

    @Test
    public void methodGetByNameShouldBeCorrectWork() {
        Assert.assertEquals(adviceService.getByName("name3"), advices.get(3));
    }

    @Test
    public void methodGetByIdShouldBeCorrectWork() {
        Assert.assertEquals(adviceService.getById(2L), advices.get(2));
    }

    @Test
    public void methodFindLast7ShouldBeCorrectWork() {
        ArrayList<Advice> advices = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            advices.add(this.advices.get(i));
        }
        Assert.assertNotEquals(advices.get(0), 1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void methodDeleteShouldBeCorrectWork(){
        tempAdvice = adviceService.getAll().get(7);
        adviceService.getAll().remove(7);
        Assert.assertNotEquals(adviceService.getAll().get(7), tempAdvice);
    }
    @Test
    public void methodAddShouldBeCorrectWork(){
        advices.add(mock(Advice.class));
        when(adviceService.addEntity(any(Advice.class))).thenReturn(advices.set(7, tempAdvice));
        adviceService.addEntity(tempAdvice);
        Assert.assertEquals(adviceService.getAll().get(7), tempAdvice);
    }
}

package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Mironov.SE.entities.News;
import ru.kpfu.itis.Mironov.SE.entities.Phone;
import ru.kpfu.itis.Mironov.SE.repositories.NewsesRepository;
import ru.kpfu.itis.Mironov.SE.repositories.PhoneRepository;
import ru.kpfu.itis.Mironov.SE.services.NewsesService;
import ru.kpfu.itis.Mironov.SE.services.PhoneService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 14.05.2016.
 */
public class PhoneServiceTest {
    private static List<Phone> phones;
    private static PhoneService phoneService;
    private static Phone tempPhone;
    @BeforeClass
    public static void before() {
        phones = new ArrayList<>();
        phoneService = new PhoneService();
        for (int i = 0; i < 12; i++) {
            Phone phone = mock(Phone.class);
            when(phone.getId()).thenReturn(new Long(i));
            phones.add(phone);
        }
        phoneService.phoneRepository = mock(PhoneRepository.class);
        when(phoneService.phoneRepository.findAll()).thenReturn(phones);
        when(phoneService.phoneRepository.findById(5L)).thenReturn(phones.get(5));

    }

    @Before
    public void beforeMethods() {
        phones = phoneService.getAll();
    }

    @Test
    public void methodGetAllShouldBeCorrectWork() {
        Assert.assertEquals(phoneService.getAll(), phones);
    }

    @Test
    public void methodFindByIdFirmShouldBeCorrectWork(){
        Assert.assertEquals(phoneService.getById(5L), phones.get(5));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void methodDeleteShouldBeCorrectWork(){
        tempPhone = phoneService.getAll().get(11);
        phoneService.getAll().remove(11);
        Assert.assertNotEquals(phoneService.getAll().get(11), tempPhone);
    }
    @Test
    public void methodAddShouldBeCorrectWork(){
        phones.add(mock(Phone.class));
        when(phoneService.addEntity(any(Phone.class))).thenReturn(phones.set(11, tempPhone));
        phoneService.addEntity(tempPhone);
        Assert.assertEquals(phoneService.getAll().get(11), tempPhone);
    }
}

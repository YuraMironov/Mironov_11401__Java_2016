package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.repositories.MyUsersRepository;
import ru.kpfu.itis.Mironov.SE.services.MyUserDetailService;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import java.util.HashMap;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 14.05.2016.
 */
public class MyUserDetailServiceTest {
    private static MyUserDetailService myUserDetailService;
    @BeforeClass
    public static void before(){
        myUserDetailService = new MyUserDetailService();
        HashMap<String, MyUser> map = new HashMap<>();
        MyUser myUser = mock(MyUser.class);
        when(myUser.getEmail()).thenReturn("mail@mail.ru");
        when(myUser.getUsername()).thenCallRealMethod();
        map.put("mail@mail.ru", myUser);
        myUserDetailService.myUserService = mock(MyUserService.class);
        when(myUserDetailService.myUserService.getByEmail("mail@mail.ru"))
                .thenReturn(map.get("mail@mail.ru"));
    }
    @Test
    public void methodLoadUserByUsernameShouldBeCorrectWorkWithCorrectData(){
        Assert.assertEquals(myUserDetailService.loadUserByUsername("mail@mail.ru").getUsername(),
                "mail@mail.ru");
    }

}

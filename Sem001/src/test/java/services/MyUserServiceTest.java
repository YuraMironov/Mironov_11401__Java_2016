package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ru.kpfu.itis.Mironov.SE.entities.Advice;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;
import ru.kpfu.itis.Mironov.SE.repositories.MyUsersRepository;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

/**
 * Created by Юра on 14.05.2016.
 */
public class MyUserServiceTest {
    private static List<MyUser> users;
    private static MyUserService myUserService;
    private static MyUser tempUser;

    @BeforeClass
    public static void before() {
        myUserService = new MyUserService();
        users = new ArrayList<MyUser>();
        for (int i = 0; i < 8; i++) {
            MyUser myUser = mock(MyUser.class);
            when(myUser.getId()).thenReturn(new Long(i));
            when(myUser.getLogin()).thenReturn("user" + i);
            when(myUser.getEmail()).thenReturn("mail" + i + "@mail.ru");
            when(myUser.getPassword()).thenReturn("password" + i);
            when(myUser.isEnabled()).thenReturn( i % 2 == 0);
            when(myUser.isNonlocked()).thenReturn(true);

            Tarif tarif = mock(Tarif.class);
            when(tarif.getNameT()).thenReturn("tarif" + i);

            when(myUser.getTarif()).thenReturn(tarif);
            users.add(myUser);
        }
        myUserService.myUsersRepository = mock(MyUsersRepository.class);
        when(myUserService.myUsersRepository.findAll()).thenReturn(users);
        when(myUserService.getByEmail("mail1@mail.ru"))
                .thenReturn(users.get(1));
        when(myUserService.myUsersRepository.findAllByOrderByLoginAsc()).thenAnswer(new Answer<List<MyUser>>() {
            @Override
            public List<MyUser> answer(InvocationOnMock invocationOnMock) throws Throwable {
                Collections.sort(users, new Comparator<MyUser>() {
                    @Override
                    public int compare(MyUser o1, MyUser o2) {
                        return o1.getLogin().compareTo(o2.getLogin());
                    }
                });
                return users;
            }
        });
        when(myUserService.myUsersRepository.findById(7L)).thenReturn(users.get(7));
        when(myUserService.myUsersRepository.findByEnabledIsFalse()).thenAnswer(new Answer<List<MyUser>>() {
            @Override
            public List<MyUser> answer(InvocationOnMock invocationOnMock) throws Throwable {
                ArrayList<MyUser> users1 = new ArrayList<MyUser>();
                for(MyUser myUser : users){
                    if(!myUser.isEnabled()){
                        users1.add(myUser);
                    }
                }
                return users1;
            }
        });
        when(myUserService.myUsersRepository.findAllByEnabledIsFalseOrderByEmailAsc()).thenAnswer(new Answer<List<MyUser>>() {
            @Override
            public List<MyUser> answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<MyUser> users1 = myUserService.getNewUsers();
                Collections.sort(users1, new Comparator<MyUser>() {
                    @Override
                    public int compare(MyUser o1, MyUser o2) {
                        return o1.getEmail().compareTo(o2.getEmail());
                    }
                });
                return users1;
            }
        });
        when(myUserService.myUsersRepository.findById(5L)).thenReturn(users.get(5));
    }
    @Before
    public void beforeMethods(){
        users = myUserService.getAll();
    }
    @Test
    public void methodGetAllReturnsAllElements() {
        Assert.assertEquals(myUserService.getAll().size(), 8);
    }
    @Test
    public void methodGetByEmailShouldBeCorrectWork(){
        Assert.assertEquals(myUserService.getByEmail("mail1@mail.ru").getEmail(), "mail1@mail.ru");
    }
    @Test
    public void methodGetAllAndSortShouldBeCorrectWork(){
        List<MyUser> users = myUserService.getAll("login");
        Assert.assertEquals(users.get(4).getLogin().compareTo(users.get(7).getLogin()), -3);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void methodDeleteShouldBeCorrectWork(){
        tempUser = myUserService.getAll().get(7);
        myUserService.getAll().remove(7);
        Assert.assertNotEquals(myUserService.getAll().get(7), tempUser);
    }
    @Test
    public void methodAddShouldBeCorrectWork(){
        users.add(mock(MyUser.class));
        when(myUserService.addEntity(any(MyUser.class))).thenReturn(users.set(7, tempUser));
        myUserService.addEntity(tempUser);
        Assert.assertEquals(myUserService.getAll().get(7), tempUser);
    }
    @Test
    public void methodChangePasswordShouldBeCorrectWork(){
        tempUser = myUserService.getAll().get(7);
        myUserService.getAll().remove(7);
        when(tempUser.getPassword()).thenReturn("password77");
        users.add(mock(MyUser.class));
        when(myUserService.addEntity(any(MyUser.class))).thenReturn(users.set(7, tempUser));
        myUserService.addEntity(tempUser);
        Assert.assertEquals(myUserService.getById(7L).getPassword(),"password77" );
    }
    @Test
    public void methodChangeTarifShouldBeCorrectWork(){
        tempUser = myUserService.getAll().get(7);
        myUserService.getAll().remove(7);

        Tarif tarif = mock(Tarif.class);
        when(tarif.getNameT()).thenReturn("tarif77");

        when(tempUser.getTarif()).thenReturn(tarif);
        users.add(mock(MyUser.class));
        when(myUserService.addEntity(any(MyUser.class))).thenReturn(users.set(7, tempUser));
        myUserService.addEntity(tempUser);
        Assert.assertEquals(myUserService.getById(7L).getTarif().getNameT(), "tarif77" );
    }
    @Test
    public void methodGetNewUsersShouldBeCorrectWork(){
        boolean flag = false;
        for(MyUser myUser: myUserService.getNewUsers()){
            flag = flag || myUser.isEnabled();
        }
        Assert.assertFalse(flag);
    }
    @Test
    public void methodGetNewUsersAndSortShouldBeCorrectWork(){
        List<MyUser> users = myUserService.getNewUsers("email");
        Assert.assertEquals(users.get(1).getLogin().compareTo(users.get(2).getLogin()), -2);
    }
    @Test
    public void methodActivateUserByIdShouldBeCorrectWork(){
        int s1 = myUserService.getNewUsers().size();
        tempUser = myUserService.getAll().get(7);
        myUserService.getAll().remove(7);
        when(tempUser.isEnabled()).thenReturn(true);
        users.add(mock(MyUser.class));
        when(myUserService.addEntity(any(MyUser.class))).thenReturn(users.set(7, tempUser));
        myUserService.addEntity(tempUser);
        int s2 = myUserService.getNewUsers().size();
        Assert.assertNotEquals(s1, s2);
    }
    @Test
    public void methodNonLockedUserByIdShouldBeCorrectWork(){
        tempUser = myUserService.getAll().get(7);
        myUserService.getAll().remove(7);
        when(tempUser.isNonlocked()).thenReturn(false);
        users.add(mock(MyUser.class));
        when(myUserService.addEntity(any(MyUser.class))).thenReturn(users.set(7, tempUser));
        myUserService.addEntity(tempUser);
        Assert.assertFalse(myUserService.getAll().get(7).isNonlocked());
    }
    @Test
    public void methodGetByIdShouldBeCorrectWork(){
        Assert.assertEquals(myUserService.getById(5L), users.get(5));
    }
}

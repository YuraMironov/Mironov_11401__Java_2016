package ru.kpfu.itis.Mironov.SE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Mironov.SE.entities.Advice;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.repositories.MyUsersRepository;

import java.util.List;

/**
 * Created by Rus on 26.04.2016.
 */
@Service
public class MyUserService {
    @Autowired
    AdviceService adviceService;
    @Autowired
    MyUsersRepository myUsersRepository;
    public MyUsersRepository getMyUsersRepository() {
        return myUsersRepository;
    }

    public void setMyUsersRepository(MyUsersRepository myUsersRepository) {
        this.myUsersRepository = myUsersRepository;
    }

    @Transactional
    public MyUser addEntity(MyUser user) {
        return myUsersRepository.saveAndFlush(user);
    }

    @Transactional
    public void delete(long id) {
        myUsersRepository.delete(id);
    }

    public MyUser getByEmail(String email) {
        return myUsersRepository.findByEmail(email);
    }

    @Transactional
    public MyUser editEntity(MyUser user) {
        long id = this.getByEmail(user.getEmail()).getId();
        this.delete(id);
        this.addEntity(user);
        return user;
    }

    public List<MyUser> getAll() {
        return myUsersRepository.findAll();
    }

    public MyUser getByLogin(String login) {
        return myUsersRepository.findByLogin(login);
    }

    @Transactional
    public MyUser changePassword(MyUser user){
        myUsersRepository.changePasswordById(user.getPassword(), user.getId());
        return user;
    }
    @Transactional
    public MyUser paySchet(MyUser user){
        myUsersRepository.changeLastById(user.getLast(), user.getId());
        return user;
    }
}

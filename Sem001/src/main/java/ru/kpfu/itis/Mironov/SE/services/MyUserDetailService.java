package ru.kpfu.itis.Mironov.SE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;



/**
 * Created by Rus on 20.04.2016.
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    MyUserService myUserService;
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        MyUser user = myUserService.getByEmail(login);
        if (user == null) throw new UsernameNotFoundException("User with name " + login + " not found");
        return user;
    }
}


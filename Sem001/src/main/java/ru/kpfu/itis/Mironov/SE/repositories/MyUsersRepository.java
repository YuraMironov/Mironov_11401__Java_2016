package ru.kpfu.itis.Mironov.SE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;

/**
 * Created by Юра on 22.04.2016.
 */
@Repository
public interface MyUsersRepository extends JpaRepository<MyUser, Long> {
    MyUser findByEmail(String email);

    MyUser findByLogin(String login);
    @Modifying
    @Query("update ru.kpfu.itis.Mironov.SE.entities.MyUser set password = ?1 where id = ?2")
    void changePasswordById(String password, long id);

    @Modifying
    @Query("update ru.kpfu.itis.Mironov.SE.entities.MyUser set last = ?1 where id = ?2")
    void changeLastById(Integer last, Long id);
}
package ru.kpfu.itis.Mironov.SE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;

import java.util.List;

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

    @Modifying
    @Query("update ru.kpfu.itis.Mironov.SE.entities.MyUser set tarif = ?1 where id = ?2")
    void changeTarifById(Tarif tarif, Long id);

    List<MyUser> findByEnabledIsFalse();

    @Modifying
    @Query("update ru.kpfu.itis.Mironov.SE.entities.MyUser set enabled = ?2 where id = ?1")
    void updateEnabledById(Long uid, Boolean enabled);

    MyUser findById(Long uid);

    @Modifying
    @Query("update ru.kpfu.itis.Mironov.SE.entities.MyUser set nonlocked = ?2 where id = ?1")
    void updateNonLockedById(Long uid, Boolean status);

    List<MyUser> findAllByOrderByLoginAsc();

    List<MyUser> findAllByOrderByEmailAsc();

    List<MyUser> findAllByOrderByFirmAsc();

    List<MyUser> findAllByOrderByTarifAsc();

    List<MyUser> findAllByOrderByLastAsc();

    List<MyUser> findAllByEnabledIsFalseOrderByLoginAsc();

    List<MyUser> findAllByEnabledIsFalseOrderByEmailAsc();

    List<MyUser> findAllByEnabledIsFalseOrderByFirmAsc();

    List<MyUser> findAllByEnabledIsFalseOrderByTarifAsc();

    List<MyUser> findAllByEnabledIsFalseOrderByLastAsc();

    List<MyUser> findAllByOrderByNonlockedAsc();

}

package ru.kpfu.itis.Mironov.SE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Mironov.SE.entities.Advice;

import java.util.List;

/**
 * Created by Юра on 21.04.2016.
 */
@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {
    Advice findByAdvname(String advname);

    List<Advice> findByAuthorId(long id);

    Advice findById(long id);
}

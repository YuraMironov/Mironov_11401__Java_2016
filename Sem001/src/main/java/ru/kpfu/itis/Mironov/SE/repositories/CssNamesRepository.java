package ru.kpfu.itis.Mironov.SE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Mironov.SE.entities.CssNames;

/**
 * Created by Юра on 22.04.2016.
 */
@Repository
public interface CssNamesRepository extends JpaRepository<CssNames, Long>{
}

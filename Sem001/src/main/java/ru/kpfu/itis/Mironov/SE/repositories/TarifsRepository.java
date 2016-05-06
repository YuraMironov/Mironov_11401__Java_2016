package ru.kpfu.itis.Mironov.SE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;

/**
 * Created by Юра on 24.04.2016.
 */
@Repository
public interface TarifsRepository extends JpaRepository<Tarif, Long>{
    Tarif findByNameT(String name);

    Tarif findByIdTarif(long tarif);
}

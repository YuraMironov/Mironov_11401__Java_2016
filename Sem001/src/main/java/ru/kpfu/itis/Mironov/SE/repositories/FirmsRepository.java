package ru.kpfu.itis.Mironov.SE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Mironov.SE.entities.Firm;

/**
 * Created by Юра on 24.04.2016.
 */
@Repository
public interface FirmsRepository extends JpaRepository<Firm, Long>{
    Firm findByNameF(String name);

    Firm findByIdFirm(long produce);
}


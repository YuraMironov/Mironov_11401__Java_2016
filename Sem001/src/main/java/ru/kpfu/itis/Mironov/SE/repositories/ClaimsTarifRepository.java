package ru.kpfu.itis.Mironov.SE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Mironov.SE.entities.ClaimTarif;

/**
 * Created by Юра on 10.05.2016.
 */
@Repository
public interface ClaimsTarifRepository extends JpaRepository<ClaimTarif, Integer> {
    ClaimTarif findById(Integer id);
}

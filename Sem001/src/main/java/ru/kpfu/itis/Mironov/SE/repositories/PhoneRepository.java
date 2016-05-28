package ru.kpfu.itis.Mironov.SE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Mironov.SE.entities.Phone;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Юра on 10.05.2016.
 */
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long>{

    Phone findById(Long id);

    Phone findByNumbers(String phone);
}

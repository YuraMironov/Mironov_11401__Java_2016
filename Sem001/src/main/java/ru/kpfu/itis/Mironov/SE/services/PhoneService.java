package ru.kpfu.itis.Mironov.SE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Mironov.SE.entities.Phone;
import ru.kpfu.itis.Mironov.SE.repositories.PhoneRepository;

import java.util.List;

/**
 * Created by Юра on 10.05.2016.
 */
@org.springframework.stereotype.Service
public class PhoneService {
    @Autowired
    public PhoneRepository phoneRepository;
    @Transactional
    public Phone addEntity(Phone phone) {
        return phoneRepository.saveAndFlush(phone);
    }
    @Transactional
    public void delete(long id) {
        phoneRepository.delete(id);
    }

    public Phone getById(Long id) {
        return phoneRepository.findById(id);
    }

    public List<Phone> getAll() {
        return phoneRepository.findAll();
    }

}

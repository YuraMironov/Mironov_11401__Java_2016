package ru.kpfu.itis.Mironov.SE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Mironov.SE.entities.Firm;
import ru.kpfu.itis.Mironov.SE.repositories.FirmsRepository;

import java.util.List;

/**
 * Created by Юра on 24.04.2016.
 */
@Service
public class FirmsService{
    @Autowired
    FirmsRepository firmsRepository;
    @Transactional
    public Firm addEntity(Firm firm) {
        return firmsRepository.saveAndFlush(firm);
    }

    @Transactional
    public void delete(long id) {
        firmsRepository.delete(id);
    }

    public Firm getByName(String name) {
        return firmsRepository.findByNameF(name);
    }

    @Transactional
    public Firm editEntity(Firm firm) {
        this.delete(this.getByName(firm.getNameF()).getIdFirm());
        return this.addEntity(firm);
    }

    public List<Firm> getAll() {
        return firmsRepository.findAll();
    }
    public List<Firm> get10NewsByPageNumber(int counter){
        counter *=10;
        List<Firm> newses = this.getAll();
        int max = newses.size();
        return newses.subList(counter - 10, counter > max ? max : counter);
    }

    public Firm getById(long produce) {
        return firmsRepository.findByIdFirm(produce);
    }
}

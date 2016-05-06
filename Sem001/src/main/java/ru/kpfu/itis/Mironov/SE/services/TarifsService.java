package ru.kpfu.itis.Mironov.SE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;
import ru.kpfu.itis.Mironov.SE.repositories.TarifsRepository;

import java.util.List;

/**
 * Created by Юра on 24.04.2016.
 */
@Service
public class TarifsService {
    @Autowired
    TarifsRepository tarifsRepository;
    @Transactional
    public Tarif addEntity(Tarif tarif) {
        return tarifsRepository.saveAndFlush(tarif);
    }

    @Transactional
    public void delete(long id) {
        tarifsRepository.delete(id);
    }

    public Tarif getByName(String name) {
        return tarifsRepository.findByNameT(name);
    }

    @Transactional
    public Tarif editEntity(Tarif tarif) {
        delete(this.getByName(tarif.getNameT()).getIdTarif());
        return addEntity(tarif);

    }

    public List<Tarif> getAll() {
        return tarifsRepository.findAll();
    }

    public List<Tarif> get10NewsByPageNumber(int counter){
        counter *=10;
        List<Tarif> newses = this.getAll();
        int max = newses.size();
        return newses.subList(counter - 10, counter > max ? max : counter);
    }

    public Tarif getById(long tarif) {
        return tarifsRepository.findByIdTarif(tarif);
    }
}

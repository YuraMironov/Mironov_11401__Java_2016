package ru.kpfu.itis.Mironov.SE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Mironov.SE.entities.Advice;
import ru.kpfu.itis.Mironov.SE.repositories.AdviceRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Юра on 21.04.2016.
 */
@Service
public class AdviceService{
    @Autowired
    AdviceRepository adviceRepository;
    @Transactional
    public Advice addEntity(Advice advice) {
        return adviceRepository.saveAndFlush(advice);
    }

    @Transactional
    public void delete(long id) {
        adviceRepository.delete(id);
    }

    public Advice getByName(String advname) {
        return adviceRepository.findByAdvname(advname);
    }

    @Transactional
    public Advice editEntity(Advice advice) {
        long id = this.getByName(advice.getAdvname()).getId();
        this.delete(id);
        advice.setId(id);
        return this.addEntity(advice);
    }

    public List<Advice> getAll() {

        List<Advice> advices = adviceRepository.findAll();
        Collections.sort(advices, new Comparator<Advice>() {
            public int compare(Advice o1, Advice o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        return advices;
    }

    public List<Advice> findLast7(){
        List<Advice> advices = this.getAll();
        int size = advices.size();
        return advices.subList(size - 7, size);
    }

    public List<Advice> getByAuthorId(long id) {
        return adviceRepository.findByAuthorId(id);
    }
}

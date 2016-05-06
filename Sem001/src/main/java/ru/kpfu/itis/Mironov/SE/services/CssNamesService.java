package ru.kpfu.itis.Mironov.SE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Mironov.SE.entities.CssNames;
import ru.kpfu.itis.Mironov.SE.repositories.CssNamesRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Юра on 22.04.2016.
 */
@Service
public class CssNamesService{
    @Autowired
    CssNamesRepository cssNamesRepository;

    @Transactional
    public CssNames addEntity(CssNames cssNames) {
        return null;
    }

    @Transactional
    public void delete(long id) {

    }

    public CssNames getByName(String name) {
        return null;
    }

    @Transactional
    public CssNames editEntity(CssNames cssNames) {
        return null;
    }

    public List<CssNames> getAll() {
        List<CssNames> list = cssNamesRepository.findAll();
        Collections.sort(list, new Comparator<CssNames>() {
            public int compare(CssNames o1, CssNames o2) {
                return o1.getIdCss().compareTo(o2.getIdCss());
            }
        });
        return list;
    }
}

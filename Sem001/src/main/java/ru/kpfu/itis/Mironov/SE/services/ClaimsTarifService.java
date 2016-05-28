package ru.kpfu.itis.Mironov.SE.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Mironov.SE.entities.ClaimTarif;
import ru.kpfu.itis.Mironov.SE.repositories.ClaimsTarifRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class ClaimsTarifService{
    @Autowired
    ClaimsTarifRepository claimsTarifRepository;
    @Transactional
    public ClaimTarif addEntity(ClaimTarif claimTarif) {
        return claimsTarifRepository.saveAndFlush(claimTarif);
    }

    @Transactional
    public void delete(Integer id) {
        claimsTarifRepository.delete(id);
    }

    public ClaimTarif getByName(Integer id) {
        return claimsTarifRepository.findById(id);
    }

    @Transactional
    public ClaimTarif editEntity(ClaimTarif claimTarif) {
        this.delete(claimTarif.getId());
        this.addEntity(claimTarif);
        return claimTarif;
    }

    public List<ClaimTarif> getAll() {
        return claimsTarifRepository.findAll();
    }
}

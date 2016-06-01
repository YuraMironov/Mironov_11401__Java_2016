package ru.kpfu.itis.Mironov.SE.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Mironov.SE.entities.ClaimTarif;
import ru.kpfu.itis.Mironov.SE.repositories.ClaimsTarifRepository;

import java.util.List;

@Service
public class ClaimTarifService {

    @Autowired
    public ClaimsTarifRepository claimsTarifRepository;

    @Transactional
    public ClaimTarif addEntity(ClaimTarif claimTarif) {
        return claimsTarifRepository.saveAndFlush(claimTarif);
    }

    @Transactional
    public void delete(Integer id) {
        claimsTarifRepository.delete(id);
    }

    public List<ClaimTarif> getAll() {
        return claimsTarifRepository.findAll();
    }
}

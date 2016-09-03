package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Membre;
import co.dwsoftware.erp.gefi.repository.CotisationRepository;
import co.dwsoftware.erp.gefi.repository.MembreRepository;
import co.dwsoftware.erp.gefi.service.CotisationService;
import co.dwsoftware.erp.gefi.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class CotisationServiceImpl implements CotisationService {

    @Autowired
    CotisationRepository cotisationRepository;

    @Override
    public Cotisation create(Cotisation cotisation) {
        return cotisationRepository.save(cotisation);
    }

    @Override
    public Cotisation update(Cotisation cotisation) {
        Cotisation exist = cotisationRepository.findOne(cotisation.getId());
        if (exist == null) {
            throw  new IllegalArgumentException("");

        }
        return cotisationRepository.save(cotisation);
    }

    @Override
    public Cotisation findByNom(String nom) {
        return cotisationRepository.findByNom(nom);
    }

    @Override
    public Cotisation findByType(String type) {
        return cotisationRepository.findByType(type);
    }

    @Override
    public Cotisation findByAnnee(String annee) {
        return cotisationRepository.findByAnnee(annee);
    }

    @Override
    public List<Cotisation> findAll() {
        return (List<Cotisation>) cotisationRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Cotisation exist = cotisationRepository.findOne(id);
        if (exist == null) {
            throw  new IllegalArgumentException("");

        }
        cotisationRepository.delete(id);
    }
}

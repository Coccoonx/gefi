package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Annee;
import co.dwsoftware.erp.gefi.model.Inscription;
import co.dwsoftware.erp.gefi.repository.InscriptionRepository;
import co.dwsoftware.erp.gefi.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class InscriptionServiceImpl implements InscriptionService {

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Override
    public Inscription create(Inscription inscription) {

        Inscription exist = inscriptionRepository.findByMembreAndAnnee(inscription.getInscrit(), inscription.getAnnee());
        if (exist != null) {
            throw new IllegalArgumentException("inscription already exists");
        }

        Inscription saved  = inscriptionRepository.save(inscription);

        return saved;
    }

    @Override
    public Inscription update(Inscription inscription) {
        Inscription exist = inscriptionRepository.findByMembreAndAnnee(inscription.getInscrit(), inscription.getAnnee());
        if (exist == null) {
            throw new IllegalArgumentException("inscription doesn't exist");
        }

        Inscription saved  = inscriptionRepository.save(inscription);

        return saved;
    }

    @Override
    public List<Inscription> findByAnnee(Annee annee) {
        return inscriptionRepository.findByAnnee(annee);
    }

    @Override
    public List<Inscription> findAll() {
        return (List<Inscription>) inscriptionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Inscription exist = inscriptionRepository.findOne(id);
        if (exist == null) {
            throw new IllegalArgumentException("inscription doesn't exist");
        }

        inscriptionRepository.delete(id);
    }
}

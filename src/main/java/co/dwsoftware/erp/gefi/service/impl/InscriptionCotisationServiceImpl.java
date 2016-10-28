package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.InscriptionCotisation;
import co.dwsoftware.erp.gefi.repository.InscriptionCotisationRepository;
import co.dwsoftware.erp.gefi.service.InscriptionCotisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class InscriptionCotisationServiceImpl implements InscriptionCotisationService {

    @Autowired
    InscriptionCotisationRepository inscriptionRepository;

    @Override
    public InscriptionCotisation create(InscriptionCotisation inscription) {

        InscriptionCotisation exist = inscriptionRepository.findByMembreAndCotisation(inscription.getMembre(), inscription.getCotisation());
        if (exist != null) {
            throw new IllegalArgumentException("inscription already exists");
        }

        InscriptionCotisation saved  = inscriptionRepository.save(inscription);

        return saved;
    }

    @Override
    public InscriptionCotisation update(InscriptionCotisation inscription) {
        InscriptionCotisation exist = inscriptionRepository.findByMembreAndCotisation(inscription.getMembre(), inscription.getCotisation());
        if (exist == null) {
            throw new IllegalArgumentException("inscription doesn't exist");
        }

        InscriptionCotisation saved  = inscriptionRepository.save(inscription);

        return saved;
    }

    @Override
    public List<InscriptionCotisation> findByCotisation (Cotisation cotisation) {
        return inscriptionRepository.findByCotisation(cotisation);
    }

    @Override
    public List<InscriptionCotisation> findAll() {
        return (List<InscriptionCotisation>) inscriptionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        InscriptionCotisation exist = inscriptionRepository.findOne(id);
        if (exist == null) {
            throw new IllegalArgumentException("inscription doesn't exist");
        }

        inscriptionRepository.delete(id);
    }
}

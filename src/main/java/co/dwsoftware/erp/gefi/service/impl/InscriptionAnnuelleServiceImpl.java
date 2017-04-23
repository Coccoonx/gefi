package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.InscriptionAnnuelle;
import co.dwsoftware.erp.gefi.repository.InscriptionAnnuelleRepository;
import co.dwsoftware.erp.gefi.service.InscriptionAnnuelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class InscriptionAnnuelleServiceImpl implements InscriptionAnnuelleService {

    @Autowired
    InscriptionAnnuelleRepository inscriptionRepository;

    @Override
    public InscriptionAnnuelle create(InscriptionAnnuelle inscription) {

        InscriptionAnnuelle exist = inscriptionRepository.findByMembreAndCotisation(inscription.getMembre(), inscription.getCotisation());
        if (exist != null) {
            throw new IllegalArgumentException("inscription already exists");
        }

        InscriptionAnnuelle saved  = inscriptionRepository.save(inscription);

        return saved;
    }

    @Override
    public InscriptionAnnuelle update(InscriptionAnnuelle inscription) {
        InscriptionAnnuelle exist = inscriptionRepository.findByMembreAndCotisation(inscription.getMembre(), inscription.getCotisation());
        if (exist == null) {
            throw new IllegalArgumentException("inscription doesn't exist");
        }

        InscriptionAnnuelle saved  = inscriptionRepository.save(inscription);

        return saved;
    }

    @Override
    public List<InscriptionAnnuelle> findByCotisation (Cotisation cotisation) {
        return inscriptionRepository.findByCotisation(cotisation);
    }

    @Override
    public List<InscriptionAnnuelle> findAll() {
        return (List<InscriptionAnnuelle>) inscriptionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        InscriptionAnnuelle exist = inscriptionRepository.findOne(id);
        if (exist == null) {
            throw new IllegalArgumentException("inscription doesn't exist");
        }

        inscriptionRepository.delete(id);
    }
}

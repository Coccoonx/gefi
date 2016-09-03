package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Annee;
import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.repository.AnneeRepository;
import co.dwsoftware.erp.gefi.repository.CotisationRepository;
import co.dwsoftware.erp.gefi.service.AnneeService;
import co.dwsoftware.erp.gefi.service.CotisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class AnneeServiceImpl implements AnneeService {

    @Autowired
    AnneeRepository anneeRepository;

    @Override
    public Annee create(Annee annee) {
        return anneeRepository.save(annee);
    }

    @Override
    public Annee update(Annee annee) {
        Annee exist = anneeRepository.findByNom(annee.getNom());
        if (exist == null) {
            throw new IllegalArgumentException("");
        }
        return anneeRepository.save(exist);
    }

    @Override
    public Annee findByNom(String nom) {
        return anneeRepository.findByNom(nom);
    }

    @Override
    public List<Annee> findAll() {
        return (List<Annee>) anneeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Annee exist = anneeRepository.findOne(id);
        if (exist == null) {
            throw  new IllegalArgumentException("");

        }
        anneeRepository.delete(id);
    }
}

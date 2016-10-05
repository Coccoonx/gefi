package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Annee;
import co.dwsoftware.erp.gefi.model.Inscription;

import java.util.List;


public interface InscriptionService {

    Inscription create(Inscription inscription);
    Inscription update(Inscription inscription);
    List<Inscription> findByAnnee(Annee annee);
    List<Inscription> findAll();
    void delete(Long Id);

}

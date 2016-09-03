package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Annee;
import co.dwsoftware.erp.gefi.model.Membre;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
public interface AnneeService {

    Annee create(Annee annee);
    Annee update(Annee annee);
    Annee findByNom(String nom);
    List<Annee> findAll();
    void delete(Long Id);

}

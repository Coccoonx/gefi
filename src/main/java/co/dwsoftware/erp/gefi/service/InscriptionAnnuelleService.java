package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.InscriptionAnnuelle;

import java.util.List;


public interface InscriptionAnnuelleService {

    InscriptionAnnuelle create(InscriptionAnnuelle inscription);
    InscriptionAnnuelle update(InscriptionAnnuelle inscription);
    List<InscriptionAnnuelle> findByCotisation(Cotisation cotisation);
    List<InscriptionAnnuelle> findAll();
    void delete(Long Id);

}

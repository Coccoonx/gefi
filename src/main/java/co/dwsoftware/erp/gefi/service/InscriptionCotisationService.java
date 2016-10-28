package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.InscriptionCotisation;

import java.util.List;


public interface InscriptionCotisationService {

    InscriptionCotisation create(InscriptionCotisation inscription);
    InscriptionCotisation update(InscriptionCotisation inscription);
    List<InscriptionCotisation> findByCotisation(Cotisation cotisation);
    List<InscriptionCotisation> findAll();
    void delete(Long Id);

}

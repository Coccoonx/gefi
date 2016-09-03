package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Cotisation;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
public interface CotisationService {

    Cotisation create(Cotisation cotisation);
    Cotisation update(Cotisation cotisation);
    Cotisation findByNom(String nom);
    Cotisation findByType(String type);
    Cotisation findByAnnee(String annee);
    List<Cotisation> findAll();
    void delete(Long Id);

}

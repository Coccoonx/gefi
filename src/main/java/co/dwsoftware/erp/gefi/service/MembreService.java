package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Membre;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
public interface MembreService {

    Membre create(Membre membre);
    Membre update(Membre membre);
    Membre findByNom(String nom);
    Membre findByPrenom(String nom);
    Membre findByAdresse(String adresse);
    Membre findByCni(String numeroCni);
    List<Membre> findAll();
    void delete(Long Id);

}

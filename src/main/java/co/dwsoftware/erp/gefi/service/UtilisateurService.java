package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Utilisateur;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
public interface UtilisateurService {

    Utilisateur create(Utilisateur membre);
    Utilisateur update(Utilisateur membre);
    Utilisateur findByNom(String nom);
    Utilisateur findByPrenom(String nom);
    Utilisateur findByAdresse(String adresse);
    Utilisateur findByCni(String numeroCni);
    List<Utilisateur> findAll();
    void delete(Long Id);

}

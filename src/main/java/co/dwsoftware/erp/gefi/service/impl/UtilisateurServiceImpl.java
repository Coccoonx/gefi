package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Utilisateur;
import co.dwsoftware.erp.gefi.repository.UtilisateurRepository;
import co.dwsoftware.erp.gefi.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        Utilisateur exist = utilisateurRepository.findOne(utilisateur.getId());
        if (exist != null) {
            throw new IllegalArgumentException("");
        }
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) {
        Utilisateur exist = utilisateurRepository.findOne(utilisateur.getId());
        if (exist == null) {
            throw new IllegalArgumentException("");
        }
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur findByNom(String lastName) {
        return utilisateurRepository.findByNom(lastName);
    }

    @Override
    public Utilisateur findByPrenom(String prenom) {
        return utilisateurRepository.findByPrenom(prenom);
    }

    @Override
    public Utilisateur findByAdresse(String adresse) {
        return utilisateurRepository.findByAdresse(adresse);
    }

    @Override
    public Utilisateur findByCni(String numeroCni) {
        return utilisateurRepository.findByCni(numeroCni);
    }

    @Override
    public List<Utilisateur> findAll() {
        return (List<Utilisateur>) utilisateurRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        utilisateurRepository.delete(id);
    }

    //@PostConstruct
    public void populate(){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Kamga");
        utilisateur.setPrenom("Maurice");
        utilisateur.setAdresse("Makepe");
        utilisateur.setCni("125548518");
        utilisateur.setTelephone("688778899");
        utilisateurRepository.save(utilisateur);

        utilisateur = new Utilisateur();
        utilisateur.setNom("Kemogne");
        utilisateur.setPrenom("Jean");
        utilisateur.setAdresse("Makepe");
        utilisateur.setCni("125548518");
        utilisateur.setTelephone("688778899");
        utilisateurRepository.save(utilisateur);
    }
}

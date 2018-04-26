package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.Membre;
import co.dwsoftware.erp.gefi.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    Utilisateur findByNom(@Param("nom") String nom);
    Utilisateur findByPrenom(@Param("prenom") String prenom);
    Utilisateur findByCni(@Param("cni") String cni);
    Utilisateur findByAdresse(@Param("adresse") String adresse);

}

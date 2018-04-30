package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.Membre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MembreRepository extends CrudRepository<Membre, Long> {

    Membre findByNom(@Param("nom") String nom);

    Membre findByPrenom(@Param("prenom") String prenom);

    Membre findByCni(@Param("cni") String cni);

    Membre findByAdresse(@Param("adresse") String adresse);

    @Query("SELECT m FROM Membre m WHERE m.statut = 'Actif' ")
    List<Membre> findActiveMember();

}

package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.Annee;
import co.dwsoftware.erp.gefi.model.Inscription;
import co.dwsoftware.erp.gefi.model.Membre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscriptionRepository extends CrudRepository<Inscription, Long> {

    Inscription findByNom(@Param("nom") String nom);
    List<Inscription> findByAnnee(@Param("annee") Annee annee);

    @Query("SELECT t FROM Inscription t WHERE t.inscrit = :membre AND t.annee = :annee ")
    Inscription findByMembreAndAnnee(@Param("membre") Membre membre, @Param("annee") Annee annee);

}

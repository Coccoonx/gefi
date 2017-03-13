package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.Cotisation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CotisationRepository extends CrudRepository<Cotisation, Long> {

    Cotisation findByNom(@Param("nom") String nom);

    @Query("SELECT c FROM Cotisation c where c.type = 0")
    List<Cotisation> findByTontine();

    @Query("SELECT c FROM Cotisation c where c.type = 1")
    List<Cotisation> findByEpargne();

    @Query("SELECT c FROM Cotisation c where c.type = 2")
    List<Cotisation> findByAnnee();
    
    Cotisation findByAnnee(@Param("annee") String annee);

}

package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscriptionAnnuelleRepository extends CrudRepository<InscriptionAnnuelle, Long> {

    List<InscriptionAnnuelle> findByCotisation(@Param("cotisation") Cotisation cotisation);

    @Query("SELECT t FROM InscriptionAnnuelle t WHERE t.membre = :membre AND t.cotisation = :cotisation ")
    InscriptionAnnuelle findByMembreAndCotisation(@Param("membre") Membre membre, @Param("cotisation") Cotisation cotisation);

}

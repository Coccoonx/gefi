package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscriptionCotisationRepository extends CrudRepository<InscriptionCotisation, Long> {

    List<InscriptionCotisation> findByCotisation(@Param("cotisation") Cotisation cotisation);

    @Query("SELECT t FROM InscriptionCotisation t WHERE t.membre = :membre AND t.cotisation = :cotisation ")
    InscriptionCotisation findByMembreAndCotisation(@Param("membre") Membre membre, @Param("cotisation") Cotisation cotisation);

}

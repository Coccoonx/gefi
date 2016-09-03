package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Membre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CotisationRepository extends CrudRepository<Cotisation, Long> {

    Cotisation findByNom(@Param("nom") String nom);
    Cotisation findByType(@Param("type") String prenom);
    Cotisation findByAnnee(@Param("annee") String annee);

}

package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.Annee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnneeRepository extends CrudRepository<Annee, Long> {

    Annee findByNom(@Param("nom") String nom);

}

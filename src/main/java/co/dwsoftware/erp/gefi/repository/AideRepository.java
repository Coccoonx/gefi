package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.Aide;
import co.dwsoftware.erp.gefi.model.Annee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AideRepository extends CrudRepository<Aide, Long> {

    Aide findByMotif(@Param("motif") String motif);

}

package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.Aide;
import co.dwsoftware.erp.gefi.model.Sanction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SanctionRepository extends CrudRepository<Sanction, Long> {

    Sanction findByMotif(@Param("motif") String motif);

}

package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.Service;
import co.dwsoftware.erp.gefi.model.Annee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends CrudRepository<Service, Long> {

    Service findByMotif(@Param("motif") String motif);

}

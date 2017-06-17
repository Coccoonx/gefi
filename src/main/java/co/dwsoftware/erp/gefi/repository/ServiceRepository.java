package co.dwsoftware.erp.gefi.repository;

import java.util.List;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Service;
import co.dwsoftware.erp.gefi.model.Annee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends CrudRepository<Service, Long> {

    Service findByMotif(@Param("motif") String motif);
    
    @Query("SELECT s FROM Service s where s.type = 0")
    List<Service> findByAide();
    
    @Query("SELECT s FROM Service s where s.type = 1")
    List<Service> findBySanction();

}

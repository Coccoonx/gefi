package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Service;

import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
public interface AideSanctionService {

    Service create(Service service);
    Service update(Service service);
    Service findByMotif(String motif);
    List<Service> findByAide();
    List<Service> findBySanction();
    List<Service> findAll();
    void delete(Long Id);

}

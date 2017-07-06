package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Service;
import co.dwsoftware.erp.gefi.model.Annee;
import co.dwsoftware.erp.gefi.model.TypeService;
import co.dwsoftware.erp.gefi.repository.ServiceRepository;
import co.dwsoftware.erp.gefi.service.AideSanctionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.Date;
import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class AideSanctionServiceImpl implements AideSanctionService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Service create(Service service) {
    	logger.info("Incoming Service{}", service );
    	 Service exist = serviceRepository.findByMotif(service.getMotif());
         if (exist != null) {
             throw new IllegalArgumentException("service.already.exist");
         }
        return serviceRepository.save(service);
    }

    @Override
    public Service update(Service service) {
    	logger.info("Incoming Service{}", service );
        Service exist = serviceRepository.findOne(service.getId());
        if (exist == null) {
            throw new IllegalArgumentException("service.does.not.exist");
        }
        return serviceRepository.save(service);
    }

    @Override
    public Service findByMotif(String motif) {
        return serviceRepository.findByMotif(motif);
    }

    @Override
    public List<Service> findAll() {
        return (List<Service>) serviceRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Service exist = serviceRepository.findOne(id);
        if (exist == null) {
            throw  new IllegalArgumentException("service.does.not.exist");

        }
        serviceRepository.delete(id);
    }

   // @PostConstruct
    private void populateAnnee(){
        Service service = new Service();
        service.setMotif("Decès");
        service.setType(TypeService.AIDE);
        serviceRepository.save(service);

        service = new Service();
        service.setMotif("Naissance");
        service.setType(TypeService.AIDE);
        serviceRepository.save(service);

        
    }

	@Override
	public List<Service> findByAide() {
		return serviceRepository.findByAide();
	}

	@Override
	public List<Service> findBySanction() {
		return serviceRepository.findBySanction();
	}
}

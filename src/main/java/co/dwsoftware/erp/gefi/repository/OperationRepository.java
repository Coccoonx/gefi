package co.dwsoftware.erp.gefi.repository;

import co.dwsoftware.erp.gefi.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends CrudRepository<Service, Long> {



}

package co.dwsoftware.erp.gefi.service;

import co.dwsoftware.erp.gefi.model.Operation;

import java.util.List;


public interface OperationService {

    Operation create(Operation inscription);
    Operation update(Operation inscription);
    List<Operation> findAll();
    void delete(Long Id);

}

package co.dwsoftware.erp.gefi.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.dwsoftware.erp.gefi.model.Operation;
import co.dwsoftware.erp.gefi.repository.MembreRepository;
import co.dwsoftware.erp.gefi.repository.OperationRepository;
import co.dwsoftware.erp.gefi.service.OperationService;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class OperationServiceImpl implements OperationService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OperationRepository operationRepository;
	@Autowired
	MembreRepository membreRepository;

	@Override
	public Operation create(Operation service) {


		return null;
	}

	@Override
	public Operation update(Operation service) {

		return null;
	}

	

	@Override
	public List<Operation> findAll() {
		return null;
	}

	@Override
	public void delete(Long id) {
	}
}

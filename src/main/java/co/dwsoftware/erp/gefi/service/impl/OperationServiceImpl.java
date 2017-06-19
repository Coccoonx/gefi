package co.dwsoftware.erp.gefi.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.InscriptionAnnuelle;
import co.dwsoftware.erp.gefi.model.Operation;
import co.dwsoftware.erp.gefi.model.Service;
import co.dwsoftware.erp.gefi.repository.CotisationRepository;
import co.dwsoftware.erp.gefi.repository.InscriptionAnnuelleRepository;
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
	@Autowired
	CotisationRepository cotisationRepository;
	@Autowired
	InscriptionAnnuelleServiceImpl inscriptionAnnuelleSI;

	@Override
	public Operation create(Operation operation) {

		Operation exist = operationRepository.findExistingOperation(
				operation.getDateOperation(), operation.getMembre(),
				operation.getService(), operation.getType());
		if (exist != null) {
			throw new IllegalArgumentException("Operation already exists");
		}

		exist = operationRepository.save(operation);
		logger.info("Saved Op: {}", exist);
		return exist;
	}

	@Override
	public Operation update(Operation operation) {
		Operation exist = operationRepository.findExistingOperation(
				operation.getDateOperation(), operation.getMembre(),
				operation.getService(), operation.getType());
		if (exist == null) {
			throw new IllegalArgumentException("Operation doesn't exist");
		}

		exist = operationRepository.save(operation);
		logger.info("Saved Op: {}", exist);
		return exist;
	}

	@Override
	public List<Operation> findAll() {
		return (List<Operation>) operationRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		Operation exist = operationRepository.findOne(id);
		if (exist == null) {
			throw new IllegalArgumentException("Operation doesn't exist");
		}

		operationRepository.delete(exist);
	}

	@Override
	public List<Operation> findOpsAideByCotisation(long cotisationId) {
		String date_pattern = "yyyy-MM-dd";
		Cotisation cotisation = cotisationRepository.findOne(cotisationId);
		List<Operation> tuple = new ArrayList<Operation>();

		if (cotisation != null) {
			SimpleDateFormat df = new SimpleDateFormat(date_pattern);

			try {
				Date bInf = df.parse(cotisation.getDateDebut());
				Date bSup = df.parse(cotisation.getDateFin());

				List<Operation> operations = operationRepository.findAllAide();
				for (Operation operation : operations) {
					if (bInf.before(new Date(operation.getDateOperation()))
							&& bSup.after(new Date(operation.getDateOperation()))) {
						tuple.add(operation);
					}
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

		}
		return tuple;
	}

	@Override
	public List<InscriptionAnnuelle> findMembreForRemboursementAide(
			long cotisationId, long operationId) {

		Cotisation cotisation = cotisationRepository.findOne(cotisationId);
		Operation operation = operationRepository.findOne(operationId);

		List<InscriptionAnnuelle> tuple = new ArrayList<InscriptionAnnuelle>();

		if (cotisation != null && operation != null) {

			List<InscriptionAnnuelle> inscrits = inscriptionAnnuelleSI
					.findAll();
			for (InscriptionAnnuelle ia : inscrits) {
				if (ia.getMembre().getId() != operation.getMembre().getId()) {
					tuple.add(ia);
				}
			}

		}
		return tuple;
	}

	@Override
	public List<Operation> findMembreRembourseurAide(long cotisationId,
			long operationId) {

		Operation operation = operationRepository.findOne(operationId);

		List<Operation> tuple = new ArrayList<Operation>();
		if (operation != null) {
			logger.info("Operation: {}", operation);
			System.out.println("Op : " + operation);

			List<Operation> ops = operationRepository
					.findAllRembourseurAide(operation.getId());
			System.out.println("Ops size: " + ops.size());
			// return ops;
			for (Operation op : ops) {
				System.out.println("Compare : " + op.getIdOperationInitiale()
						+ " # " + operation.getId());
				op.setMontantAttendu(operation.getMontantOperation());
				tuple.add(op);
			}

		}
		return tuple;
	}
}

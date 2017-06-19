package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.InscriptionAnnuelle;
import co.dwsoftware.erp.gefi.model.Operation;
import co.dwsoftware.erp.gefi.model.Service;
import co.dwsoftware.erp.gefi.service.OperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.transaction.Transactional;

/**
 *
 * Created by lyonnel on 02/09/16.
 *
 */
@Controller
public class OperationController {

	@Autowired
	OperationService operationService;

	@RequestMapping(value = "/operation/", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Operation createOperation(@RequestBody Operation operation) {
		return operationService.create(operation);
	}

	@RequestMapping(value = "/operation/", method = RequestMethod.PUT)
	@ResponseBody
	@Transactional
	public Operation updateOperation(@RequestBody Operation operation) {
		return operationService.update(operation);
	}

	@RequestMapping(value = "/operation/", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Operation> findAll() {
		return operationService.findAll();
	}

	@RequestMapping(value = "/operation/aide/{cotisationId}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Operation> findAllAideByCotisation(
			@PathVariable("cotisationId") long cotisationId) {
		return operationService.findOpsAideByCotisation(cotisationId);
	}

	@RequestMapping(value = "/operation/aide/remboursement/{cotisationId}/{operationId}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<InscriptionAnnuelle> findMembreForRemboursment(
			@PathVariable("cotisationId") long cotisationId,
			@PathVariable("operationId") long operationId) {
		return operationService.findMembreForRemboursementAide(cotisationId,
				operationId);
	}

	@RequestMapping(value = "/operation/aide/remboursement/etat/{cotisationId}/{operationId}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Operation> etatRemboursementAide(
			@PathVariable("cotisationId") long cotisationId,
			@PathVariable("operationId") long operationId) {
		return operationService.findMembreRembourseurAide(cotisationId,
				operationId);
	}

	@RequestMapping(value = "/operation/{operationId}", method = RequestMethod.DELETE)
	@ResponseBody
	@Transactional
	public void deleteOperation(@PathVariable long operationId) {
		operationService.delete(operationId);
	}
}

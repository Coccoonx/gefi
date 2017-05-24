package co.dwsoftware.erp.gefi.controller;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Transaction;
import co.dwsoftware.erp.gefi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * Created by lyonnel on 02/09/16.
 *
 */
@Controller
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/transaction/", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return transactionService.create(transaction);
	}

	@RequestMapping(value = "/transaction/", method = RequestMethod.PUT)
	@ResponseBody
	@Transactional
	public Transaction updateTransaction(@RequestBody Transaction transaction) {
		return transactionService.update(transaction);
	}

	@RequestMapping(value = "/transaction/", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Transaction> findAll() {
		return transactionService.findAll();
	}

	@RequestMapping(value = "/transaction/tontiner/{date}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Transaction> findAllWinneableTontineByDate(
			@PathVariable("date") long date) {
		return transactionService.findAllWinneableTontineByDate(date);
	}

	@RequestMapping(value = "/transaction/tontiner/{cotisationId}/{date}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Transaction> findAllTontineByCotisationAndDate(
			@PathVariable("cotisationId") long cotisationId,
			@PathVariable("date") long date) {
		return transactionService.findAllTontineByCotisationAndDate(
				cotisationId, date);
	}

	@RequestMapping(value = "/transaction/beneficier/{cotisationId}/{date}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Transaction> findAllBeneficeByCotisationAndDate(
			@PathVariable("cotisationId") long cotisationId,
			@PathVariable("date") long date) {
		return transactionService.findAllBeneficeByCotisationAndDate(
				cotisationId, date);
	}

	@RequestMapping(value = "/transaction/emprunter/{cotisationId}/{date}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Transaction> findAllPretByCotisationAndDate(
			@PathVariable("cotisationId") long cotisationId,
			@PathVariable("date") long date) {
		return transactionService.findAllPretByCotisationAndDate(cotisationId,
				date);
	}
	
	@RequestMapping(value = "/transaction/epargnes/{cotisationId}/{membreId}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Transaction> findAllEpargneByCotisationAndMembre(
			@PathVariable("cotisationId") long cotisationId,
			@PathVariable("membreId") long membreId) {
		return transactionService.findAllEpargneByCotisationAndMembre(cotisationId,
				membreId);
	}
	
	@RequestMapping(value = "/transaction/epargnes/{cotisationId}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Transaction> findAllEpargneByCotisation(
			@PathVariable("cotisationId") long cotisationId) {
		return transactionService.findAllEpargneByCotisation(cotisationId);
	}
	
	@RequestMapping(value = "/transaction/epargnes/suivi/{cotisationId}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Transaction> findAllEpargneByCotisationSuivi(
			@PathVariable("cotisationId") long cotisationId) {
		return transactionService.findAllEpargneByCotisationSuivi(cotisationId);
	}


	@RequestMapping(value = "/transaction/rembourser/{cotisationId}/{date}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public List<Transaction> findAllRemboursementByCotisationAndDate(
			@PathVariable("cotisationId") long cotisationId,
			@PathVariable("date") long date) {
		return transactionService.findAllRemboursementByCotisationAndDate(
				cotisationId, date);
	}

	@RequestMapping(value = "/transaction/{transactionId}", method = RequestMethod.DELETE)
	@ResponseBody
	@Transactional
	public void deleteTransaction(@PathVariable long transactionId) {
		transactionService.delete(transactionId);
	}
}

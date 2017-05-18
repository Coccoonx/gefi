package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Transaction;
import co.dwsoftware.erp.gefi.model.TypeTransaction;
import co.dwsoftware.erp.gefi.repository.CotisationRepository;
import co.dwsoftware.erp.gefi.repository.TransactionRepository;
import co.dwsoftware.erp.gefi.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	CotisationRepository cotisationRepository;

	@Override
	public Transaction create(Transaction transaction) {

		Transaction exist = transactionRepository
				.findByMembreAndCotisationAndDate(transaction.getMembre(),
						transaction.getCotisation(),
						transaction.getDateOperation());
		if (exist != null) {
			throw new IllegalArgumentException("transaction already exists");
		}

		Transaction saved = transactionRepository.save(transaction);

		return saved;
	}

	@Override
	public Transaction update(Transaction transaction) {
		Transaction exist = transactionRepository.findByMembreAndCotisation(
				transaction.getMembre(), transaction.getCotisation());
		if (exist == null) {
			throw new IllegalArgumentException("transaction doesn't exist");
		}

		Transaction saved = transactionRepository.save(transaction);

		return saved;
	}

	@Override
	public List<Transaction> findAllTontineByCotisationAndDate(
			long cotisationId, long date) {

		Cotisation cotisation = cotisationRepository.findOne(cotisationId);
		if (cotisation != null) {
			return transactionRepository
					.findAllTontinesByCotisationAndDateOperation(cotisation,
							date);
		}

		return null;

	}

	@Override
	public List<Transaction> findAllWinneableTontineByDate(long date) {

		HashSet<Cotisation> cotisations = new HashSet<Cotisation>();
		List<Transaction> transactionsTontine = transactionRepository
				.findAllWinneableTontineByDate(date);

		if (transactionsTontine.size() != 0) {

			List<Transaction> result = new ArrayList<>();

			for (Transaction transaction : transactionsTontine) {
				cotisations.add(transaction.getCotisation());
			}
			for (Cotisation cotisation : cotisations) {
				Transaction tuple = new Transaction();
				tuple.setDateOperation(date);
				tuple.setCotisation(cotisation);
				tuple.setMontantOperation(0.0);
				tuple.setType(TypeTransaction.TONTINER);
				for (Transaction tmp : transactionsTontine) {
					if (tmp.getCotisation().getId() == cotisation.getId())
						tuple.setMontantOperation(tuple.getMontantOperation()
								+ tmp.getMontantOperation());
				}
				result.add(tuple);

			}
			return result;

		}

		return null;

	}

	@Override
	public List<Transaction> findAllBeneficeByCotisationAndDate(
			long cotisationId, long date) {

		Cotisation cotisation = cotisationRepository.findOne(cotisationId);
		if (cotisation != null) {
			return transactionRepository
					.findAllBeneficesByCotisationAndDateOperation(cotisation,
							date);
		}

		return null;

	}

	@Override
	public List<Transaction> findAllPretByCotisationAndDate(long cotisationId,
			long date) {

		Cotisation cotisation = cotisationRepository.findOne(cotisationId);
		if (cotisation != null) {
			return transactionRepository
					.findAllPretsByCotisationAndDateOperation(cotisation, date);
		}

		return null;

	}

	@Override
	public List<Transaction> findAllRemboursementByCotisationAndDate(
			long cotisationId, long date) {

		Cotisation cotisation = cotisationRepository.findOne(cotisationId);
		if (cotisation != null) {
			return transactionRepository
					.findAllRemboursementsByCotisationAndDateOperation(
							cotisation, date);
		}

		return null;

	}

	@Override
	public List<Transaction> findAll() {
		return (List<Transaction>) transactionRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		Transaction exist = transactionRepository.findOne(id);
		if (exist == null) {
			throw new IllegalArgumentException("transaction doesn't exist");
		}

		transactionRepository.delete(id);
	}
}

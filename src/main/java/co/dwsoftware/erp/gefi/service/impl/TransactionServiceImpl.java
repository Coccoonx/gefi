package co.dwsoftware.erp.gefi.service.impl;

import co.dwsoftware.erp.gefi.model.Cotisation;
import co.dwsoftware.erp.gefi.model.Membre;
import co.dwsoftware.erp.gefi.model.Transaction;
import co.dwsoftware.erp.gefi.model.TypeTransaction;
import co.dwsoftware.erp.gefi.repository.CotisationRepository;
import co.dwsoftware.erp.gefi.repository.MembreRepository;
import co.dwsoftware.erp.gefi.repository.TransactionRepository;
import co.dwsoftware.erp.gefi.service.TransactionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lyonnel on 02/09/16.
 */
@Component
public class TransactionServiceImpl implements TransactionService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	CotisationRepository cotisationRepository;
	@Autowired
	MembreRepository membreRepository;

	@Override
	public Transaction create(Transaction transaction) {

		Transaction exist = transactionRepository
				.findByMembreAndCotisationAndDateAndType(
						transaction.getMembre(), transaction.getCotisation(),
						transaction.getDateOperation(), transaction.getType());
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
	public List<Transaction> findAllPretSuiviByCotisation(long cotisationId) {

		Cotisation cotisation = cotisationRepository.findOne(cotisationId);
		if (cotisation != null) {
			List<Transaction>  transactions = transactionRepository
					.findAllPretsSuiviByCotisation(cotisation);
			
			Set<Long> jours = new HashSet<>();
			List<Transaction> tuples = new ArrayList<>();
			for(Transaction t : transactions){
				if(!jours.contains(t.getDateOperation()))
					jours.add(t.getDateOperation());
			}
			
			for(Long j : jours){
				Transaction t = new Transaction();
				t.setDateOperation(j);
				t.setCotisation(cotisation);
				t.setMontantOperation(0.0);
				t.setType(TypeTransaction.EMPRUNTER);
				t.setMembre(membre);
				for(Transaction tmp : transactions){
					if(tmp.getDateOperation()== j){
						t.setMontantOperation(t.getMontantOperation()+tmp.getMontantOperation());
					}
				}
				tuples.add(t);
				
			}
			return tuples;
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
	public List<Transaction> findAllEpargneByCotisationAndMembre(
			long cotisationId, long membreId) {

		Cotisation cotisation = cotisationRepository.findOne(cotisationId);
		Membre membre = membreRepository.findOne(membreId);

		logger.info("Params cotisation{}, membre{}", cotisation, membre);
		if (cotisation != null && membre != null) {
			return transactionRepository.findAllEpargnesByCotisationAndMembre(
					cotisation, membre);
		}

		return null;

	}

	@Override
	public List<Transaction> findAllEpargneByCotisation(long cotisationId) {

		Cotisation cotisation = cotisationRepository.findOne(cotisationId);

		logger.info("Params cotisation{}, membre{}", cotisation);
		if (cotisation != null) {
			List<Transaction> transactions = transactionRepository
					.findAllEpargnesByCotisation(cotisation);

			Set<Membre> epargneurs = new HashSet<>();
			List<Transaction> tuples = new ArrayList<>();
			for (Transaction t : transactions) {
				if (!epargneurs.contains(t.getMembre()))
					epargneurs.add(t.getMembre());
			}

			for (Membre m : epargneurs) {
				Transaction t = new Transaction();
				t.setCotisation(cotisation);
				t.setMembre(m);
				t.setMontantOperation(0.0);
				t.setType(TypeTransaction.EPARGNER);
				for (Transaction tmp : transactions) {
					if (tmp.getMembre().equals(m)) {
						t.setMontantOperation(t.getMontantOperation()
								+ tmp.getMontantOperation());
					}
				}
				tuples.add(t);

			}
			return tuples;
		}

		return null;

	}

	@Override
	public List<Transaction> findAllEpargneByCotisationSuivi(long cotisationId) {

		Cotisation cotisation = cotisationRepository.findOne(cotisationId);

		logger.info("Params cotisation{}, membre{}", cotisation);
		if (cotisation != null) {
			List<Transaction> transactions = transactionRepository
					.findAllEpargnesByCotisation(cotisation);

			Set<Long> jours = new HashSet<>();
			List<Transaction> tuples = new ArrayList<>();
			for (Transaction t : transactions) {
				if (!jours.contains(t.getDateOperation()))
					jours.add(t.getDateOperation());
			}

			for (Long j : jours) {
				Transaction t = new Transaction();
				t.setDateOperation(j);
				t.setCotisation(cotisation);
				t.setMontantOperation(0.0);
				t.setType(TypeTransaction.EPARGNER);
				for (Transaction tmp : transactions) {
					if (tmp.getDateOperation() == j) {
						t.setMontantOperation(t.getMontantOperation()
								+ tmp.getMontantOperation());
					}
				}
				tuples.add(t);
			}
			return tuples;
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

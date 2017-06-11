package co.dwsoftware.erp.gefi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private long dateCreation;

	@NotNull
	private long dateDerniereModification;

	@NotNull
	private long dateTransaction;

	private long dateRemboursement;

	private int duree;

	private double nombre; // Durée * Montant

	private double montantTransaction;

	private double montantAttendu;

	private double montantAvance;

	private double tauxInteret;

	private double montantPenalites;

    private double montantBeneficie;

    private double montantRetenu;

    private double montantPlace;

	@ManyToOne
	private Membre avaliseur1;

	@ManyToOne
	private Membre avaliseur2;

	@NotNull
	private TypeTransaction type;

	@ManyToOne
	@NotNull
	private Membre membre;

	@ManyToOne
	@NotNull
	private Cotisation cotisation;

	public Transaction() {
		dateCreation = new Date().getTime();

		dateDerniereModification = new Date().getTime();
	}

}

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

import lombok.Data;

@Data
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@CreatedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation = new Date();
	
	@LastModifiedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDerniereModification = new Date();

	@CreatedDate
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOperation ;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRemboursement;

	private double montantOperation;
	
	private double montantAttendu;
	
	private double montantAvance;

	private double tauxInteret;
	
	private double montantPenalités;

	@ManyToOne
	private Membre avalyseur1;
	
	@ManyToOne
	private Membre avalyseur2;

	private TypeTransaction type;

	@ManyToOne
	@NotNull
	private Membre membre;

	@ManyToOne
	@NotNull
	private Cotisation cotisation;

}

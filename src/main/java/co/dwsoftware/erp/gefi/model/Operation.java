package co.dwsoftware.erp.gefi.model;

import java.util.Date;







import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@NotNull
    private long dateCreation;

	@NotNull
    private long dateDerniereModification;

	@NotNull
    private long dateOperation;

    private long dateRemboursement;

    private double montantOperation;

    private double montantAttendu;

    private double montantAvance;

    private double montantPenalites;

    @NotNull
    private TypeOperation type;
    
    @ManyToOne
    @NotNull
    private Membre membre;

    @ManyToOne
    @NotNull
    private Service service;
    
    private long idOperationInitiale;



    

}

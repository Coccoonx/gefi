package co.dwsoftware.erp.gefi.model;

import java.util.Date;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Created by lyonnel on 03/09/16.
 */
@Entity
@Data
public class Cotisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nom;
    
    @CreatedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation = new Date();
	
	@LastModifiedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDerniereModification = new Date();

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private TypeCotisation type;
    
    private double montant;

    private String annee;

    private String dateDebut;

    private String dateFin;



}

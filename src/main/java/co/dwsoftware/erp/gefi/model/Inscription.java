package co.dwsoftware.erp.gefi.model;

import lombok.Data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


@Entity
@Data
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nom;

    @CreatedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInscription = new Date();
    
    @LastModifiedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDerniereModification = new Date();


    private double montant;

    @ManyToOne
    private Membre inscrit;

    @ManyToOne
//    @Nullable(value=false)
    private Annee annee;

}

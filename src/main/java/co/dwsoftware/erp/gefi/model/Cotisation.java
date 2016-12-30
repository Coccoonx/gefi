package co.dwsoftware.erp.gefi.model;

import lombok.Data;

import javax.persistence.*;

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

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Type type;

    private String annee;

    private String dateDebut;

    private String dateFin;



}

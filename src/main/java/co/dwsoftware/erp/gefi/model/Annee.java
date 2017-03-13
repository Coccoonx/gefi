package co.dwsoftware.erp.gefi.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Annee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nom;

    private String dateDebut;

    private String dateFin;
}

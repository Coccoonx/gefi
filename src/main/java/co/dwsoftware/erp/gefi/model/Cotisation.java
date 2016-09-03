package co.dwsoftware.erp.gefi.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lyonnel on 03/09/16.
 */
public class Cotisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nom;

    private String type;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;


}

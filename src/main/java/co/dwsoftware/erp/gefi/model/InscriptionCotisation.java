package co.dwsoftware.erp.gefi.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Data
public class InscriptionCotisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @CreatedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInscription = new Date();

    private double montant;

    @ManyToOne
    private Membre membre;

    @ManyToOne
//    @Nullable(value=false)
    private Cotisation cotisation;

}

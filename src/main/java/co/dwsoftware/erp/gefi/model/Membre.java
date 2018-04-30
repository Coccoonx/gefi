package co.dwsoftware.erp.gefi.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String prenom;
    private String nom;
    private String cni;
    private String photo;
    private String telephone;
    private String adresse;

    @Enumerated(value = EnumType.STRING)
    private Statut statut = Statut.Actif;

    @CreatedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation = new Date();

    @LastModifiedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDerniereModification = new Date();
}

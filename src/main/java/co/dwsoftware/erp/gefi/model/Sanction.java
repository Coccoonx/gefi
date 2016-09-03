package co.dwsoftware.erp.gefi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by lyonnel on 03/09/16.
 */
@Entity
@Data
public class Sanction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String motif;
}

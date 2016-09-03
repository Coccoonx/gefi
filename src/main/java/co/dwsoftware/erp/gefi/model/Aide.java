package co.dwsoftware.erp.gefi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lyonnel on 03/09/16.
 */
@Entity
@Data
public class Aide {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String motif;
}

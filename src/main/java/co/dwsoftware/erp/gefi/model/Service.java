package co.dwsoftware.erp.gefi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * Created by lyonnel on 03/09/16.
 */
@Entity
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String motif;
    
    @CreatedDate
    @NotNull
    private long dateCreation = new Date().getTime();
	
	@LastModifiedDate
    @NotNull
    private long dateDerniereModification = new Date().getTime();
	
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private TypeService type;
}

package co.dwsoftware.erp.gefi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Membre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String prenom;
	private String nom;
	private String numeroCni;
	private String photo;
	private String telephone;
	private String adresse;
}

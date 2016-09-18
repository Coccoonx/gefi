package co.dwsoftware.erp.gefi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}

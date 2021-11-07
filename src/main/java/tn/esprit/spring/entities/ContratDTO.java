package tn.esprit.spring.entities;

import java.util.Date;
import javax.persistence.Entity;


@Entity
public class ContratDTO {


	private Date dateDebut;
	private String typeContrat;
	private float telephone;
	private Employe employe;
	private float salaire;

	
	
}
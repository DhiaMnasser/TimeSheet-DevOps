package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;


public class ContratDTO {


	private Date dateDebut;
	
	private String typeContrat;
	
	
	private float telephone;
	

	private Employe employe;

	private float salaire;

	
	
}

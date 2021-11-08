package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class DepartementDTO {


	private String name;

	private List<Employe> employes;
	
	private List<Mission> missions;
	
	private Entreprise entreprise;



}

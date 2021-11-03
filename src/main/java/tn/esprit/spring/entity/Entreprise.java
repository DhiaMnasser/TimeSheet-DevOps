package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;



 

@Entity
public class Entreprise implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7445417260327554109L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	private String name ; 
	private String raisonSocial;
	
	
	
	
	@OneToMany(mappedBy ="entreprise",fetch = FetchType.EAGER,cascade = {CascadeType.REMOVE,CascadeType.REFRESH})
	private List<Departement>departements;
	
	
	
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	
	
	
	
	
	
	
	

}

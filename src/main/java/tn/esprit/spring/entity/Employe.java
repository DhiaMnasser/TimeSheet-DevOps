package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6783200708580771172L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String prenom;
	private String nom;
	private String email;
	private boolean isActif;
	@Enumerated(EnumType.STRING)
	private Role role;

	@JsonIgnore
	@OneToOne(mappedBy = "employe")
	private Contrat contrat;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "employes", cascade = CascadeType.REMOVE)
	private List<Departement> departements = new ArrayList<Departement>();

	

	@JsonIgnore
	@OneToMany(mappedBy = "employe")
	public List<TimeSheet> timeSheets;

	public Employe() {

	}

	public List<TimeSheet> getTimeSheets() {
		return timeSheets;
	}

	public void setTimeSheets(List<TimeSheet> timeSheets) {
		this.timeSheets = timeSheets;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

	

	@Override
	public String toString() {
		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", isActif=" + isActif
				+ ", role=" + role ;
	}

}

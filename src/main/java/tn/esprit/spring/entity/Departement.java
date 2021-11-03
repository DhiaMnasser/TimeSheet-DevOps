package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Departement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4915993017121372401L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<Employe> employes = new ArrayList<Employe>();

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Entreprise entreprise;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "departement")
	private List<Mission> missions;

	public Departement() {

	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public int getId() {
		return id;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
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

}

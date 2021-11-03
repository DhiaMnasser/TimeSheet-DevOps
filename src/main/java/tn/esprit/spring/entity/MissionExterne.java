package tn.esprit.spring.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MissionExterne extends Mission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5122768708793136578L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String emailFacturation;
	private int tauxJournalierMoyen;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailFacturation() {
		return emailFacturation;
	}

	public void setEmailFacturation(String emailFacturation) {
		this.emailFacturation = emailFacturation;
	}

	 

	public int getTauxJournalierMoyen() {
		return tauxJournalierMoyen;
	}

	public void setTauxJournalierMoyen(int tauxJournalierMoyen) {
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

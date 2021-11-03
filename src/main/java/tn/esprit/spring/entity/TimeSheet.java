package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class TimeSheet implements Serializable {

	
	private static final long serialVersionUID = 130162220366853472L;
	

	@EmbeddedId
	private PK pk;

	@ManyToOne
	@JoinColumn(name = "missionId", referencedColumnName = "id", insertable = false, updatable = false)

	private Mission mission;

	@ManyToOne
	@JoinColumn(name = "employeId", referencedColumnName = "id", insertable = false, updatable = false)

	private Employe employe;
	
	
	
	
	
	
	private Date dateDebut;
	
	private Date dateFin;
	
	
	private boolean isValid;
	
	
	
	
	
	
	

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public PK getPk() {
		return pk;
	}

	public void setPk(PK pk) {
		this.pk = pk;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}

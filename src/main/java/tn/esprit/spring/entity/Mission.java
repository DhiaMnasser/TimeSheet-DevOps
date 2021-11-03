package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

 

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE")
public class Mission  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7710220125234511036L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	private String name ; 
	private String description ;
	
	
	@ManyToOne
	private Departement departement;
	
	
	
	
	
	
	@OneToMany( mappedBy = "mission")
	public List<TimeSheet>timeSheets;
	
	
	
	
	
	
	public List<TimeSheet> getTimeSheets() {
		return timeSheets;
	}
	public void setTimeSheets(List<TimeSheet> timeSheets) {
		this.timeSheets = timeSheets;
	}
	public int getId() {
		return id;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	
 
	
	
	
	

}

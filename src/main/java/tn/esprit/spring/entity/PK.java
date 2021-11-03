package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -463578715800186672L;
	
	
	private int missionId;
	private int employeId;
	
	
	
	
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public int getEmployeId() {
		return employeId;
	}
	public void setEmployeId(int employeId) {
		this.employeId = employeId;
	}
	
	
	
	
	
	
	
	 
	
	
	

}

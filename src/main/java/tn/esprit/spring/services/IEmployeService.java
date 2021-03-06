package tn.esprit.spring.services;


import java.util.List;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.EmployeDTO;
import tn.esprit.spring.entities.Entreprise;


public interface IEmployeService {
	public Employe authenticate(String login, String password) ;
	public void mettreAjourEmailByEmployeId(String email, int employeId);
	public void affecterEmployeADepartement(int employeId, int depId);
	public void desaffecterEmployeDuDepartement(int employeId, int depId);
	public void affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public int deleteEmployeById(int employeId);
	public Integer getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise);
	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId);
	public float getSalaireByEmployeIdJPQL(int employeId);
	public Double getSalaireMoyenByDepartementId(int departementId);
	public List<Employe> getAllEmployes();
	Integer addOrUpdateEmploye(EmployeDTO employe);
	
	
}
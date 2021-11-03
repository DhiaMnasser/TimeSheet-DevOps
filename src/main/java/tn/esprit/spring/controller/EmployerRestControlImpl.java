package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Contrat;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.service.IEmployeService;

@RestController
public class EmployerRestControlImpl {

	@Autowired
	IEmployeService employeService;

	@PostMapping("/add-emp")
	@ResponseBody
	public int ajouterEmployer(@RequestBody Employe employe) {

		return employeService.ajouterEmploye(employe);
	}

	

	@PostMapping("/affecter-employer-departement/{idemp}/{iddep}")
	@ResponseBody
	public void affecterEmployeADepartement(@PathVariable("idemp") int emp, @PathVariable("iddep") int dep) {

		employeService.affecterEmployeADepartement(emp, dep);
	}

	@PostMapping("/ajouter-contrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody Contrat contrat) {

		return employeService.ajouterContrat(contrat);
	}

	@PostMapping("/affecter-contrat-emp/{ref}/{idE}")
	@ResponseBody
	public void affecterContratEmp(@PathVariable("ref") int ref, @PathVariable("idE") int idE) {

		employeService.affecterContratAEmploye(ref, idE);

	}
	
	
	@GetMapping("/getEmployePrenomById/{id}")
	@ResponseBody
	public String getEmployePrenomById(@PathVariable("id")int id) {
		
	
		return employeService.getEmployePrenomById(id);
		
	}
	
	
	@GetMapping("/getNombreEmployerJPQL")
	@ResponseBody
	public long getNombreEmployerJPQL() {
		
		return employeService.getNombreEmployeJPQL();
	}
	
	@GetMapping("/getAllEmployeNamesJPQL")
	@ResponseBody
	public List<String> getAllEmployeNamesJPQL(){
		
		return employeService.getAllEmployeNamesJPQL();
	}
	
	
	
	
	
	
	
	
	
	

	 

}

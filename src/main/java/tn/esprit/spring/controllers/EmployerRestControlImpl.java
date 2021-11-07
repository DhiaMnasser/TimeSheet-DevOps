package tn.esprit.spring.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.ContratDTO;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.EmployeDTO;
import tn.esprit.spring.services.IEmployeService;


@RestController
public class EmployerRestControlImpl {

	@Autowired
	IEmployeService employeService;

	@PostMapping("/add-emp")
	@ResponseBody
	public int ajouterEmployer(@RequestBody EmployeDTO employeDTO) throws ParseException {
		
		 Employe persistantEmploye = Employe.convertToEntity(employeDTO);
		return employeService.addOrUpdateEmploye(persistantEmploye);
	}

	

	@PostMapping("/affecter-employer-departement/{idemp}/{iddep}")
	@ResponseBody
	public void affecterEmployeADepartement(@PathVariable("idemp") int emp, @PathVariable("iddep") int dep) {

		employeService.affecterEmployeADepartement(emp, dep);
	}

	@PostMapping("/ajouter-contrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody ContratDTO contratDTO) throws ParseException  {
		Contrat persistantContrat = Contrat.convertToEntity(contratDTO);
		return employeService.ajouterContrat(persistantContrat);
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

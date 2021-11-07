package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RestController
public class EnrepriseRestControllerImpl {

	@Autowired
	IEntrepriseService entrepriseService;

	@PostMapping("/add-entreprise")
	@ResponseBody
	public int ajouterEntreprise(@RequestBody Entreprise entreprise) {

		return entrepriseService.ajouterEntreprise(entreprise);
	}

	@PostMapping("/add-departement")
	@ResponseBody
	public int ajouterDepartement(@RequestBody Departement dep) {

		return entrepriseService.ajouterDepartement(dep);
	}

	@PostMapping("/affecter-dep-en/{idDep}/{idEnt}")
	@ResponseBody
	public void affecterDepartementEntreprise(@PathVariable("idDep") int idDep, @PathVariable("idEnt") int idEnt) {

		entrepriseService.affecterDepartementAEntreprise(idDep, idEnt);

	}
	
	
	

	@GetMapping("/getAllDepartementsNamesByEntreprise/{id}")
	@ResponseBody
	public List<String> getAllDepartementsNamesByEntreprise(@PathVariable("id") int entrepriseId) {
		return entrepriseService.getAllDepartementsNamesByEntreprise(entrepriseId);

	}

	

}

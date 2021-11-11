package tn.esprit.spring.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.DepartementDTO;

import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

public class RestControllerDepartement {

	@Autowired
	IDepartementService idepartementservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(RestControllerDepartement.class);


	
	// http://localhost:8081/SpringMVC/servlet/ajouterDepartementr
	//{"id":1,"nom":"mnasser", "prenom":"dhia", "email":"dhia.mnasser@xyz.tn", "isActif":true, "role":"INGENIEUR"}
	
	@PostMapping("/ajouterDepartementr")
	@ResponseBody
	public Departement ajouterDepartement(@RequestBody DepartementDTO departementDTO) throws ParseException
	{ 
		Departement persistantDepartement = Departement.convertToEntity(departementDTO);
		
		idepartementservice.ajouterDepartement(persistantDepartement);
		
		return persistantDepartement;
	}

	

    // URL : http://localhost:8081/SpringMVC/servlet/deleteDepartementById/1
    @DeleteMapping("/deleteDepartementById/{iddep}") 
	@ResponseBody 
	public void deleteDepartementById(@PathVariable("iddep")int departementId) {
    	
		idepartementservice.deleteDepartementById(departementId);
		
	}

    // URL : http://localhost:8081/SpringMVC/servlet/deleteAllContratJPQL
    @DeleteMapping("/deleteAllDepartements") 
	@ResponseBody
	public void deleteAllDepartments() {
    	
		idepartementservice.deleteDepartementById(1);
		
	}


	 // URL : http://localhost:8081/SpringMVC/servlet/getAllDepartements
	@GetMapping(value = "/getAllDepartements")
    @ResponseBody
	public List<Departement> getAllDepartements() {
		
		return idepartementservice.getAllDepartements();
	}

		
	
}

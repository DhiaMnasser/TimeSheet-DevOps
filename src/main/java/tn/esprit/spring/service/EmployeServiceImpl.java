package tn.esprit.spring.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.repository.IContratRepository;
import tn.esprit.spring.repository.IDepartementRepository;
import tn.esprit.spring.repository.IEmployeReppsitory;
import tn.esprit.spring.repository.IEntrepriseRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	private static Logger logger = LoggerFactory.getLogger(EmployeServiceImpl.class);

	@Autowired
	IEmployeReppsitory employeR;

	@Autowired
	IDepartementRepository depR;

	@Autowired
	IContratRepository contratR;

	@Autowired
	IEntrepriseRepository entrepriseR;

	@Override
	public int ajouterEmploye(Employe employe) {

		return employeR.save(employe).getId();

	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {

		Employe employe = employeR.findById(employeId).orElse(null);

		Departement departement = depR.findById(depId).orElse(null);

		departement.getEmployes().add(employe);

		depR.save(departement);

	}

	@Override
	public int ajouterContrat(Contrat contrat) {

		return contratR.save(contrat).getReference();

	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {

		Contrat contrat = contratR.findById(contratId).orElse(null);

		logger.info(" ref contrat: {}", contrat.getReference());

		Employe employe = employeR.findById(employeId).get();

		logger.info(" id employe: {}", employe.getId());

		contrat.setEmploye(employe);

		contratR.save(contrat);

	}

	@Override
	public String getEmployePrenomById(int employeId) {

		return employeR.findById(employeId).get().getPrenom();

	}

	@Override
	public long getNombreEmployeJPQL() {
		return employeR.nombreEmploye();
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		return employeR.getAllEmployeNamesJPQL();
	}

	

}

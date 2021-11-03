package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.IDepartementRepository;
import tn.esprit.spring.repository.IEntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	IEntrepriseRepository entrepriseRep;

	@Autowired
	IDepartementRepository departR;

	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		return entrepriseRep.save(entreprise).getId();
	}

	@Override
	public int ajouterDepartement(Departement dep) {
		return departR.save(dep).getId();
	}

	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {

		Departement departement = departR.findById(depId).get();

		Entreprise entreprise = entrepriseRep.findById(entrepriseId).get();

		departement.setEntreprise(entreprise);

		departR.save(departement);

	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {

		return departR.getAllDepartementsNamesByEntreprise(entrepriseId);
	}

	

	

}

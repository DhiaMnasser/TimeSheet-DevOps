package tn.esprit.spring.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Entreprise;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {
	
	
}

package tn.esprit.spring.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Contrat;

@Repository
public interface IContratRepository extends CrudRepository<Contrat, Integer> {

}

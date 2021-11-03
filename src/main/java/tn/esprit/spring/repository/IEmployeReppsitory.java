package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Employe;

@Repository
public interface IEmployeReppsitory extends CrudRepository<Employe, Integer> {

	@Query("select count(e) from Employe e ")
	public long nombreEmploye();

	@Query("select e.nom from Employe e ")
	public List<String> getAllEmployeNamesJPQL();

	
}

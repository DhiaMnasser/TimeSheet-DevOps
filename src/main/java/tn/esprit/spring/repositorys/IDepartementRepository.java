package tn.esprit.spring.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

@Repository
public interface IDepartementRepository extends CrudRepository<Departement, Integer> {

	@Query("select d.name from Departement d where d.entreprise.id= :idp ")
	public List<String> getAllDepartementsNamesByEntreprise(@Param("idp") int id);

	public List<Departement> findByEntreprise(Entreprise e);

}

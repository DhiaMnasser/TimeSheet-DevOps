package tn.esprit.spring.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Mission;

@Repository
public interface MissionRepository extends CrudRepository<Mission, Integer> {

}

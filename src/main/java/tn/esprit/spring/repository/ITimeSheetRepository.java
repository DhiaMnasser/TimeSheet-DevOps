package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.PK;
import tn.esprit.spring.entity.TimeSheet;

@Repository
public interface ITimeSheetRepository extends CrudRepository<TimeSheet, PK> {

}

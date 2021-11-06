package tn.esprit.spring.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.entities.Timesheet;

@Repository
public interface ITimeSheetRepository extends CrudRepository<Timesheet, TimesheetPK> {

}

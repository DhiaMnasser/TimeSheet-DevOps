package tn.esprit.spring.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.entity.PK;
import tn.esprit.spring.entity.TimeSheet;
import tn.esprit.spring.repository.IDepartementRepository;
import tn.esprit.spring.repository.IEmployeReppsitory;
import tn.esprit.spring.repository.IMissionRepository;
import tn.esprit.spring.repository.ITimeSheetRepository;

@Service
public class TimeSheetServiceImpl implements ITimeSheetService {

	private static Logger logger = LoggerFactory.getLogger(EmployeServiceImpl.class);

	@Autowired
	IMissionRepository missionR;

	@Autowired
	IDepartementRepository departementR;

	@Autowired
	IEmployeReppsitory employeR;

	@Autowired
	ITimeSheetRepository timeSheetR;

	@Override
	public int ajouterMission(Mission mission) {
		return missionR.save(mission).getId();
	}

	@Override
	public void affecterMissionADepartement(int missionId, int depId) {

		Mission mission = missionR.findById(missionId).get();

		Departement departement = departementR.findById(depId).get();

		mission.setDepartement(departement);

		missionR.save(mission);

	}

	@Override
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {

		Employe employe = employeR.findById(employeId).get();

		Mission mission = missionR.findById(missionId).get();
		
		PK pk = new PK();
		pk.setEmployeId(employeId);
		pk.setMissionId(missionId);

		TimeSheet timeSheet = new TimeSheet();
		
		

		logger.info("Add TimeSheet");
		
		timeSheet.setPk(pk);
		
		timeSheet.setDateDebut(dateDebut);
		timeSheet.setDateFin(dateFin);
		
		timeSheet.setEmploye(employe);
		timeSheet.setMission(mission);
		
		

		timeSheetR.save(timeSheet);

		

		 

	}

}

package tn.esprit.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.service.ITimeSheetService;

@RestController
public class TimeSheetRestControllerImpl {

	@Autowired
	ITimeSheetService timeSheetService;

	@PostMapping("/ajouterMission")
	@ResponseBody
	public int ajouterMission(@RequestBody Mission mission) {

		return timeSheetService.ajouterMission(mission);

	}

	@PostMapping("affecterMissionADepartement/{missionId}/{depId}")
	@ResponseBody
	public void affecterMissionADepartement(@PathVariable("missionId") int missionId,
			@PathVariable("depId") int depId) {

		timeSheetService.affecterMissionADepartement(missionId, depId);
	}

	@PostMapping("ajouterTimesheet/{idm}/{idem}/{dateD}/{dateF}")
	@ResponseBody
	public void ajouterTimesheet(@PathVariable("idm")int missionId, @PathVariable("idem")int employeId,@PathVariable("dateD") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateDebut,@PathVariable("dateF") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateFin) {
		timeSheetService.ajouterTimesheet(missionId, employeId, dateDebut, dateFin);
	}

}

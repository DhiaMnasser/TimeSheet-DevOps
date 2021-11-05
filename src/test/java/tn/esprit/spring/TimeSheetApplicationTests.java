package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tn.esprit.spring.controllers.ControllerEmployeImpl;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;




@SpringBootTest
class TimesheetApplicationTests {
	private static final Logger l = LogManager.getLogger(TimesheetApplicationTests.class.getName());

	
	@Autowired
	ControllerEmployeImpl employeControl;
	
	@Test
	void contextLoads() {

	
	}
}

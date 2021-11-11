package tn.esprit.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.controllers.ControllerEmployeImpl;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
public class EmployeTests {
 Employe E = new Employe();
	
	ControllerEmployeImpl employeControl;
 @Test
	public void ajouterEmploye() {
		Employe employe= new Employe("test","test","test.test@esprit.tn",true,Role.INGENIEUR);
		employeControl.ajouterEmploye(employe);
    }
 
@Test    
    public void employeActif(){
    	E.isActif();
    	return;
    }

@Test    
    public void employeEmailExist(){
	Employe employe= new Employe("test","test","test.test@esprit.tn",true,Role.INGENIEUR);
    String mail = E.getEmail();
    return;
    }

}

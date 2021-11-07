package tn.esprit.spring;

import org.junit.Test;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
public class EmployeTests {
 Employe E = new Employe();
 
 @Test
	public void ajouterEmploye() {
		Employe employe= new Employe("test","test","test.test@esprit.tn",true,Role.INGENIEUR);
		return;
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

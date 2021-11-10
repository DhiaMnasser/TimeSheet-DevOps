package tn.esprit.spring;

import org.junit.Test;
import tn.esprit.spring.services.IEmployeService;
import org.springframework.beans.factory.annotation.Autowired;



import tn.esprit.spring.entities.*;
import java.util.Date;

import org.junit.Assert;
public class EmployeTests {
	
	@Autowired
	IEmployeService employeService;

	
 Employe E = new Employe();
 Employe e = new Employe("hajer", "hajer", "hajerhajer@esprit.tn",true,Role.INGENIEUR);
 Date d = new Date();
 Contrat c2 = new Contrat(2,d,"CDE",2002);
 
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

@Test
public void ajouterContrat()
{
	//Test d'ajoutd'un contrat
	
	Date d = new Date();
	Contrat c = new Contrat(1,d,"CDI",2000);
	return;	

}

@Test
public void deleteContratById()
{
	int contratId = 1;

	
}

@Test
public void affecterContratAEmploye()
{
	int contratId = 1;
	int employeId=1;
	
}


}


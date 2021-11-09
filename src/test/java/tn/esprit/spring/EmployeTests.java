package tn.esprit.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.services.IEmployeService;

import tn.esprit.spring.entities.*;
import java.util.Date;

import org.junit.Assert;
public class EmployeTests {
	
	@Autowired
	IEmployeService empl ;
 Employe E = new Employe();
 Employe e = new Employe("hajer", "hajer", "hajerhajer@esprit.tn",true,Role.INGENIEUR);
	Contrat c2 = new Contrat();
 
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

public void testAjouterContrat()
{
	//Test d'ajoutd'un contrat
	
	Date d = new Date();
	Contrat c = new Contrat(1,d,"CDI",2000);
	//test type contrat not null
			Assert.assertNotNull("Type contrat mustn't be null", c.getTypeContrat());
			//test date 
		Assert.assertEquals(c.getDateDebut(), d);
	  empl.ajouterContrat(c);

}

@Test
public void testAffecterContratAEmploye()
{
	int contratId = 1;
	int employeId=1;
	empl.affecterContratAEmploye(contratId, employeId);
}

@Test
public void testDeleteContratById()
{
	int contratId = 1;
	empl.deleteContratById(contratId);
	
}

@Test
public void testdeleteAllContratJPQL()
{
	empl.deleteAllContratJPQL();
	
}

}



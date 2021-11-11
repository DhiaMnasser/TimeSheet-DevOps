package tn.esprit.spring;

import java.util.List;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.controllers.ControllerDepartementImpl;
import tn.esprit.spring.controllers.ControllerEmployeImpl;
import tn.esprit.spring.controllers.ControllerEntrepriseImpl;
import tn.esprit.spring.controllers.ControllerTimesheetImpl;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repositorys.DepartementRepository;
import tn.esprit.spring.repositorys.EmployeRepository;
import tn.esprit.spring.repositorys.EntrepriseRepository;
import tn.esprit.spring.repositorys.TimesheetRepository;

import javax.transaction.Transactional;

//@SpringBootTest
public class TimeSheetApplicationTests {
	private static final Logger l = LogManager.getLogger(TimeSheetApplication.class);

	// private static final Logger l = Logger.getLogger(TimesheetApplication.class);
	@Autowired
	ControllerEntrepriseImpl entrepriseControl;
	@Autowired
	ControllerEmployeImpl employeControl;
	@Autowired
	ControllerDepartementImpl depControl;
	@Autowired
	EmployeRepository employeRepository;
	@Autowired 
	DepartementRepository deprepo;
	@Autowired
	EntrepriseRepository entrepriseRepo;
	@Autowired
	TimesheetRepository timesheetRepository ;
	@Autowired 
	ControllerTimesheetImpl controllerTimesheet;
	
	
	@Test
	public void ajouterEmploye() {
		Employe employe= new Employe("test","test","test.test@esprit.tn",true,Role.INGENIEUR);
		Integer dAdded = employeControl.ajouterEmploye(employe);
	}
	
	@Test
	public void getDeps() {
       depControl.getAllDepartement();
	}
	 
	@Transactional
	@Test
	public void testajouterDepartementAEntreprise() {

		l.info("lancer  la methode ajouter departement");
		l.debug("je vais lancer la methode save du departement");
		Entreprise ssiiConsulting = new Entreprise("SSII Consulting", "Cite El Ghazela");
		Departement depTelecom = new Departement("Telecom");
		Departement depRH = new Departement("RH");
		ssiiConsulting.addDepartement(depRH);
		ssiiConsulting.addDepartement(depTelecom);
		l.debug("je viens de finir save de departement");
		l.info("fin de  la methode ajouter departement");
	}

	@Transactional
	@Test
	public void affecterDepartementAEntreprise() {

		l.info("lancer  la methode affectation departement a entreprise");
		l.debug("je vais lancer la recherche de l'entreprise par id ");

		Entreprise ssiiConsulting = new Entreprise("SSII Consulting", "Cite El Ghazela");
		Departement depTelecom = new Departement("Telecom");
		Departement depRH = new Departement("RH");
		int ssiiConsultingId = entrepriseControl.ajouterEntreprise(ssiiConsulting);
		ssiiConsulting.setId(ssiiConsultingId);
		depTelecom.setEntreprise(ssiiConsulting);
		int depTelecomId = entrepriseControl.ajouterDepartement(depTelecom);
		depRH.setEntreprise(ssiiConsulting);
		int depRhId = entrepriseControl.ajouterDepartement(depRH);

		entrepriseControl.affecterDepartementAEntreprise(depTelecomId, ssiiConsultingId);
		entrepriseControl.affecterDepartementAEntreprise(depRhId, ssiiConsultingId);
		l.debug("je viens de faire l'update l'update de l'ntreprise et l'enregistré");
		l.info("fin de   la methode affectation departement a entreprise");
	}

	@Transactional
	@Test
	public void getDepartementsNamesByEntreprise() {

		l.info("lancer  la methode get all department names by entreprise");
		l.debug("lancer  la recherche de l entreprise par id");
		Entreprise ssiiConsulting = new Entreprise("SSII Consulting", "Cite El Ghazela");
		int ssiiConsultingId = entrepriseControl.ajouterEntreprise(ssiiConsulting);
		l.debug("je viens de trouver l entreprise" + ssiiConsultingId);

		List<String> departements =
				entrepriseControl.getAllDepartementsNamesByEntreprise(ssiiConsultingId);
		for (String departementName : departements) {
			l.info(departementName);
		}
		l.debug("je viens de remplir le tableau depNames");
		l.info("fin de   la methode get all department names by entreprise");

	}

	@Transactional
	@Test
	public void mettreAjourEmailByEmployeIdJPQL() {

		l.info("lancer la methode mettreAjourEmailByEmployeIdJPQL");
		l.debug("je vais mettre ajour l'email d'un employe a traver son id");
		Employe employe = new Employe("mohamed", "devops", "mohameddevops@email.com",
				"123ingenieur", true, Role.INGENIEUR);
		int employeId = employeControl.ajouterEmploye(employe);
		Assert.assertNotNull(employeControl.getEmployePrenomById(employeId));
		employeRepository.mettreAjourEmailByEmployeIdJPQL("devops@gmail.com", employeId);
		l.debug("je viens de mettre ajour l'email d'un employe a traver son id");
		l.info("fin de  la methode  mettreAjourEmailByEmployeIdJPQL");

	}
	
	@Transactional
	@Test
	public void testajouterEmploye(){
		Employe employe =new Employe("arij", "mansour", "arijmansour@email.com","123ingenieur", true, Role.INGENIEUR);
		Employe admin =new Employe("hamma", "elhami", "hammaelhami@email.com","123admin", true, Role.ADMINISTRATEUR);
		l.info("you are in testajouterEmployer()");		
		int employeId =employeControl.ajouterEmploye(employe);
		int adminId=employeControl.ajouterEmploye(admin);
		Assert.assertNotNull(employeRepository.findById(employeId));
		Assert.assertNotNull(employeRepository.findById(adminId));
		l.debug( "employe ajouté"+ employeId);
	}

	@Transactional
	@Test
	public void testaffecterEmployeADepartement(){
		l.info("you are in testaffecterEmployeADepartement()");		
		Employe employe =new Employe("arij", "mansour", "arijmansour@email.com","123ingenieur", true, Role.INGENIEUR);
		Departement depTelecom = new Departement("Telecom");
		int employeId =employeControl.ajouterEmploye(employe);

		Entreprise ssiiConsulting = new Entreprise("SSII Consulting","Cite El Ghazela"); 

		ssiiConsulting.addDepartement(depTelecom); 
		Assert.assertNotNull(employeRepository.findById(employeId));   
		int depTelecomId = entrepriseControl.ajouterDepartement(depTelecom);
		Assert.assertNotNull(deprepo.findById(depTelecomId));
		employeControl.affecterEmployeADepartement(employeId, depTelecomId);
		l.debug( "employe "+employeId + "affecter"+" a departement"+ depTelecomId);
	}

	@Transactional
	@Test
	public void testdesaffecterEmployeADepartement(){
		l.info("you are in testdesaffecterEmployeADepartement()");	
		Employe employe =new Employe("arij", "mansour", "arijmansour@email.com","123ingenieur", true, Role.INGENIEUR);

		Entreprise ssiiConsulting = new Entreprise("SSII Consulting","Cite El Ghazela"); 

		int employeId=employeControl.ajouterEmploye(employe);
		Departement depTelecom = new Departement("Telecom");
		ssiiConsulting.addDepartement(depTelecom); 
		Assert.assertNotNull(employeRepository.findById(employeId));
		int depTelecomId = entrepriseControl.ajouterDepartement(depTelecom);
		Assert.assertNotNull(deprepo.findById(depTelecomId));
		employeControl.affecterEmployeADepartement(employeId, depTelecomId);
		employeControl.desaffecterEmployeDuDepartement(employeId, depTelecomId);
		l.debug( "employe " + employeId + "desaffecter" + "a departement"+ depTelecomId);   
	}

	@Transactional
	@Test
	public void testmettreAjourEmailByEmployeId(){	
		l.info("you are in testmettreAjourEmailByEmployeId()");	
		Employe employe =new Employe("mohamed", "mansour", "mohamedmansour@email.com","123ingenieur", true, Role.INGENIEUR);
		int employeId=employeControl.ajouterEmploye(employe);
		Assert.assertNotNull(employeControl.getEmployePrenomById(employeId));  
		employeControl.mettreAjourEmailByEmployeId("ingenieur@gmail.com",employeId);
		l.debug("l'email de " +  employeControl.getEmployePrenomById(employeId) + "est modifier" );

	}
	@Transactional
	@Test
	public void testgetAllEmployes(){	
		l.info("you are in testgetAllEmployes()");		
		List<Employe> listAllEmployes= employeControl.getAllEmployes();
		Assert.assertNotNull(employeControl.getAllEmployes());
		for(Employe emp : listAllEmployes) { 
			l.debug("le departement id  :" + emp.getId() +"et le nom: " + emp.getNom());}
	}

	@Transactional
	@Test
	public void testgetAllDepartements(){	
		l.info("you are in testgetAllDepartements()");		
		List<Departement> listAlldepartements= entrepriseControl.getAllDepartements();
		Assert.assertNotNull(entrepriseControl.getAllDepartements());
		for(Departement departement : listAlldepartements) { 
			l.debug("le departement id  :" + departement.getId() +"et le nom: " + departement.getName());}
	}
	@Transactional
	@Test
	public void testgetAllContrats(){
		l.info("you are in testgetAllContrats()");		
		List<Contrat> listAllContrats =entrepriseControl.getAllContrats();
		Assert.assertNotNull(entrepriseControl.getAllContrats());
		for(Contrat contrat : listAllContrats) {
			l.debug(contrat.getTypeContrat() + "" +contrat.getReference()+ ""+contrat.getDateDebut()+""+contrat.getSalaire());
		}
	}

	@Transactional
	@Test
	public void testgetEntrepriseById() {
		l.info("you are in testgetEntrepriseById()");		
		Entreprise entreprise= new Entreprise("telecom","telelcom");
		int identreprise=entrepriseControl.ajouterEntreprise((entreprise));
		Assert.assertNotNull( entrepriseRepo.findById(identreprise).get());

		Assert.assertNotNull(entrepriseControl.getEntrepriseById(identreprise));

		l.debug("l'entreprise :" + entrepriseRepo.findById(identreprise).get()  );

	}

	@Transactional
	@Test
	public void testajouterMission() {
		l.info("you are in testajouterMission()");	
		Mission mission= new Mission("development web","spring application");			
		controllerTimesheet.ajouterMission(mission);
		l.warn("aucun mission ajouter!!! ");


	}
	@Transactional
	@Test
	public void testaffecterMissionADepartement()
	{
		l.info("you are in testaffecterMissionADepartement()");
		Mission mission= new Mission("development web","spring application");
		Departement depTelecom = new Departement("Telecom");
		int depTelecomId = entrepriseControl.ajouterDepartement(depTelecom);
		int missionId =controllerTimesheet.ajouterMission(mission);
		Assert.assertNotNull(deprepo.findById(depTelecomId));
		controllerTimesheet.affecterMissionADepartement(missionId, depTelecomId);
	}

}
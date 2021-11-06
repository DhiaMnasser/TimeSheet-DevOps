pipeline {

    environment { 
        registry = "timesheet" 
        registryCredential = 'ahmedhaddad' 
        dockerImage = '' 
    }
    
	agent any

	stages{

			stage('Clean Install'){
				steps{
					bat "mvn clean install -U"
				}				
			}

			stage('Test'){
				steps{
					bat "mvn test"
				}				
			}

			stage('Sonar Analyse'){
				steps{
                    bat "mvn sonar:sonar"
                  }
            }
            
            stage('Nexus Deploy'){
				steps{
                    bat "mvn deploy"
                  }
            }
   
            stage('Docker') { 
                steps { 
                    script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                    dockerImage.push() 
                    }
                } 
            }
            
	} 

}
pipeline {

    environment { 
        registry = "dhiam/timesheet" 
        registryCredential = 'dhiam' 
        dockerImage = '' 
    }
    
	agent any

	stages{
		    
			stage('Cloning our Git') { 
                steps { 
                    bat "git clone -b Dhia-Mnasser --single-branch https://github.com/DhiaMnasser/TimeSheet-DevOps.git ."
                  }
            } 

			stage('Clean Install'){
				steps{
					bat "mvn clean install"
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
            
            stage('Building our image') { 
                steps { 
                    script { 
                    dockerImage = docker.build("$registry:$BUILD_NUMBER")
                    }
                } 
            }

           stage('Deploy our image') { 
                steps { 
                    script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
             }
           } 
          
        //    stage('Cleaning up') { 
        //         steps { 
        //             sh "docker rmi $registry:$BUILD_NUMBER" 
        //         }
        //    } 
	}
	
	  post{
            always{
            cleanWs()
        }
    }
	 

}
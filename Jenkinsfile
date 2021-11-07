pipeline {

    environment { 
        registry = "hajerzitouni/timesheet" 
        registryCredential = 'DockerHub' 
        dockerImage = '' 
    }
    
	agent any

	stages{
		    
			stage('Cloning our Git') { 
                steps { 
                    bat "git clone -b Hajer-Zitouni --single-branch https://github.com/DhiaMnasser/TimeSheet-DevOps"
                  }
            } 

			stage('Clean Install'){
				steps{
					bat "mvn clean install -f TimeSheet-DevOps"
				}				
			}

			stage('Test'){
				steps{
					bat "mvn test -f TimeSheet-DevOps"
				}				
			}

			stage('Sonar Analyse'){
				steps{
                    bat "mvn sonar:sonar -f TimeSheet-DevOps"
                  }
            }
            
            stage('Nexus Deploy'){
				steps{
                    bat "mvn deploy -f TimeSheet-DevOps"
                  }
            }
            

        
            stage('Building our image') { 
                steps { 
                    script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
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
          
           stage('Cleaning up') { 
                steps { 
                    sh "docker rmi $registry:$BUILD_NUMBER" 
                }
           } 
	}
	
	  post{
            always{
            cleanWs()
        }
    }
	 

}
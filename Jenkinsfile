pipeline {

    environment { 
        registry = "haddadahmed/timesheet" 
        registryCredential = 'dockerHub' 
        dockerImage = '' 
    }
    
	agent any

	stages{

			stage('Clean Install'){
				steps{
					bat "mvn clean install -U"
				}				
			}
			
			stage('Package'){
				steps{
					bat "mvn package spring-boot:repackage"
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
                    dir("C:/Program Files (x86)/Jenkins/workspace/TimeSheet") { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                    }
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
                    bat "docker rmi $registry:$BUILD_NUMBER" 
                }
           } 
           
           stage('Pulling from docker hub') { 
                steps { 
                    script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.pull() 
                    }
                } 
             }
           } 
		        
		 }            
	  post{
            always{
            cleanWs()
        }
    }
	 

}
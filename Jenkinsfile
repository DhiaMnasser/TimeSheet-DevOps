pipeline {

    environment { 
        registry = "hajerzitouni/timesheet" 
        registryCredential = 'dockerhub' 
        dockerImage = '' 
    }
    
	agent any

	stages{
		    
			// stage('Cloning our Git') { 
            //     steps { 
			// 		bat "del -f ."
            //         bat "git clone -b Dhia-Mnasser --single-branch https://github.com/DhiaMnasser/TimeSheet-DevOps.git ."
            //       }
            // } 

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
		             
           stage('run image') { 
                steps { 
                    bat "docker run $registry:$BUILD_NUMBER" 
                }
           } 

	}
	
	  post{
            always{
            cleanWs()
        }
    }
	 

}
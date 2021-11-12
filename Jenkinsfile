pipeline {

    environment { 
        registry = "haddadahmed/timesheet" 
        registryCredential = 'dockerHub' 
        dockerImage = '' 
    }
    
	agent any

	stages{
		    
			// stage('Cloning our Git') { 
            //     steps { 
            //         bat "git clone -b Ahmed-Haddad --single-branch https://github.com/DhiaMnasser/TimeSheet-DevOps.git ."
            //       }
            // } 

            stage('Pull And Run MySQL') { 
                steps { 
                    bat "docker container run --name mysqldb --network timesheet-network  -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=timesheet -d mysql:5.6"

                }
           }   
			stage('Package'){
				steps{
					bat "mvn package -DskipTests"
				}				
			}

			// stage('Test'){
			// 	steps{
			// 		bat "mvn test"
			// 	}				
			// }

			stage('Sonar Analyse'){
				steps{
                    bat "mvn sonar:sonar -DskipTests"
                  }
            }
            
            stage('Nexus Deploy'){
				steps{
                    bat "mvn deploy -DskipTests"
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
               //   bat "docker rmi mysqldb" 
                }
           } 

		    stage('Pulling from DockerHub') { 
                steps { 
                    script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.pull() 
                    }
                } 
             }
           } 

        //     stage('run images') { 
        //         steps { 
        //             // bat "docker run $registry:$BUILD_NUMBER" 
        //         }
        //    } 
        //     stage('create docker network') { 
        //         steps { 

        //             bat "docker network create timesheet-network"
 
        //         }
        //    }  
        
           stage('Run Images') { 
                steps { 
                    bat "docker container run --network timesheet-network --name timesheet-container -p 8085:8085 -d $registry:$BUILD_NUMBER"
                }
           } 
	}
	
	  post{
            always{
                emailext body: 'Build done', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Jenkins'
                cleanWs()
        }
    }
	 

}
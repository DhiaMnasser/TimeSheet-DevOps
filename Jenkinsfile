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
               //   bat "docker rmi mysqldb" 
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

        //     stage('run images') { 
        //         steps { 
        //             // bat "docker run $registry:$BUILD_NUMBER" 
        //         }
        //    } 
        //   stage('create docker network') { 
        //        steps { 

        //            bat "docker network create timesheet-network"
 
          //      }
          // }  
            stage('pull and run mysql') { 
                steps { 
                    bat "docker container run --name mysqldb --network timesheet-network  -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=timesheet -d mysql:5.6"

                }
           }    
           stage('run images') { 
                steps { 
                    bat "docker container run --network timesheet-network --name timesheet-container -p 8085:8085 -d $registry:$BUILD_NUMBER"
                }
           } 
	}
	
	  post{
            always{
            emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
            cleanWs()
        }
    }
	 

}
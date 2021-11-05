pipeline {
	agent any

	stages{

            stage('Clone'){
				steps{
				    bat "git clone"
				}				
			}
			stage('Clean'){
				steps{
					bat "mvn clean"
				}				
			}
		    
		    stage('Install'){
				steps{
					bat "mvn install"
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
		} 

}
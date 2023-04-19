def call(String repoUrl){
pipeline {
       agent any 
       stages {
           stage("system check") {
               steps {
                   sh 'lscpu'
                   sh 'lsblk'
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
           stage("user check") {
               steps {
                   sh 'id jenkins'
               }
           }
       }
   } 
}

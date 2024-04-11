def call(String branch, String repoUrl, String credentials=""){
    configs = [
        url: repoUrl
    ]
    if(credentials) {
        config['credentialsId'] = credentials
    }
    stage ("Checkout"){
        checkout scmGit(branches: [[name: branch]], extensions: [], userRemoteConfigs: [configs])
    }
}
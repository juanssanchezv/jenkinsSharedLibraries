def call(branch, repoUrl, credentials=""){
    // def checkout(branch, repoUrl, credentials=""){
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
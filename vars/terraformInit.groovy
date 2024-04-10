def call (Map config){
    stage ("Terraform init") {
        if (config.filePathInit){ 
            sh "terraform init -backend-config=${config.filePathInit}"
        }
        else {
            sh "terraform init"
        }
    }
}
def call (Map config){
    stage ("Terraform apply") {
        if (config.filePathApply){ 
            sh "terraform apply -backend-config=${config.filePathApply}"
        }
        else {
            sh "terraform apply"
        }
    }
}
def call (Map config){
    stage ("Terraform plan") {
        if (config.filePathApply){ 
            sh "terraform plan -var-file=${config.filePathApply} -out=tfPlan"
        }
        else {
            sh "terraform plan -out=tfPlan"
        }
    }
}
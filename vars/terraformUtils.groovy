def terraformInit (Map config){
    stage ("Terraform init") {
        if (config.filePathInit){ 
            sh "terraform init -backend-config=${config.filePathInit}"
        }
        else {
            sh "terraform init"
        }
    }
}

def terraformPlan (Map config){
    stage ("Terraform plan") {
        if (config.filePathApply){ 
            sh "terraform plan -var-file=${config.filePathApply} -out=tfPlan"
        }
        else {
            sh "terraform plan -out=tfPlan"
        }
    }
}

def terraformApply (){
    stage ("Terraform apply") {
        sh "terraform apply tfPlan"
    }
}
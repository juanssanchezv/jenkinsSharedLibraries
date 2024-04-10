def call (){
    stage ("Terraform apply") {
        sh "terraform apply tfPlan"
    }
}
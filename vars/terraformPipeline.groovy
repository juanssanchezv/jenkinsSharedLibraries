def call(Map config){

    node ("jdk17")
    {
        err =  null
        try {
            checkoutFromRepo(config.branch, config.repoUrl)
            withCredentials([[
                $class: 'AmazonWebServicesCredentialsBinding',
                credentialsId: "AWS-Credentials-Hardcoded",
                accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'
            ]]) {
                // AWS Code
                terraformInit(config)

                terraformPlan(config)
                
                terraformApply()
            
            }

        }
        catch(exception){
            err =  exception
            currentBuild.result = 'FAILURE'
        }
        finally{
            cleanWs()
            if(err){
                throw err
            }
        }
    }
}


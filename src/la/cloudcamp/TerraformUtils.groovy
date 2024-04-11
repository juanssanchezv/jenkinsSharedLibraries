package la.cloudcamp

class TerraformUtils implements Serializable {
    def steps
    TerraformUtils(steps) {
        this.steps = steps
    }
    def tfInit(Map config) {
        if (config.filePathInit){ 
            steps.sh "terraform init -backend-config=${config.filePathInit}"
        }
        else {
            steps.sh "terraform init"
        }
    }
}
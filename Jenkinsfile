REGION = 'us-east-2'
K8S_API = 'https://api-seeku-k8s-local-9oflqk-c6b797be949ae642.elb.us-east-2.amazonaws.com'
K8S_CLUSTER_NAME='seeku.k8s.local'
K8S_NAMESPACE='default'
K8S_JENKINS_CREDENTIAL_ID='kubectl-deploy-credentials'
ECR_PATH = '136358990289.dkr.ecr.us-east-2.amazonaws.com'
ECR_IMAGE = 'demo'
AWS_CREDENTIAL_ID = 'aws-credentials'

node {
    stage('Clone Repository'){
        checkout scm
    }
    stage('Docker Build'){
        // Docker Build
        docker.withRegistry("https://${ECR_PATH}", "ecr:${REGION}:${AWS_CREDENTIAL_ID}"){
            image = docker.build("${ECR_PATH}/${ECR_IMAGE}", "--network=host --no-cache .")
        }
    }
    stage('Push to ECR'){
        docker.withRegistry("https://${ECR_PATH}", "ecr:${REGION}:${AWS_CREDENTIAL_ID}"){
            image.push("v${env.BUILD_NUMBER}")
        }
    }
    stage('CleanUp Images'){
        sh"""
        docker rmi ${ECR_PATH}/${ECR_IMAGE}:v$BUILD_NUMBER
        docker rmi ${ECR_PATH}/${ECR_IMAGE}:latest
        """
    }
    stage('Deploy to K8S'){
        withKubeConfig([credentialsId: "kubectl-deploy-credentials",
                        serverUrl: "${K8S_API}",
                        clusterName: "${K8S_CLUSTER_NAME}"]){
            sh "sed 's/IMAGE_VERSION/${env.BUILD_ID}/g' service.yaml > output.yaml"
            sh "aws K8S --region ${REGION} update-kubeconfig --name ${K8S_CLUSTER_NAME}"
            sh "kubectl apply -f output.yaml"
            sh "rm output.yaml"
        }
    }

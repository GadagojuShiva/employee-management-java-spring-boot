<!-- # Setting up Jenkins and SonarQube on AWS EC2 Instance

## Launch an EC2 instance

1. Log in to your AWS Management Console.
2. Navigate to EC2 and launch a new instance.
3. Choose an Amazon Machine Image (AMI), configure instance details, and add storage.
4. Configure security groups to allow incoming traffic on port 8080.

## Install Jenkins on the EC2 instance

```bash
# SSH into the EC2 instance
ssh -i your-key-pair.pem ec2-user@your-ec2-public-ip

# Install Jenkins
sudo yum update -y
sudo yum install -y java-1.8.0-openjdk
sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import http://pkg.jenkins.io/redhat-stable/jenkins.io.key
sudo yum install -y jenkins
sudo systemctl start jenkins
sudo systemctl enable jenkins

## Install SonarQube and create a SonarQube user
# Switch to SonarQube user
sudo adduser sonarqube
su sonarqube

# Install SonarQube
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-<version>.zip
unzip sonarqube-<version>.zip
mv sonarqube-<version> sonarqube
cd sonarqube/bin/linux-x86-64
./sonar.sh start

Visit http://your-ec2-public-ip:9000 to access SonarQube.

Generate a token in SonarQube for later use.

## Configure Jenkins credentials

Open Jenkins in your browser: http://your-ec2-public-ip:8080
Unlock Jenkins using the initial password from /var/lib/jenkins/secrets/initialAdminPassword.
Install suggested plugins.
Create credentials for SonarQube, GitHub, and Docker in Jenkins.

## Install Docker on the EC2 instance

# Switch back to the normal user
exit

# Install Docker
sudo yum install -y docker
sudo systemctl start docker
sudo systemctl enable docker

# Add the user to the docker group
sudo usermod -aG docker jenkins

## Setting up Jenkins Job

Create a new Jenkins job.
Configure the source code management (SCM) with your Git repository.
Define the build pipeline steps.

## Setting up ArgoCD on Minikube

minikube start
Install ArgoCD using operators

bash
Copy code
kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
Expose ArgoCD service via NodePort

bash
Copy code
kubectl edit svc argocd-server -n argocd
# Change 'type: ClusterIP' to 'type: NodePort' and save

Access ArgoCD UI

bash
Copy code
minikube service -n argocd argocd-server --url
Get ArgoCD initial password

bash
Copy code
kubectl get secret argocd-initial-admin-secret -n argocd -o jsonpath='{.data.password}' | base64 -d
Log in to ArgoCD UI and create an application.
Pipeline is now set up and deployed using ArgoCD!

Remember to replace placeholders such as `<version>`, `your-ec2-public-ip`, and other specific details with your actual values.
 -->

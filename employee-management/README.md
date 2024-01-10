# Employee Management System

The Employee Management System is a lightweight, in-memory web application designed to simplify the handling of employee information. Developed using Spring Boot and Thymeleaf, this application enables users to effortlessly add, view, and delete employee records. The intuitive interface provides a smooth experience for managing your workforce without the need for external databases.

## Key Features:

### Add Employee
Seamlessly input new employee details through a user-friendly form.

### Employee List
Access a comprehensive list of all employees, each with a unique identifier.

### Delete Employee
Remove employees from the system with a simple click.

## Technology Stack:

- **Backend:** Crafted using Spring Boot, providing a robust and scalable foundation.
- **Frontend:** Utilizes Thymeleaf for server-side rendering, ensuring dynamic and responsive user interfaces.
- **Storage:** In-memory storage eliminates the need for an external database, making it a lightweight solution.

## About the Developer:

This Employee Management System was skillfully developed, and its efficiency was enhanced through the use of ChatGPT, a powerful language model developed by OpenAI. This collaboration enabled rapid development, contributing to the creation of a seamless and resource-efficient in-memory application.

## Demo Deployment on Kubernetes with ArgoCD:

This application is prepared for a demo deployment on Kubernetes using ArgoCD. The Kubernetes manifests and deployment configurations are included to facilitate easy deployment and management through ArgoCD.

## Prerequisites
- [Docker](https://docs.docker.com/get-docker/) installed on your EC2 instance.

## Steps to Run the Application

1. **SSH into your EC2 instance:**
    ```bash
    ssh -i your-key.pem ubuntu@your-ec2-instance-ip
    ```

2. **Update and Install Dependencies:**
    ```bash
    sudo apt update
    sudo apt install -y apt-transport-https ca-certificates curl software-properties-common
    ```

3. **Add Docker GPG Key and Repository:**
    ```bash
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
    echo "deb [signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
    sudo apt update
    ```

4. **Install Docker:**
    ```bash
    sudo apt install -y docker-ce docker-ce-cli containerd.io
    ```

5. **Add User to Docker Group:**
    ```bash
    sudo usermod -aG docker $USER
    ```
    Note: You may need to log out and log back in for the group changes to take effect.

6. **Pull Docker Image:**
    ```bash
    docker pull gadagojushiva/employee-management:14
    ```

7. **Run Docker Container:**
    ```bash
    docker run -d -p 8080:8080 gadagojushiva/employee-management:14
    ```

8. **Access the Application:**
    - Go to your EC2 instance and copy the IP address.
    - Open a web browser and navigate to `http://your-ec2-instance-ip:8080/employees`

Now, you should be able to access the Employee Management Application on your EC2 instance.

## Alternative Local Deployment:

- Alternatively, you can clone the repository:
```bash
git clone https://github.com/your-username/employee-management.git
cd employee-management
```

- Run the application using Maven:
```bash
mvn spring-boot:run
Access the application on your local machine at http://localhost:8080/employees.
```

# Installing Prometheus and Grafana on Minikube

This guide will walk you through the process of installing Prometheus and Grafana on Minikube, a local Kubernetes cluster, to monitor your applications.

## Prerequisites

- [Minikube](https://minikube.sigs.k8s.io/docs/start/) installed and running
- [Helm](https://helm.sh/docs/intro/install/) installed

## Steps

### 1. Add Prometheus Helm Repository

```bash
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update
```
### 2. Install Prometheus

```bash
helm install prometheus prometheus-community/prometheus
```
### 3. Expose Prometheus Service

```bash
kubectl expose service prometheus-server --type=NodePort --target-port=9090 --name=prometheus-server-ext
```
## Installation of Grafana

### 1. Add Grafana Helm Repository

```bash
helm repo add grafana https://grafana.github.io/helm-charts
helm repo update
```
### 2. Install Grafana

```bash
helm install grafana grafana/grafana
```
### 5. Expose Grafana Service

```bash
kubectl expose service grafana --type=NodePort --target-port=3000 --name=grafana-ext
```
## Accessing Prometheus and Grafana

- To access Prometheus, get the NodePort of the exposed service:

```bash
minikube service prometheus-server-ext --url
```
- Open the provided URL in your browser.

## To access Grafana, get the NodePort of the exposed service 

```bash
minikube service grafana-ext --url
```
## we have to retrieve passwd inorder to login into Grafana UI

- To retrieve the password for Grafana, you'll need to access the Kubernetes secret where it's stored. Here's how you can do it:

```bash
kubectl get secret grafana -o jsonpath="{.data.admin-password}" | base64 --decode
```
- This command retrieves the password stored in the grafana secret, decodes it from base64, and prints it to the terminal.

## Cleaning Up
- To clean up the resources created:

```bash
helm uninstall prometheus
helm uninstall grafana
kubectl delete service prometheus-server-ext
kubectl delete service grafana-ext
```

## Conclusion
- You have now successfully installed Prometheus and Grafana on Minikube. You can use Grafana to visualize metrics collected by Prometheus and monitor your applications.

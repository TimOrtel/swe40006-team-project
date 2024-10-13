# Postly
This repository implements our team project for Software Evolution and Deployment.

## Project Structure
The application consists of the following main services:
1. Backend: The backend application is written in Spring and handles requests. Currently, it accepts new message requests and returns a list of the last 10 messages created.
2. Frontend: A frontend web application written in Angular. It is served by Nginx.
3. Prometheus: Collects data from the backend application to view metrics.

These services are combined using Docker Compose which is deployed to Azure over a GitHub Actions pipeline.
The necessary credentials to the Azure deployment are provided as GitHub actions secrets. 

## How to launch
To launch, simply execute `docker compose up` in the root directory of the repository.
# Enterprise Development

This repository is a project for my enterprise development course. The goal of this porject is to create a java api consisting of a minimum of 3 microservices, this api has an api-gateway to be able to use authentication and loadbalance, next the api is deployed on okteto using Docker containers, finally unit test will be implemented to test the api before deployement to prevent deployment hell. Extra credit can be gained by doing extra tasks such as creating a frontend, changing the docker-compose to a kubernetes manifest and more. The frontend I create for my extra credit can be found here https://enterprise-dev-frontend.vercel.app/ . A layout of the entire project can be seen at the bottom of this README.

## 1. Microservices

This project started by creating a java api consisting of a minimum of 3 microservices. Each api conects to a containerized database of which at least 1 should sql and 1 should be nosql, I chose to use 2 mysql and 1 mongodb databases. The second part is a java api, the api conists of a model(s) which details the data that should be stored and the relation between tables, a repository which isolates the data and the rest of the api, dto's which carry data between processes to reduce the number of method calls, a service which acts as a worker for the controller creating seperation of concurn, and lastly a controller which acts as the master program and handles the api calls using the service.

## 2. CI/CD & Deployment

The second part of the project is deployment. In this step we make use of Docker to containerize each database and each api microservice, after this I used github actions to setup and build each microservice as a container, when containerized the microservice will be pushed to my personal docker account. The final steps of this part was to create a docker-compsoe file to define all containers, the docker-compose file included 3 database and the 3 microservices which can be pulled from docker and 3 volumes for the databases to make the data persistend.

## 3. API gateway

The third part of the project consists of create an api-gateway for the 3 api microservices.
![image](https://github.com/sebastian-vangrieken/enterprise_dev/assets/91123328/57309763-0d1e-41ce-b3a6-ea34ebeee3f7)

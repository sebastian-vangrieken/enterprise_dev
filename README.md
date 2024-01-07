# Enterprise Development

This repository is a project for my enterprise development course. The goal of this porject is to create a java api consisting of a minimum of 3 microservices, this api has an api-gateway to be able to use authentication and loadbalance, next the api is deployed on okteto using Docker containers, finally unit test will be implemented to test the api before deployement to prevent deployment hell. Extra credit can be gained by doing extra tasks such as creating a frontend, changing the docker-compose to a kubernetes manifest and more. The repository for my frontend can be found [here](https://github.com/sebastian-vangrieken/enterprise_dev_frontend). A layout of the entire project can be seen at the bottom of this README.

## 1. Microservices

This project started by creating a java api consisting of a minimum of 3 microservices. Each api conects to a containerized database of which at least 1 should sql and 1 should be nosql, I chose to use 2 mysql and 1 mongodb databases. The second part is a java api, the api conists of a model(s) which details the data that should be stored and the relation between tables, a repository which isolates the data and the rest of the api, dto's which carry data between processes to reduce the number of method calls, a service which acts as a worker for the controller creating seperation of concurn, and lastly a controller which acts as the master program and handles the api calls using the service.

## 2. CI/CD & Deployment

The second part of the project is deployment. In this step we make use of Docker to containerize each database and each api microservice, after this I used github actions to setup and build each microservice as a container, when containerized the microservice will be pushed to my personal docker account. The final steps of this part was to create a docker-compsoe file to define all containers, the docker-compose file included 3 database and the 3 microservices which can be pulled from docker and 3 volumes for the databases to make the data persistend.

## 3. API gateway

The third part of the project consists of create an api-gateway for the 3 api microservices. The api-gateway allows for the 3 api microservices to be searchable from 1 central place, it also allows for loadbalancing not that loadbalencing will be neccassary for my api, it also allows for the use of authentication which allows me to block access to surtain endpoints depending on who is accessing them. When the gateway is written it can then also be containerized by actions, put in the docker-compose file and then hosted on okteto.

## 4. Authentication

The fourth part of the project is authentication. In this part I use the google cloud platform to put authentication on the api-gateway. Certain endpoints can be blocked depending on the bearer token the user has. For example, all GET endpoints can be allowed to be accessed by every user, but endpoints POST, PUT & DELETE endpoints should be authenticated so that not everyone can change data.

## 5. Unit testing

In this final part of the project we implement unit tests. These are usefull for preventing bugs from going into production and breaking users applications. The unit tests are pieces of code which act like a user and then check if the outcome of a certain event is the same as what the outcome should really be. When tests fail a developer can change their code to fix the problem and this can also lead to more efficient and saffer code in certain cases.

### Project layout
![image](https://github.com/sebastian-vangrieken/enterprise_dev/assets/91123328/57309763-0d1e-41ce-b3a6-ea34ebeee3f7)

## Hosting
* [api-gateway](https://api-gateway-sebastian-vangrieken.cloud.okteto.net/)
* [tournament-service](https://tournament-service-sebastian-vangrieken.cloud.okteto.net/)
* [club-service](https://club-service-sebastian-vangrieken.cloud.okteto.net/)
* [player-service](https://player-service-sebastian-vangrieken.cloud.okteto.net/)
* [frontend hosted on vercel](https://enterprise-dev-frontend.vercel.app/)

## Endpoints
![image](https://github.com/sebastian-vangrieken/enterprise_dev/assets/91123328/712a21af-3ea9-4cb0-83b8-d2da74a34b16)

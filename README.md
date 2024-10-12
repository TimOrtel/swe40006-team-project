/backend contains the springboot backend for the project
/frontend contains the angular frontend for the project
/.github/workflows contains the workflows used for deploying the project from Github to the Azure server

To run the project run the command 
    docker-compose up -d

For setting up the workflow to deploy to Azure, you must have the Azure webapp turned on as well as having the secrets from Azure setup in the github project's settings
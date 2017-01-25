Actions microservice 
============================================

### Introduction

This microservice allows the management of the 'Action' resource. 

### Releases

0.0.1 - Initial version



### Endpoints

#### [GET] /actions

	This endpoint retrieves all the available actions.
	

### Executing

Once you have executed maven build task, you will find a SpringBoot executable jar on target directory. To execute it you only have to run the following command:
		
	java -jar target/actions-{VERSION}.jar

Optionally, you can specified the following parameters, although they are not required in the current version:

	--spring.profiles.active=local --spring.cloud.config.enabled=false
	

#### Note

Currently this service is not using a sping cloud config server to retrieve its configuration.

Please, notice that in the bootstrap.yml file we have disabled the spring cloud config feature.


### Configure IDE

You must attach lombok.jar as External Jar to Java Build Path for project compilation on IDE. 
You can download lombok.jar from this location: https://projectlombok.org/ 


### Swagger

The swagger documentation will be available at:

	/swagger-ui.html
	

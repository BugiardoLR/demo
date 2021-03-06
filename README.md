# demo
A demo data processing pipeline application

It exposes 2 REST endpoints.

 1.  http://localhost:8080/v1/receive  for POST-ing data.
 2.  http://localhost:8080/v1/data       for GET-ing data.

*  Receiver endpoint, located at http://localhost:8080/v1/receive
   *  Accepts any valid JSON array of type:
	 >  eg.  [{"data" : "AnyData"}, {"data" : "AnyData"}]
	 
	 *  On giving invalid input, the user will be greeted by an error page with the corresponding http error code.
	 
	 *  The logic for publishing the data to Kafka consists of splitting the data into smaller JSON arrays and then publishing them to a
	   specific topic. The splitting step can be adjusted in the properties file. If the data is smaller than the splitting step the JSON        array will be published as is, without any modifications.


* A Kafka Consumer is running in the background, consuming any fresh data from kafka and saving it in batches to the database. 
		 
* Response endpoint, located at http://localhost:8080/v1/data	
  * Returns all the data saved in the database 
	


# FOR LOCAL USE

When running the application from an IDE some changes to the application.properties has to be made in order for the application to         successfully connect to a local database and kafka.

> spring.datasource.url=jdbc:mysql://localhost:3306/demo

> kafka.bootstrapAddress = http://localhost:29092

In the folder _local_, there is an docker-compose.yml file, that contains kafka and a database.


# FOR DOCKER-COMPOSE USE

When using the general docker-compose, which is located in the root of the project the following values in the application.properties file has to be changed, before building an image of the demo, either by running the makefile or by doing a manual build of the img.

> spring.datasource.url=jdbc:mysql://db:3306/demo

> kafka.bootstrapAddress = http://kafka:9092

# demo
An demo application 

It consists of 2 REST endpoints.

 1.  http://localhost:8080/v1/receive  for POST-ing data.
 2.  http://localhost:8080/v1/data 		 for GET-ing data.

*  Receiver endpoint, located at http://localhost:8080/v1/receive
   *  Accepts any valid JSON array of type:
	 >  eg.  [{"data" : "AnyData"}, {"data" : "AnyData"}]
	 
	 *  On giving invalid input, the user will be greeted by an error page with the corresponding http error code.
	 
	 *  The logic for publishing the data to Kafka consists of splitting the data into smaller JSON array and then publishing them to a
	   specific topic. The splitting step can be adjusted in the properties file. If the data is smaller than the splitting step the JSON        array will be published as is, without any modifications.
		 
* The Response endpoint, located at http://localhost:8080/v1/data	
  * Returns all the data saved in the database 
	
When running the application from an IDE some changes to the application properties has to be made in order for the application to         successfully connect to a local database and kafka.
In the folder _local_, there is an docker-compose.yml file, that contains kafka and a database, you can run it and change the following properties in demo/src/main/resources/application.properties 

# FOR LOCAL USE

> spring.datasource.url=jdbc:mysql://localhost:3306/demo

> kafka.bootstrapAddress = http://localhost:29092

# FOR DOCKER-COMPOSE USE

> spring.datasource.url=jdbc:mysql://db:3306/demo

> kafka.bootstrapAddress = http://kafka:9092

# CPSC471LibraryBackend

This is the backend portion of our library system. Our backend was created using spring boot to set up the project and the file structure. 
We used Hibernate and JPA queries in order to access and modify the contents of the database on the local machine. We accomplished this by using hibernate annotations to create a model of the database in our code. We created classes for every entity in our database and mapped the classes and their attributes to the schema of our database. We then created repository classes for each entity in order to set up the queries we would be using to acess and modify the database using the models we created earlier. Finally we used a controller class in order to create an interface for our frontend to connect to, this is also where our queries are called from.

In order to run the backend, you must modify the "application.properties" file located in "CPSC471LibraryBackend/src/main/resources/". You must change the datasource url field to match the location of the databasee on the system. In our case the database is imported into MYSQL Workbench on port 3306. You must change the username and password field to match your database username and password on your machine. 

Since this is a maven project you can run the backend by using the appropriate command in the terminal while in the highest directory of the project "/CPSC471LibraryBackend". For example on VSCODE on windows you may use the command "./mvnw spring-boot:run" to run the backend. Also using the command mvn clean package spring-boot:run on IntelliJ.


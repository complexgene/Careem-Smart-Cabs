# Careem-Smart-Cabs

This project contains an UI layout designed in android platform and the controller(back end cab service engine) separately to handle the request fired to the system. 
Both of them are completely based on MVC on their ends and are related via REST endpoints.
There are three main MicroServices UI_MicroService, TaxiSessionManager_MicroService and MappingService_microservice.
UI_MicroService: responsible for interface, queries data from the mapping service for get geolocations of the objects to be placed on map.
TaxiSessionManager_MicroService: Managing sessions for each cab, if they booked, maintaing the data which cabs have been booked and all. Once a bookign is finished the corresponding session is destroyed.
MappingService_microservice: Maintains all the geolocations and supplies data in real time for different other micro services. 
Back end cab service engine has been separately divided into three major microservices, each one of them horizontally scalable.
For REST(Jersey) and JSON(Jackson) has been used, as its perfect for performance nd scalability.
Two DBs noSQL MongoDB and Realtime DB Firebase has been used for live geolocation feed and maintaining the live booked sessions.
For static sort of data MongoDb has been used.
Communication is via JSON over HTTP.
For back-end DBs, as per architecture sessions management is done using nosql mongoDB with JSON,
and for real time feed Firebase from google with JSON is being used.

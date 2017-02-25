# Careem-Smart-Cabs

This project contains an UI layout designed in android platform and the controller(back end cab service engine) separately to handle the request fired to the system. 
Back end cab service engine has been separately divided into three major microservices, each one of them horizontally scalable.
For HTTP(Jetty), REST(Jersey) and JSON(Jackson) combined framework into one "Dropwizard" has been used, as its perfect for performance nd scalability.
For back-end DBs, as per architecture sessions management is done using nosql mongoDB with JSON,
and for real time feed Firebase from google with JSON is being used.

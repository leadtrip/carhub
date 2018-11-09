# carhub
Simple Grails 3 app put together to test spring security rest capability.

Functionality can be tested by importing the file 'Car REST.postman_collection.json' into postman

There are 3 endpoints:
 * http://localhost:9090/api/cars/v1
 * http://localhost:9090/api/cars/v2
 * http://localhost:9090/api/cars/v3
 
The endpoints offer greater amounts of information as the version increases.
Both v1 and v2 don't require authentication, v3 does.

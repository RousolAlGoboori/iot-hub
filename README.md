# iot-hub
# About
IoT Hub as a Service (HaaS), a framework that enables data-oriented interoperability and provides an environment for IoT application development. Made as part of the research paper at Northeastern Illinois University.
# The Project Directory

Created five packages and created some classes and interfaces inside these packages, as seen in the below  image:

* annotation: get current ElementType of specific annotation
* controller: The most important part is the controller layer. It binds everything together right 
             from the moment a request is intercepted till the response is prepared and sent back, 
             A RESTful Controller where we expose the application’s data to a client.
             We will make use of several HTTP verbs like GET, POST, PUT and DELETE to support features associated with them.
* model: The various models of the application are organized under the model package,
            Defines a collection of state variables, as well as the functionality for working with these variables.
* repository: An interface available in Spring Boot named as CrudRepository that contains
            methods for CRUD operations. It provides generic Crud operation on a repository.
            CRUD stands for Create, Read/Retrieve,Update and Deleteand these are the four basic operations that we perform on persistence storage.
* service: A package that implements the ProductService interface with @Service annotation writes
            the business logic to store, retrieve, delete, and update the product.


  ![image](https://user-images.githubusercontent.com/70383093/160323729-c73934f2-b3d0-48b9-ad26-aa13b56713cc.png)
         |
# Screenshots
  
* The app - home screen

  ![image](https://user-images.githubusercontent.com/70383093/160317187-0d1ea031-81c7-413c-ac36-7fd3cdf20be5.png)

## Synchronous Applications

keywords : TH, DT, VS

### Scope

/TH:*/                      --> all things

/TH:132f1fa/          --> sepcific thing

/TH:1234ff,87965/           --> list of things

/DT:*/                      --> all data item

/DT:89ghuuuiihf/           -->  perticular data item by Id

/VS:vsp12345/TH:*/         -->  all things in specified VS

/VS:vsp12345/TH:gt6788900/ --> perticular thing in specified VS

/VS:vsp12345/DT:*/         --> all dataItems in specified VS

/VS:vsp12345/DT:gt678hh00/ --> perticular thing in specified VS

### Return Values/Attributes

* *-->  display all attributes to the user 
                               
* name,thingId,creator  -->  display given list of attributes to the user

### Conditions

attributeName::operator::value

name::eq::thing4,date::gt::2017

The possible operators [gt,gte,lt,lte,eq,neq,in,ne,nin]

  ![image](https://user-images.githubusercontent.com/70383093/160317422-af47fc8f-da8b-4766-8c09-ea1360fbf6d9.png)

## Asynchronous Applications

* Create a List of alarms to store scope and condition

   ![image](https://user-images.githubusercontent.com/70383093/160317592-9bb5d64d-7b6c-42cc-8866-2bbf2c5cab03.png)
  
* Check for a new thing/data item is in the alarm list.

   ![image](https://user-images.githubusercontent.com/70383093/160317732-17c8e1a3-103b-4317-9823-2f4b7cd5cd94.png)

        
         
# How to install and run the IoT Hub

## Package/tools/frameworks needed

 * JDK 11 and JAVA_HOME environment variable set.
 * You can also import the code straight into your IDE (IntelliJ IDEA)

## Run the Application

* Download the zip or clone the Git repository.

* Unzip the zip file (if you downloaded one).

* Open IntelliJ IDEA.

* Open -> Navigate to the folder where you unzipped the zip.

* Choose the Spring Boot Application file (search for @SpringBootApplication).

* Right Click on the file and Run the project through the IntelliJ IDEA and head out to http://localhost:8080


# Contact US

ahmedeeldin@gmail.com Ahmed Khaled, CS department at Northeastern Illinois University.

rousolalgoboori@gmail.com Rousol Al Goboori, Northeastern Illinois University.

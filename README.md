# IS3106 Ecommerce Jsf Web application
Assignment for IS3106 module (Graded Homework)

The ecommerce web application is built using **Java Enterprise Edition (J2EE)** backend system and **JavaServer Faces** server-side frontend technology with **PrimeFaces** composite component, and follows the MVVM (Model-View-ViewModel) frontend architecture.

## Instructions to run the application:
1) Open project (folder name: PointOfSaleSystemV54) on Netbeans IDE
2) Edit private properties file (change to your own user name on laptop)
3) Set up mySQL database (database name: pointofsalesystemv54) and connect to it
4) Clean and build project, before deploying it onto glassfish server
5) Url: localhost:8080/EcommerceV54JsfAdvPf/

## Use cases implemented:
1) Register customer
2) Login and logout
3) View all products
4) Add product to shopping cart
5) Update quantity in shopping cart
6) View all sales transaction (after shopping cart is checked out)


Note: As this module focuses on frontend development, most of the backend system (ie entity, EJB session beans) was provided and used AS-IS. To build the ecommerce application, I modified the customer and sales transaction session bean classes for the use cases accordingly.

# DistributedSystemsErgasia



Required software:


-Download and install MySQL 

-Download and install DBeaver community Edition https://dbeaver.io/download/

-Download and install PostMan https://www.postman.com/downloads/

-Download and install Intellij IDEA https://www.jetbrains.com/idea/



Setting up the application:


-Open the project in Intellij (and setup JDK version 17 if needed)

-Update Maven Dependencies 

-Change username(default: root) and password(default: pass123) in application properties to match MySQL server configuration. Optional: change database name(default:Ergasia)

-Connect MySQL Database in Intellij IDEA:
Database -> add Database -> MySQL -> 
username: same username as username in application properties, password: same password as password in application properties -> 
test connection -> make sure connection succeeds -> apply -> save

-Run the application through Intellij to create database and tables, then stop the application

-Connect MySQL database in dbeaver:
New Connection -> MySQL -> next -> Database: database name: Ergasia(can be configured in application properties in intellij) username: same username used before, password: same password used before

-Run Script-1.sql in dBeaver to create users and authorities


Running the application:

-Run the application through Intellij


Application is now online and ready to recieve requests

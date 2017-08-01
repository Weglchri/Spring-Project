
## Spring Framework Prototyp
Dieser Prototyp wurde im Zuge einer Seminararbeit programmiert und stellt eine Webapplikation dar. Es wurden dabei ausschließlich Komponenten aus dem Spring Ecosystem des Spring Frameworks verwendet. Der Core des Springframeworks entspricht der Version 4.  
## Funktion
Diese Webapplikation ermöglicht es dem Benutzer Userdaten (Vornamen und Nachnamen) auf einer Web GUI zu speichern. Diese Daten erscheinen in einer Übersicht in der es dem User ermöglicht wird diese zu verändern,  genauer zu betrachten, oder zu löschen.

## Aufbau 
Der Prototyp wurde anhand einer 3-Schichten-Architektur entwickelt und besitzt somit eine Präsentationsschicht, Geschäftslogikschicht und Datenzugriffschicht, zur Strukturieren des Programms. Dabei wurden für jede Schicht Komponenten des Spring Frameworks gewählt und welche auf dem Spring Cores mit Dependency Injection aufsetzen.
Um Daten an in der Präsentationsschicht, welche die Schnittstelle zum Benutzer darstellt, zu verarbeiten, wurde Spring-MVC verwendet, um anhand des Model-View-Controller-Entwurfmusters eingegebene Daten an die angeknüpfte Geschäftslogikschicht zu delegieren. 
Daten werden über die Datenzugriffsschicht mit Anbindung an eine MSQL-Datenbank mit Hilfe der Erweiterung Spring-JDBC persistiert. Dabei wurde zur Vereinfachung auf die Verwendung eines ORM verzichtet. 

## Verwendete Technologien
+ Spring Core 4.3.9

+ Spring-MVC 4.3.9

+ Spring-JDBC 3.0.3

+ Spring-Test 4.3.9

+ Servlet-API 3.1.0

+ JSP 2.3

+ JSTL 1.2

+ Maven 3.5.0

+ MySQL 5.1.9

+ JUnit 4.12

+ Tomcat 9.0.0.M21

+ IDE: IntelliJ 2017.1.4


#### Setup Database Configuration

+ Setup database <br>
*Spring-Project/src/main/resources/sql/create.sql* <br>

+ Delete database <br>
*Spring-Project/src/main/resources/sql/destroy.sql*


#### Tomcat Configuration & Deployment (IntelliJ)

Die Konfiguration des Tomcat-Servers sowie das Deployment als .war werden in 
folgenden Aleitungen beschrieben. 

#####Konfiguration: https://www.jetbrains.com/help/idea/defining-application-servers-in-intellij-idea.html
#####Deployment: https://www.jetbrains.com/help/idea/configuring-web-application-deployment.html




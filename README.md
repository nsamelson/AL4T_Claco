# AL4T_Claco

#### A software architecture project

## **Project participants:**

- Mohamed AOUSJI 17236
- Nicolas SAMELSON 17288
- Pedro ROQUERO DA COSTA PINTO 17010
- Pierre PAPILLON 21609

## **Introduction**

As part of the software architecture course, we were asked to develop a mobile application, to help students and teachers connect to their school plateform and access their courses as well as their schedule.  
The software was developped with the MVC pattern in mind, and is actually in an "Open-Box" extensibility state.  
We used the "agile" method and divided our project in different sprints.

## 1. User stories

###  1.1. Sprint 1 

###  1.2. Sprint 2 

###  1.3. Sprint 3 

###  1.4. Backlog

## 2. Classes   

The Model classes of the MVC pattern are the following :

- *User :*  
The user is an abstract class, Teacher and Student inherit of this class. The User has a workspace, a list of Course objects and a schedule, it's personal Calendar object.
- *Teacher :*  
The teacher inherits of the User class and is able to modify information in its courses.
- *Student :* 
The student inherits of the User class. 
- *Course :*  
A course has one or multiple Activity objects.
- *Activity :*  
An activity has none to multiple File objects.
- *File :*  
A file represents a resource of an activity, for example slides or a syllabus.
- *Calendar :*  
The calendar has a list of Event objects.
- *Event :*  
An event corresponds to a seance, with a starting and ending date, and has a Classroom object, in which the course is given.
- *Classroom :*  
The classroom is class having a name as the class location.

## 3. Diagrams and mock-ups  

## 4. Links  

## 5. Releases  

## 6. Continue the project  

### 6.1. Setup your project
1. Please fork this repository
2. Then clone with ```git``` or download
3. In the top level folder project, create a new file named ```local.properties``` and copy this line  
3.1. For Linux : ```sdk.dir=/YOUR_PATH/Android/Sdk```  
3.2. For Windows : ```sdk.dir=C\:\\Users\\USER\\AppData\\Local\\Android\\Sdk```  
4. Download Android Sdk 31
5. If you're on windows, you may encounter an error building the project :
5.1. Go into ```C:\Users\USER\AppData\Local\Android\Sdk\build-tools\31.0.0\``` and rename the file ```d8``` to ```dx```.
5.2. Go into ```C:\Users\USER\AppData\Local\Android\Sdk\build-tools\31.0.0\lib``` and rename the file ```d8``` to ```dx```

### 6.2. How to modify

### 6.3. How to implement APIs

### 6.4. Suggested improvements

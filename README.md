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
- As a user, I want to access my workspace in order to see the courses.
- As a user, I want to access a course in order to see its details.
- As a user, I want to access a an activity of a course in order to have more information.

###  1.2. Sprint 2 
- As a user, I want to be able to log in the application
- As a user, I want to access the resources of an activity in order to download them.
- As a user, I want to navigate between the pages of the application.
- As a user, I want to acces to the rollup menu in order to navigate through the different features.

###  1.3. Sprint 3 
- As a user, I want my session to be saved in order to re-log in automatically.
- As a user, I want to access to the calendar in order to see my schedule.
- As a teacher, I want to be able to modify the details of a course and an activity.

###  1.4. Backlog
- As a user, I want to enter a date in the calendar in order to search free classrooms.
- As a user, I want to enter a classroom in the calendar in order to search its schedule.
- As a user, I want to enter a course in the calendar in order to see its schedule.

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
- [Class Diagram](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Untitled%20Diagram.drawio#R7Vxbd9o4EP41Pid9IMfYGNJHrklbticp2abdNwULUCNbrCwI3l%2B%2Fsi3fZSAJxKL0JbFGI3s8I898n6REM%2FvO5pqC5eIvYkOsGbq90cyBZhjNttXivwKJLyRNS48kc4psIUsFE%2FQfFMJYbYVs6OUUGSGYoWVeOCWuC6csJwOUkue82ozg%2FFOXYA5LgskU4LL0AdlsEUkNXdfTjhuI5gtW7HFArC0E3gLY5DkjMoea2aeEsOjK2fQhDtwXOyYaN6roTSyj0GX7DPB7xhN8uBvPRg%2F481RvfW7c%2FNMQ8fGYH78xtLkDRJNQtiBz4gI8TKU9SlauDYO76ryV6owJWXJhkwt%2FQcZ8EU2wYoSLFszBopcbTP0fYnzY%2BBk0Li0rbg822d6Bn23dQoocyCBNhHY3iDRvusSFkWSEMBb9HgOUxRo2Ag5x7VicUSu7U3jYIys6Fc5Z3X0ffBoP7n%2FpLr3bPH356nR%2FNOJ5Cegcsm16QjHwcOYJIlrXkPC3oj5XoBADhtb5KQjETJ4nemms%2BYUI9wtCH5tTV%2BwvrVz0d4R%2BzyjumgwHjbLUreahgxwO5S8F%2FIzCkiCXeZk73wYCriBSrxlnHT%2FfHlXoN82rrQP4RWRCOt%2BSd9lrCm7z6RrglfCDZrQx925vmZuY7X9XQZbsOdz5yNXMLu%2FVlxv%2BMwypHskbLJiDQV8r08fghjUARnMxbsojz3NHck9%2BNRe%2FwyejouAxFvztheNw1Dl6LCpyWWkwly2LsgUNXi4udbEdzWqTXuUMDGcs443yvQPdr8CBkdKEUeTOt5l9PCuGDkA4HNkNn5G15JHu49Lj2fZA6JO3BDw1xPaNkcc%2FnDZw%2BGTrhU%2Fv89zhwURWo7WT6QLaKyxi2ucwxrUBfX9b6o5dg3fcAs97JtROAlfXFH%2BJMxTKDRzNo5kfe%2FEi9l4%2F8eSH6BY9jsfVdurxfHQNWfTxX%2BRckiSEekwaUQj7mAeOkwvHuxgABhmHzB8q81ek68gzmAo%2Bjl8mzm95d5ffaLgO8F3NCVkN9w3Is4sJsL9BL8K4ed99JxyhKeqaAjtZQ8oQp%2BbdCMwNQrjXE9BuED2zR7jWDIcEYBbC%2Ft6MuEzQkaYh2iPgIBwg3RuI1zC4q5ZjKZU0IbABbrRtwD7ubeUBtRED7Od0HcHsCNkis4SQQPe3MD453NZLPn0PxrdBLEP4eCvhe%2Fw6pXtBIyX6CY17xGT6pBV5XBWNTChmBY18Pf%2Fr7Mvyj8L%2FSoStVeBrbaswayJDxah04ryUSFq6%2FDlVRNI0rG36x%2BGRHQV5ZEIPJ2xlR9VoG3NUGQneEwZwn0Ib8ZkSKn9K3%2BekcO0Z1J1W4YPt6OW6Y%2BiSupMUrIPXnY%2F1LDTuKCGvLwVXSizxNdtHzMy7R%2Bv71ZtDpfgrlVP8PQScmOxaHHx7UrTReq9cJtFTJAEHukNeR2SsuR4qElvUnfJPFTG%2F2qY6mdxZFK7ddaslq1tXB6hb0q0cq566daobZPvukNW2DbrVbDUrS2kl8dS4gxo7TH1iK2DFTwjoK%2FnTEV1TweveO0DBPB9DYENaf6AG0JtStGSIuDJj6g6ZgCoIelr1pmSMZzTlFvWPtG5w0uCnUyBzpmS12LAk6Mco8rCDoZ%2F2H%2FQjRz%2FbQM1O8GPUBX62Wa0m9slksFNFP2rgDjUwmFgk8aoKVrqIUvsxmm8w%2Bt4rbeUp4wXnfRSZkGewhtAxjcvCOqVs21W3JIXUPFYhNVROsmImn2qCVSS1%2BUsFrBitMK7yxx%2B0nU8TebT90ZIkiaYEbSd7LgdPEjXtkZ0o2jb3RNsdpdC2qXIhkBwWPrViEJ76q8RsLzwTWM6Y55Idm8mfrIn02JJsxSSn1A5%2BhEBOVOs5unaq%2BVFyWE2qd%2FCTDG8KstLHuOL0carJUQ2kPCZTkC6rJ%2Be66zFmEnyPwel4UTK4bTho3iOnpsP7Q9feYU%2Fdew8H2Ro5n0paONQgW41IDobnKmnnWJVU6YNUsoTwOydaRcw%2Bg5XBEqiVcn4pqC2erN%2FjU%2BTN9B87REcg03%2BQYQ7%2FBw%3D%3D)
- [Sequence Diagram](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1#R7VtNc6M4EP01PsYFEmBzHMeZmVRlq1KT3dmPy5YMsq0ZGbmEnMT761cCYRACm8TGTrLrS1AjCam73%2BtWQwbwevX8haP18hcWYzoATvw8gNMBAC4MgfyjJNtc4o%2F9XLDgJNadSsED%2BQdroaOlGxLj1OgoGKOCrE1hxJIER8KQIc7Zk9ltzqj51DVaYEvwECFqS38nsVjm0jEYlfKvmCyWxZPdIMzvrFDRWe8kXaKYPVVE8GYArzljIr9aPV9jqpRX6CUf97nl7m5hHCeiy4C7ye2Xv34E7tf44fvM%2F3vJNvfbKz3LI6IbveHfUswHIKByzslMXS3Uld6C2BZ6kbtZq8vNit6ROaYkka2JXI0gEVmjbEny3qdIMK5uYE5WWMip4ZTq%2FvelbPK0JAI%2FrFGk5nySriRlS7GisuXKS2ldgeQQvmtTitYpmWXLcaSE42jDU%2FKIv%2BE0dyIlfcRqPYh%2BomSRSJlgauJUPocki19VYwoDKWEboVZ0vXMiNVjP4zm7%2Favp8HOr%2Ft2dVSUcMJN741vZRQ8Yaz%2FQQCjc4qn0qkK0rDiUXwxD2pEXu4lLW8sLbe4XmD6wTG8ZuWKBNSOJyJbgTwb%2BtGZSxsWSLViCaNWonZTW7patmvQNRY5tRboNioR96dG1MfQ%2BFekW7YtpEn4UTY4u7JPAUuQdW5BEiu5VvAMBWikiTGbp%2BgXkfhkOb%2BTmE%2FAxCA8SsuuclZELF3mT%2Fg%2F2KtN7Y5xsA%2BCdavLypOx9GFVempXt8PawTQVe%2FTf51%2FdN%2FnW78m%2FYW9T037Crwxe5etjN1YHTmy7t48V3REmMREP6UT9tbrIzqEOSObMMgGN5PtfNUsc3pbTq80if%2Byiei%2FLgd5e1plKdE5zEn1SVQDZnlEU%2FFQrYJolxbDi6euhJzMUxRUIizJisSfl66L3ysSpmailLzXwp2%2FAI60GlBeUW0bbSTXtu62N2uKs953PX%2Fho4pQPlK%2Bi2qQJ1xWoF4gssrE1lbrlT7REBzn%2BFj5lOUva5Y1lRQfneDyzEVhe00EYw0zM7%2BJUW5TbdswGNtFxNB9PLI3zyuDxibBHCTSIynOclJydBK9xoijs0w7QZ2BFOcmKtV3pWJI5zS6lYhsogZ7N2KyfrmqIePNidEA6fFf29ZH3lDIETjAyv17nBkfwATBxejc0J2Hye4n5AFLxzEBVVnMMoask5z4SisBVFa5SmT4zHHwRCwSEIuQBCM3CcBELuxSA0eu8Qgl0h5F0SQsCuslxTIlM%2F4DBVIRNLGYWcol422QihxB8CU6MLYSq8EKSKqHpeSEkj8O0favzQCYv2n1nb9Xcdps%2F6CXlrW21VToxdDyGdQXos9lpy%2BNAfmlYGjjf0oVP%2BoDlnz1k9sMtWD%2FKwV2abt22Hy3cHa7C%2FNKCyzaAoiG6NRx5pdBiYuA7PhuuRZVxEhWXNShntM1eHi4M1slbjvP41b2BXYnaVrzOVYuyTl8YA1UEORRFeC2ynjhXV1F1%2BxmRgXJklFLbG8tYkRukyI9Cc7IqvOsYWueJnInKiDKVJ83ZBlLpZ0qRqbCuNHkmy8K%2BDmUwe2U7PpoHpRJ7brc5jTeSND0zUNwvbx5V9PtZbRXU%2FZCGsVaA6vijo7UUgtFPUbzgmXNXf1fdPAxUb6kXTPG%2FVLqs%2FbHp59nPu4mmLZY6NTLV6OOwIoJcWSmHtHXLxnDY8Wv0hqDnLvkKptSs9%2Blxohg1fuviTiHHtmKpsnxfxHJSlWruShD%2B1XFHCVZj%2BlgrOfuJrRtUXY9OEZS%2B95oTSmqjml625WFOsb%2FLPo7jDKn2Ho2HDG9uwgT6KwvPp6aPDe6wKdrVajahdMUtbyHYc1wjZgef2FrNt9VfTqaaXhFp2JI%2BMnaFM1sqfa%2BJv5A9B5a5TM2jXKB3AGiuMvE64filbeX7zcxrZ52Sk0fCdoT%2B5Tf6nDcMUDV%2FMgKa33%2F2Rhn2mspT%2F9lI12PFFt99bqnbwcMXxD%2Bnn5z9cvZ5bj64F1Xw7fCUvWvlOfaKe8x3PzndU1YivNGmplczYRjSm46TCcIUrkGy01G1TRdmydGlcF7wiPrsgMOIzHI8veaaGXc%2FUHtjLAFcy84CBWc4qFlElgeA0GYDrnegoDp3XHcXLifqvq3ngPcSA8dlCgGyW%2F5%2BTK7n8Lyd48y8%3D)
- [Activity Diagram]
- [Use case Diagram]
- [Mock-ups](https://BurndownForTrello.com/share/h1xjuy5nqy)
- [Burndown chart](https://BurndownForTrello.com/share/h1xjuy5nqy)

## 4. Links  
- [Trello](https://trello.com/b/5IFOzBDT/kanban)
- [Powerpoint](https://ecambxl-my.sharepoint.com/:p:/g/personal/17010_ecam_be/EeDnrSk-qKdOj_y_KX8ROY0BakejNwrmyFtadCIYE084iw?e=7bKNo1&wdOrigin=TEAMS-ELECTRON.teams.chiclet&wdExp=TEAMS-CONTROL&wdhostclicktime=1639677535323)
- [Report](https://ecambxl.sharepoint.com/:b:/s/AL4Tprojetclaco/ERsf_I-2rzlLnJdWnKaUstYBSvgWlyCYmcLZM368WEPePQ?e=NFKL8e)

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
1. In the source route, you will find all the files sorted by the MVC pattern :
    - The Models are in the ```com/example/al4t_claco/model/``` folder.
    - The Controllers are in the ```com/example/al4t_claco/controller/``` folder.
    - The Views are in the ```com/example/al4t_claco/view/``` folder.
2. The file ```com/example/al4t_claco/MainActivity.kt``` is not used. 
Instead, the application launches from the ```controller/LoginActivity.kt``` file.
Do mind that it is possible to change it in the ```src/main/AndroidManifest.xml```.  
3. For the moment, PDFs and resources are stored in the ```src/main/assets/``` folder.
4. The layouts of each page (called ```Activity```) are in the ```src/main/res/layout``` folder.



### 6.3. How to implement APIs
In the code, you will find multiple ```//TODO:``` comments that will propose to implement APIs, you can search those comment easily with IntelliJ or Android Studio.

### 6.4. Suggested improvements
As said before, this project lacks a lot in rigor, structure, consistensy and extensibility. Here some of the suggested improvements we came up with :
- Use Fragments instead of copy/pasting a lot of code in each activity.
- Modify the structure of the Model classes.
- Improve the MVC pattern or find a better suited one.
- Make the code more extensible and aim for a ["Glass-Box"](https://en.wikipedia.org/wiki/Extensibility)

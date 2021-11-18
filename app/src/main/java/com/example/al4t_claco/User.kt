package com.example.al4t_claco

import java.sql.Date
import java.sql.Time

abstract class User (name: String, login: String, password: String, workspace: List<Course>){
    val Name = name.uppercase();
    val Login = login;
    var Workspace = workspace
    val Schedule = Calendar(Workspace)

    private var Password = password;


    fun ModifyPassword (oldPassword: String, newPassword: String): Boolean{
        var isChanged = false
        if (oldPassword == Password){
            Password = newPassword
            isChanged = true
        }
        return isChanged
    }

    fun GetCourse(courseCode: String): String{
        //TODO: find a way to return the Course
        //TODO: replace the for loop with a if (courseCode in Workspace)
        for (course in Workspace){
            if (courseCode == course.Code){
                return course.Name
            }
        }
        return "Could not find the course that goes by the code $courseCode"
    }

    fun GetFreeClassRooms(date: Date,time: Time): Classroom{
        //TODO: see if there is a DateTime module

        return TODO()
    }

    fun GetClassroomSchedule(classroomName: String): List<Event>{

        return TODO()
    }

    fun DownladResource(activityCode: String,resourceName: String){
        //TODO: maybe put inside activities
    }




}
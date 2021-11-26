package com.example.al4t_claco.model

import java.sql.Date
import java.sql.Time

abstract class User (name: String, login: String, password: String, workspace: List<Course>){
    val name = name.uppercase();
    val login = login;
    var workspace = workspace
    val schedule = Calendar(workspace)

    private var Password = password;


    fun modifyPassword (oldPassword: String, newPassword: String): Boolean{
        var isChanged = false
        if (oldPassword == Password){
            Password = newPassword
            isChanged = true
        }
        return isChanged
    }

    fun getCourse(courseCode: String): String{
        //TODO: find a way to return the Course
        //TODO: replace the for loop with a if (courseCode in Workspace)
        for (course in workspace){
            if (courseCode == course.code){
                return course.name
            }
        }
        return "Could not find the course that goes by the code $courseCode"
    }

    fun getFreeClassRooms(date: Date,time: Time): Classroom {
        //TODO: see if there is a DateTime module

        return TODO()
    }

    fun getClassroomSchedule(classroomName: String): List<Event>{

        return TODO()
    }

    fun downladResource(activityCode: String,resourceName: String){
        //TODO: maybe put inside activities
    }




}
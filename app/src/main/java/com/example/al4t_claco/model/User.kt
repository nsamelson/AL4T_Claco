package com.example.al4t_claco.model

import java.sql.Date
import java.io.Serializable
import java.sql.Time

abstract class User (name: String, email: String, password: String, workspace: List<Course>):Serializable{
    val name = name.uppercase();
    val email = email;
    var workspace = workspace
    //val schedule = Calendar(workspace)

    var  password = password;


    fun modifyPassword (oldPassword: String, newPassword: String): Boolean{
        var isChanged = false
        if (oldPassword == password){
            password = newPassword
            isChanged = true
        }
        return isChanged
    }

    fun getCourse(courseCode: String): String{
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
        //TODO
    }




}
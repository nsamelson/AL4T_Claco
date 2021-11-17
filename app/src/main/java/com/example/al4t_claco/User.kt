package com.example.al4t_claco

import java.sql.Date
import java.sql.Time

abstract class User (name: String, login: String, password: String){
    val Name = name.uppercase();
    val Login = login;
    //val Schedule: Calendar = TODO()

    //lateinit var Workspace: List<Course>
    var Workspace = listOf<Course>(Course("test","test",3))

    protected var Password = password;

    init {
        //initializing the workspace and the schedule
    }


    fun ModifyPassword (oldPassword: String, newPassword: String): Boolean{
        if (oldPassword == Password){
            Password = newPassword
        }
        return true
    }

    fun GetCourse(courseCode: String): String{
        //TODO: find a way to return the Course
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

    fun GetClassroomSchedule(classroomName: String): Time{

        return TODO()
    }

    fun DownladResource(activityCode: String,resourceName: String){

    }




}
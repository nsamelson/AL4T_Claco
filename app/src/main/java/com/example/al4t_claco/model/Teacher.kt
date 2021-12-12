package com.example.al4t_claco.model

class Teacher(name: String, email: String, password: String, workspace: List<Course>) :
    User(name, email, password, workspace) {

    fun editCourse(courseCode: String): Boolean{
        //TODO: add parameters to what the teacher could change
        return TODO()
    }

    fun editActivity(activityCode: String): Boolean{
        return TODO()
    }

    fun addActivities(courseCode: String, activity: Activity): Boolean{
        return TODO()
    }

    fun deleteActivities(courseCode: String, activityCode: String): Boolean{
        return TODO()
    }

    fun addResource(activityCode: String, file: File): Boolean{
        return TODO()

    }
    fun deleteResource(activityCode: String, fileName: String): Boolean{
        return TODO()

    }



}
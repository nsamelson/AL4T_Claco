package com.example.al4t_claco

class Teacher(name: String, login: String, password: String, workspace: List<Course>) :
    User(name, login, password, workspace) {

    fun EditCourse(courseCode: String): Boolean{
        //TODO: add parameters to what the teacher could change
        return TODO()
    }

    fun EditActivity(activityCode: String): Boolean{
        return TODO()
    }

    fun AddActivities(courseCode: String, activity: Activity): Boolean{
        return TODO()
    }

    fun DeleteActivities(courseCode: String, activityCode: String): Boolean{
        return TODO()
    }

    fun AddResource(activityCode: String, file: File): Boolean{
        return TODO()

    }
    fun DeleteResource(activityCode: String, fileName: String): Boolean{
        return TODO()

    }



}
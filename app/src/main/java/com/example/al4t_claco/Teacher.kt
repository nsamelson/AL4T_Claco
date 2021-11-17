package com.example.al4t_claco

class Teacher(name: String, login: String, password: String) : User(name, login, password) {

    fun EditCourse(course: Course): Boolean{
        //TODO: add parameters to what the teacher could change
        return TODO()
    }

    fun AddActivities(course: Course, activity: Activity): Boolean{
        return TODO()
    }

    fun DeleteActivities(course: Course, activityCode: String): Boolean{
        return TODO()
    }

    fun AddResource(activityCode: String, file: File): Boolean{
        return TODO()

    }
    fun DeleteResource(activityCode: String, fileName: String): Boolean{
        return TODO()

    }


}
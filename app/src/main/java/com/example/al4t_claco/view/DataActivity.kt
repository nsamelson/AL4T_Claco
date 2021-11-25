package com.example.al4t_claco.view

import com.example.al4t_claco.model.Activity


data class DataActivity(private val activity: Activity, val course: String){


    val name = activity.name
    val code = activity.code
    val teachers = activity.teachers.joinToString(", ")

    val files = activity.resources





}

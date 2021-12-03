package com.example.al4t_claco.view

import com.example.al4t_claco.model.Course

data class DataCourse(private val course: Course) {

    val name = course.name
    val code = course.code
    val year = course.year.toString()
    val credits = course.credits.toString()
    val courseLeader = course.courseLeader
    val description = course.description


}
package com.example.al4t_claco.model

import java.util.*

class Calendar(val events: List<Event>) {
    val eventPerDay = events.map{ it.dateTime.toString() to it}.toMap()

    //private val courses = courses
    //val Events = Courses.flatMap { it.Activities }.flatMap { it.Events }
    /*
    private var EventList: MutableList<Event> = mutableListOf<Event>()

    init {
        for (course in Courses){
            for (activity in course.Activities){
                EventList += activity.Events
            }
        }
    }
    val Events = EventList
    */


}
package com.example.al4t_claco.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class Calendar(val events: List<Event>) {
    //val eventPerDay = events.map{ it.dateTime.toString() to it}.toMap()
    val eventsPerDay :MutableMap<LocalDate, MutableList<Event>> = HashMap()
    init {
        for(event in events){
            //val date = event.dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
            val date = event.startDate.toLocalDate()
            if(eventsPerDay.containsKey(date)){
                eventsPerDay[date]!!.add(event)
            }
            else{
                eventsPerDay[date] = mutableListOf<Event>(event)
            }


        }
    }
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
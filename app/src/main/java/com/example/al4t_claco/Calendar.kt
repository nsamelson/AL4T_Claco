package com.example.al4t_claco

class Calendar(courses: List<Course>) {
    private val Courses = courses
    // it is connected to Activity class and events
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
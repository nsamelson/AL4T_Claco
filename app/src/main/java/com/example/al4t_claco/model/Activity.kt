package com.example.al4t_claco.model

import java.io.Serializable

class Activity (name: String, code: String, teachers: List<String> , description :String): Serializable{
    val name = name
    val code = code
    val teachers = teachers
    lateinit var resources: List<File>
    var description = description
    //var Events: List<Event> = // TODO: an activity has events (implement if calendar API works like that)




}